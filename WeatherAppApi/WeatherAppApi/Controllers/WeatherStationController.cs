using System.Threading.Tasks;
using System.Web.Http;
using WeatherAppApi.Interfaces;

namespace WeatherAppApi.Controllers
{
    public class WeatherStationController : ApiController
    {
        private IWeatherStationRepository weatherStationRepository;

        public WeatherStationController(IWeatherStationRepository _stationRepository)
        {
            weatherStationRepository = _stationRepository;
        }

        [HttpGet]
        [Authorize]
        public async Task<IHttpActionResult> GetAll()
        {
            var list = await weatherStationRepository.GetAll();
            return Ok(list);
        } 
    }
}
