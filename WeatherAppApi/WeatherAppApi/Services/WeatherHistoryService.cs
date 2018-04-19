using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Policy;
using System.Threading.Tasks;
using System.Web;
using System.Web.Http;
using AutoMapper;
using WeatherAppApi.Interfaces;
using WeatherAppApi.Models;

namespace WeatherAppApi.Services
{
    public class WeatherHistoryService : IWeatherHistoryService
    {
        private IWeatherHistoryRepository weatherHistoryRepository;
        private IAuthRepository authRepository;
      
        public WeatherHistoryService(IWeatherHistoryRepository _weatherHistoryRepository, IAuthRepository _authRepository)
        {
            weatherHistoryRepository = _weatherHistoryRepository;
            authRepository = _authRepository;
        }

        public async Task AddHistory(Weather model)
        {
            WeatherHistory weatherHistory = Mapper.Map<Weather, WeatherHistory>(model);
            weatherHistory.Id = authRepository.GetUserId();
            await weatherHistoryRepository.Add(weatherHistory);
            await weatherHistoryRepository.Save();
        }

        public async Task<IEnumerable<WeatherHistory>> GetAllWeatherHistoryByUserId()
        {
            var id = authRepository.GetUserId();
            return await weatherHistoryRepository.GetByUserId(id);
        }
    }
}