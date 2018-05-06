using System.Collections.Generic;
using System.Threading.Tasks;
using WeatherAppApi.Models;

namespace WeatherAppApi.Interfaces
{
    public interface IFavoriteRepository
    {
        Task Save();
        Task Add(WeatherStation model, string id);
        Task<IEnumerable<FavoriteWeatherStation>> GetAll();
        Task<IEnumerable<WeatherStation>> GetByUserId(string id);
        Task Delete(int weatherStationId, string userId);
        Task<bool> AddFavoriteStationValidator(WeatherStation model, string id);
    }
}
