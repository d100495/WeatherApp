using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Policy;
using System.Threading.Tasks;
using System.Web;
using System.Web.Http;
using System.Web.Http.Routing;
using AutoMapper;
using WeatherAppApi.Interfaces;
using WeatherAppApi.Models;
using WeatherAppApi.Models.Pagination;

namespace WeatherAppApi.Services
{
    public class WeatherHistoryService : IWeatherHistoryService
    {
        private IWeatherHistoryRepository weatherHistoryRepository;
        private IAuthRepository authRepository;
        private IPaginationService<WeatherHistory> paginationService;     
        
        public WeatherHistoryService(IWeatherHistoryRepository _weatherHistoryRepository, IAuthRepository _authRepository, IPaginationService<WeatherHistory> _paginationService)
        {
            weatherHistoryRepository = _weatherHistoryRepository;
            authRepository = _authRepository;
            paginationService = _paginationService;
        }

        public async Task AddHistory(Weather model)
        {
            WeatherHistory weatherHistory = Mapper.Map<Weather, WeatherHistory>(model);
            weatherHistory.Date = DateTime.Now;
            weatherHistory.Id = authRepository.GetUserId();
            await weatherHistoryRepository.Add(weatherHistory);
        }

        public async Task<IEnumerable<WeatherHistory>> GetAllWeatherHistoryByUserId()
        {
            var id = authRepository.GetUserId();
            return await weatherHistoryRepository.GetByUserId(id);
        }

        public async Task<IEnumerable<WeatherHistory>> GetWeatherHistoryByDate(DateTime date)
        {
            var id = authRepository.GetUserId();
            return await weatherHistoryRepository.GetByDate(id, date);
        }

        public async Task<PaginationModel<WeatherHistory>> GetPagedWeatherHistoryByUserId(UrlHelper url, string routeName, int pageNo = 1, int pageSize = 50)
        {
            string id = authRepository.GetUserId();
            var data = await weatherHistoryRepository.GetByUserId(id);
            var model = paginationService.GetPageLinks(url, data, routeName, null, pageNo, pageSize);
            return model;
        }

        public async Task<PaginationModel<WeatherHistory>> GetPagedWeatherHistoryByDate(DateTime myDate, UrlHelper url, string routeName,
            int pageNo = 1, int pageSize = 50)
        {
            string id = authRepository.GetUserId();
            var data = await weatherHistoryRepository.GetByDate(id,myDate);
            var model = paginationService.GetPageLinks(url, data, routeName, new {date = myDate}, pageNo, pageSize);
            return model;
        }
    }
}