using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Security.Claims;
using System.Threading.Tasks;
using System.Web;
using System.Web.Http;
using AutoMapper;
using Microsoft.AspNet.Identity;
using Microsoft.AspNet.Identity.EntityFramework;
using Microsoft.AspNet.Identity.Owin;
using WeatherAppApi.Interfaces;
using WeatherAppApi.Models;
using WeatherAppApi.Repositories;

namespace WeatherAppApi.Controllers
{
   
    public class WeatherController : ApiController
    {
        private IWeatherHistoryRepository _historyRepository;
       
        public WeatherController(IWeatherHistoryRepository weatherHistoryRepository)
        {
            _historyRepository = weatherHistoryRepository;
        }
    
        
        [HttpPost]
        [Authorize]
        public async Task<IHttpActionResult> PostHistory(Weather model)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest();
            }
            WeatherHistory weatherHistory = Mapper.Map<Weather, WeatherHistory>(model);
            weatherHistory.Id = User.Identity.GetUserId();
            weatherHistory.Date = DateTime.Now;
            await _historyRepository.Add(weatherHistory);
            await _historyRepository.Save();
            return Ok();
        }

        [HttpGet]
        [Authorize]
        public async Task<IEnumerable<WeatherHistory>> GetWeatherByUserId()
        {
            string id = User.Identity.GetUserId();
            if (id != null)
            {
                return await _historyRepository.GetByUserId(id);
            }
            else
            {
                throw new HttpResponseException(HttpStatusCode.NotFound);
            }
        }

        //public async Task<IHttpActionResult> PostHistoryFromFavorite(WeatherHistory model)
        //{
        //    if (!ModelState.IsValid)
        //    {
        //        return BadRequest();
        //    }
        //    WeatherHistory weatherHistory = Mapper.Map<WeatherHistory, WeatherHistory>(model);
        //    weatherHistory.Date = DateTime.Now;
        //    await _historyRepository.Add(weatherHistory);
        //    await _historyRepository.Save();
        //    return Ok();
        //}
}
}
