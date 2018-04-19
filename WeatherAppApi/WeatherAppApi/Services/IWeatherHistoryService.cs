using System.Collections.Generic;
using System.Threading.Tasks;
using WeatherAppApi.Models;

namespace WeatherAppApi.Services
{
    public interface IWeatherHistoryService
    {
        Task AddHistory(Weather model);
        Task<IEnumerable<WeatherHistory>> GetAllWeatherHistoryByUserId();
    }
}