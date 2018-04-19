using System.Collections.Generic;
using System.Threading.Tasks;
using WeatherAppApi.Models;

namespace WeatherAppApi.Interfaces
{
    public interface IWeatherStationRepository
    {
        Task Save();
        Task Add(WeatherStation model);
        Task<IEnumerable<WeatherStation>> GetAll();
        Task Delete(int weatherStationId);
    }
}
