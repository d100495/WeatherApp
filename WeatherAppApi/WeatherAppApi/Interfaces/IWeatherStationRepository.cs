using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
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
