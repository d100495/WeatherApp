using AutoMapper;
using Microsoft.AspNet.Identity;
using System;
using System.Threading.Tasks;
using System.Web.Http;
using WeatherAppApi.Interfaces;
using WeatherAppApi.Models;

namespace WeatherAppApi.Controllers
{

    public class WeatherHistoryController : ApiController
    {
        private IWeatherHistoryRepository historyRepository;
        private IPaginationService<WeatherHistory> paginationService;
        public WeatherHistoryController(IWeatherHistoryRepository _weatherHistoryRepository, IPaginationService<WeatherHistory> _paginationService)
        {
            historyRepository = _weatherHistoryRepository;
            paginationService = _paginationService;
        }
    
        
        [HttpPost]
        [Authorize]
        public async Task<IHttpActionResult> PostHistory(Weather model)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest();
            }
            if (model == null)
            {
                return BadRequest();
            }
            WeatherHistory weatherHistory = Mapper.Map<Weather, WeatherHistory>(model);
            weatherHistory.Id = User.Identity.GetUserId();
            weatherHistory.Date = DateTime.Now;
            await historyRepository.Add(weatherHistory);
            await historyRepository.Save();
            return Ok();
        }

        [HttpGet]
        [Authorize]
        [Route("api/weatherhistory/GetWeatherByUserId", Name = "GetWeatherByUserId")]
        public async Task<IHttpActionResult> GetPagedWeatherHistoryByUserId(int pageNo = 1, int pageSize = 50)
        {
            string id = User.Identity.GetUserId();
            if (id != null)
            {
                var data = await historyRepository.Paginate(id, pageNo, pageSize);
                var model = await paginationService.GetPageLinks(id, Url, data, pageNo, pageSize);
                return Ok(model);
            }
            else
            {
                return NotFound();
            }
        }

        [HttpGet]
        [Authorize]
        public async Task<IHttpActionResult> GetAllWeatherHistoryByUserId()
        {
            string id = User.Identity.GetUserId();
            if (id != null)
            {
                var list = await historyRepository.GetByUserId(id);
                return Ok(list);
            }
            else
            {
                return NotFound();
            }
        }

}
}
