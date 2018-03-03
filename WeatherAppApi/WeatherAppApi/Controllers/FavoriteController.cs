using System.Collections.Generic;
using System.Threading.Tasks;
using System.Web.Http;
using Microsoft.AspNet.Identity;
using WeatherAppApi.Interfaces;
using WeatherAppApi.Models;

namespace WeatherAppApi.Controllers
{
    public class FavoriteController : ApiController
    {
        private readonly IFavoriteRepository _favoriteRepository;
        private IFavoritesService _favoritesService;
        public FavoriteController(IFavoriteRepository repo, IFavoritesService dupa)
        {
            _favoriteRepository = repo;
            _favoritesService = dupa;
        }

        [HttpPost]
        [Authorize]
        public async Task<IHttpActionResult> AddToFavorite(Favorite model)
        {
            if (!ModelState.IsValid)
                return BadRequest();
            var id = User.Identity.GetUserId();
            if (id == null)
            {
                return NotFound();
            }
            await _favoriteRepository.Add(model, id);
            return Ok();
        }

        [HttpGet]
        [Authorize]
        public async Task<IHttpActionResult> GetByUserId()
        {
            var id = User.Identity.GetUserId();
            if (id == null)
            {
                return NotFound();
            }
            var items = await _favoriteRepository.GetByUserId(id);
            return Ok(items);
        }

        [HttpGet]
        public async Task<IHttpActionResult> GetAll()
        {
            var items = await _favoriteRepository.GetAll();
            return Ok(items);
        }


        [HttpDelete]
        [Authorize]
        public async Task<IHttpActionResult> DeleteById(int id)
        {
            if (!ModelState.IsValid)
                return BadRequest();
            var userId = User.Identity.GetUserId();
            await _favoriteRepository.Delete(id, userId);
            return Ok();
        }
    }
}