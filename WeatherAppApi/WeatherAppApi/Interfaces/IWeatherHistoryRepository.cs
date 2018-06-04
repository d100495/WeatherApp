using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using WeatherAppApi.Models;

namespace WeatherAppApi.Interfaces
{
    public interface IWeatherHistoryRepository : IPagination<WeatherHistory>
    {
        Task Add(WeatherHistory model);
        Task<IEnumerable<WeatherHistory>> GetByUserId(string id);
        Task<IEnumerable<WeatherHistory>> GetByDate(string id, DateTime date);
        Task<IEnumerable<WeatherHistory>> GetAll();
        Task Save();
    }
}
