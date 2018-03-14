using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Threading.Tasks;
using System.Web.Http;
using WeatherAppApi.Interfaces;

namespace WeatherAppApi.Controllers
{
    public class WeatherStationController : ApiController
    {
        private IWeatherStationRepository _weatherStationRepository;

        public WeatherStationController(IWeatherStationRepository _stationRepository)
        {
            _weatherStationRepository = _stationRepository;
        }

        [HttpGet]
        [Authorize]
        public async Task<IHttpActionResult> GetAll()
        {
            var list = await _weatherStationRepository.GetAll();
            return Ok(list);
        } 
    }
}
