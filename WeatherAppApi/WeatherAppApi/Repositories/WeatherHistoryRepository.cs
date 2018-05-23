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
    public class WeatherHistoryRepository : IWeatherHistoryRepository
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
            return await _context.WeatherHistory.Where(x => x.Id == id).ToListAsync();
        }

        public async Task<IEnumerable<WeatherHistory>> Paginate(string idUser, int pageNo = 1, int pageSize = 50)
        {
            int skip = (pageNo - 1) * pageSize;


            var historyList = await _context.WeatherHistory
                .Where(x => x.Id == idUser)
                .OrderBy(c => c.WeatherId)
                .Skip(skip)
                .Take(pageSize)
                .Reverse()
                .ToListAsync();

            return historyList;
        }

        public async Task<int> TotalNumberOfRecords()
        {
            return await _context.WeatherHistory.CountAsync();
        }

        public async Task Save()
        {
            await _context.SaveChangesAsync();
        }
    }
}