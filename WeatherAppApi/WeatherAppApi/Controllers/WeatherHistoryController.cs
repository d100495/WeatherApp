using AutoMapper;
using Microsoft.AspNet.Identity;
using System;
using System.Threading.Tasks;
using System.Web.Http;
using WeatherAppApi.Interfaces;
using WeatherAppApi.Models;
using WeatherAppApi.Services;

namespace WeatherAppApi.Controllers
{

    public class WeatherHistoryController : ApiController
    {
        private IWeatherHistoryRepository historyRepository;
        private IPaginationService<WeatherHistory> paginationService;
        private IAuthRepository authRepository;
        private IWeatherHistoryService weatherHistoryService;
        public WeatherHistoryController(IWeatherHistoryRepository _weatherHistoryRepository, IPaginationService<WeatherHistory> _paginationService, IWeatherHistoryService _weatherHistoryService,
            IAuthRepository _authRepository)
        {
            historyRepository = _weatherHistoryRepository;
            paginationService = _paginationService;
            authRepository = _authRepository;
            weatherHistoryService = _weatherHistoryService;
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
                return BadRequest("model cannot be null");
            }
            await weatherHistoryService.AddHistory(model); 
            return Ok();
        }

        [HttpGet]
        [Authorize]
        [Route("api/weatherhistory/GetPagedWeatherHistoryByUserId", Name = "GetWeatherByUserId")]
        public async Task<IHttpActionResult> GetPagedWeatherHistoryByUserId(int pageNo = 1, int pageSize = 50)
        {
                string id = authRepository.GetUserId();
                var data = await historyRepository.Paginate(id, pageNo, pageSize);
                var model = await paginationService.GetPageLinks(Url, data, pageNo, pageSize);
                return Ok(model);
        }

        [HttpGet]
        [Authorize]
        public async Task<IHttpActionResult> GetAllWeatherHistoryByUserId()
        {
            var list = weatherHistoryService.GetAllWeatherHistoryByUserId();
            return Ok(list);
        }

}
}
