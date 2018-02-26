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
            await _favoriteRepository.Add(model, id);
            return Ok();
        }

        [HttpGet]
        [Authorize]
        public async Task<IEnumerable<Favorite>> GetByUserId()
        {
            var id = User.Identity.GetUserId();
            var items = await _favoriteRepository.GetByUserId(id);
            return items;
        }

        [HttpGet]
        public async Task<IEnumerable<FavoriteDTO>> GetAll()
        {
            var items = await _favoriteRepository.GetAll();
            return items;
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