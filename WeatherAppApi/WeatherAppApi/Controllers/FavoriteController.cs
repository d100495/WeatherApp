using Microsoft.AspNet.Identity;
using System.Threading.Tasks;
using System.Web.Http;
using WeatherAppApi.Interfaces;
using WeatherAppApi.Models;

namespace WeatherAppApi.Controllers
{
    public class FavoriteController : ApiController
    {
        private readonly IFavoriteRepository favoriteRepository;
        private IAuthRepository authRepository;
        public FavoriteController(IFavoriteRepository _favoriteRepository, IAuthRepository _authRepository)
        {
            authRepository = _authRepository;   
            favoriteRepository = _favoriteRepository;
        }

        [HttpPost]
        [Authorize]
        public async Task<IHttpActionResult> AddToFavorite(WeatherStation model)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest("model cannot be null");
            }
            var id = authRepository.GetUserId();
            await favoriteRepository.Add(model, id);
            return Ok();
        }

        [HttpGet]
        [Authorize]
        public async Task<IHttpActionResult> GetByUserId()
        {
            var id = authRepository.GetUserId();
            var items = await favoriteRepository.GetByUserId(id);
            return Ok(items);
        }

        [HttpGet]
        public async Task<IHttpActionResult> GetAll()
        {
            var items = await favoriteRepository.GetAll();
            return Ok(items);
        }


        [HttpDelete]
        [Authorize]
        public async Task<IHttpActionResult> DeleteById(int id)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest("weather station id cannot be null");
            }
            var userId = authRepository.GetUserId();
            await favoriteRepository.Delete(id, userId);
            return Ok();
        }
    }
}