using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
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
    }
}
