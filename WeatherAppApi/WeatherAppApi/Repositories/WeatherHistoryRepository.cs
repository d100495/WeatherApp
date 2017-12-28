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
    public class WeatherHistoryRepository: IWeatherHistoryRepository
    {
        private AuthContext _context;

        public WeatherHistoryRepository(AuthContext authContext)
        {
            this._context = authContext;
        }


        public async Task Add(WeatherHistory model)
        {
            _context.WeatherHistory.Add(model);
              await Save();
        }

        public async Task<IEnumerable<WeatherHistory>> GetByUserId(string id)
        {
            return await _context.WeatherHistory.Where(x => x.UserId == id).ToListAsync();
        }

        public async Task Save()
        {
           await _context.SaveChangesAsync();
        }
    }
}