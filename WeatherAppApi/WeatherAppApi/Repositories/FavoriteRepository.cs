using System;
using System.Collections;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Threading.Tasks;
using System.Web;
using Microsoft.AspNet.Identity;
using Microsoft.AspNet.Identity.EntityFramework;
using Thinktecture.IdentityModel.Tokens;
using WeatherAppApi.Interfaces;
using WeatherAppApi.Models;

namespace WeatherAppApi.Repositories
{
    public class FavoriteRepository : IFavoriteRepository
    {
        private AuthContext _context;
        public FavoriteRepository(AuthContext context)
        {
            this._context = context;
        }

        public async Task Save()
        {
            await _context.SaveChangesAsync();
        }

        public async Task Add(Favorite model, string id)
        {
            ApplicationUser app = _context.Users.Include(x => x.Favorite).FirstOrDefault(x => x.Id == id);
            Favorite fav = _context.Favorite.FirstOrDefault(x => x.CityName == model.CityName);
            if (fav == null)
            {
                _context.Favorite.Add(model);
            }
            app.Favorite.Add(model);
            await Save();
        }

        public async Task<IEnumerable<FavoriteDTO>> GetAll()
        {
            var list = await _context.Favorite.Include(x => x.ApplicationUser).Where(x => x.ApplicationUser.Count > 0)
                .ToListAsync();

            var dto = list.Select(x => new FavoriteDTO
            {
                CityName = x.CityName,
                Latitude = x.Latitude,
                Longitude = x.Longitude,
                Id = x.ApplicationUser.Select(a => a.Id)
            });
            return dto;

        }

        public async Task<IEnumerable<Favorite>> GetByUserId(string id)
        {
            List<Favorite> fav = new List<Favorite>();
            var list = await GetAll();
            foreach (var item in list)
            {
                foreach (var x in item.Id)
                {
                    if (x == id)
                    {
                        fav.Add(new Favorite
                        {
                            CityName = item.CityName,
                            Latitude = item.Latitude,
                            Longitude = item.Longitude
                            
                        });
                    }
                }
            }
            return fav;
        }

        public async Task Delete(string cityName)
        {
            throw new NotImplementedException();
        }
    }
}