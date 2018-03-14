using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Threading.Tasks;
using System.Web;
using WeatherAppApi.Interfaces;
using WeatherAppApi.Models;

namespace WeatherAppApi.Repositories
{
    public class WeatherStationRepository : IWeatherStationRepository
    {
        private AuthContext _context;

        public WeatherStationRepository(AuthContext context)
        {
            _context = context;
        }

        public async Task Save()
        {
           await _context.SaveChangesAsync();
        }

        public async Task Add(WeatherStation model)
        {
             _context.WeatherStation.Add(model);
            await Save();
        }

        public async Task<IEnumerable<WeatherStation>> GetAll()
        {
            var list = await _context.WeatherStation.ToListAsync();
            return list;
        }

        public async Task Delete(int weatherStationId)
        {
            WeatherStation weatherStation = await 
                _context.WeatherStation.FirstOrDefaultAsync(x => x.WeatherStationId == weatherStationId);\
            await Save();
        }
    }
}