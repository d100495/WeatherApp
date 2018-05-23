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
        private IWeatherHistoryService weatherHistoryService;

        public WeatherHistoryController(IWeatherHistoryService _weatherHistoryService)
        {
            weatherHistoryService = _weatherHistoryService;
        }


        [HttpPost]
        [Authorize]
        public async Task<IHttpActionResult> PostHistory(Weather model)
        {
            if (model == null)
            {
                return BadRequest("model cannot be null");
            }
            if (!ModelState.IsValid)
            {
                return BadRequest("model is not valid");
            }
        
            await weatherHistoryService.AddHistory(model);
            return Ok();
        }

        [HttpGet]
        [Authorize]
        [Route("api/weatherhistory/GetPagedWeatherHistoryByUserId", Name = "GetWeatherByUserId")]
        public async Task<IHttpActionResult> GetPagedWeatherHistoryByUserId(int pageNo = 1, int pageSize = 50)
        {
            var model = await weatherHistoryService.GetPagedWeatherHistoryByUserId(Url, "GetWeatherByUserId",pageNo, pageSize);
            return Ok(model);
        }

        [HttpGet]
        [Authorize]
        public async Task<IHttpActionResult> GetAllWeatherHistoryByUserId()
        {
            var list = await weatherHistoryService.GetAllWeatherHistoryByUserId();
            return Ok(list);
        }
    }
}