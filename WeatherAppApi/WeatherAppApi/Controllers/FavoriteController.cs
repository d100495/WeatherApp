using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Threading.Tasks;
using System.Web.Http;
using Microsoft.AspNet.Identity;
using WeatherAppApi.Interfaces;
using WeatherAppApi.Models;

namespace WeatherAppApi.Controllers
{
    public class FavoriteController : ApiController
    {
        private IFavoriteRepository _favoriteRepository;

        public FavoriteController(IFavoriteRepository repo)
        {
            _favoriteRepository = repo;
        }

        [HttpPost]
        [Authorize]
        public async Task<IHttpActionResult> AddToFavorite(Favorite model)
        {
            string id = User.Identity.GetUserId();
            await _favoriteRepository.Add(model, id);
            return Ok();
        }

        [HttpGet]
        [Authorize]
        public async Task<IEnumerable<Favorite>> GetByUserId()
        {
            string id = User.Identity.GetUserId();
            var items = await _favoriteRepository.GetByUserId(id);
            return items;
        }

        [HttpGet]
        public async Task<IEnumerable<FavoriteDTO>> GetAll()
        {
            var items = await _favoriteRepository.GetAll();
            return items;
        }
    }
}
