using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Threading.Tasks;
using WeatherAppApi.Interfaces;
using WeatherAppApi.Models;

namespace WeatherAppApi.Repositories
{
    public class FavoriteRepository : IFavoriteRepository
    {
        private readonly AuthContext _context;
        public FavoriteRepository(AuthContext context)
        {
            _context = context;
        }

        public async Task Save()
        {
            await _context.SaveChangesAsync();
        }

        public async Task Add(WeatherStation model, string idUser)
        {
              ApplicationUser user = _context.Users.Include(x => x.WeatherStations).FirstOrDefault(x => x.Id == idUser);
            WeatherStation weatherStation =
                _context.WeatherStation.FirstOrDefault(x => x.WeatherStationId == model.WeatherStationId);
              user?.WeatherStations.Add(weatherStation);
              await Save();
              
           
        }

        public async Task<IEnumerable<FavoriteWeatherStation>> GetAll()
        {
            var list = await _context.WeatherStation.Include(x => x.ApplicationUsers).Where(x => x.ApplicationUsers.Count > 0)
                .ToListAsync();

            var dto = list.Select(x => new FavoriteWeatherStation()
            {
                FavoriteWeatherStationId = x.WeatherStationId,
                CityName = x.CityName,
                Latitude = x.Latitude,
                Longitude = x.Longitude,
                Id = x.ApplicationUsers.Select(a => a.Id)
            });
            return dto;

        }

        public async Task<IEnumerable<WeatherStation>> GetByUserId(string id)
        {
            List<WeatherStation> fav = new List<WeatherStation>();
            var list = await GetAll();
            foreach (var item in list)
            {
                foreach (var x in item.Id)
                {
                    if (x == id)
                    {
                        fav.Add(new WeatherStation()
                        {
                            WeatherStationId = item.FavoriteWeatherStationId,
                            CityName = item.CityName,
                            Latitude = item.Latitude,
                            Longitude = item.Longitude

                        });
                    }
                }
            }
            return fav;
        }

        public async Task Delete(int weatherStationId, string userId)
        {
            ApplicationUser user = _context.Users.Include(x => x.WeatherStations).FirstOrDefault(x => x.Id == userId);
            WeatherStation weatherStation = _context.WeatherStation.FirstOrDefault(x => x.WeatherStationId == weatherStationId);
            if (user != null)
                user.WeatherStations.Remove(weatherStation);
            await Save();
        }
    }
}