using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using System.Web.Http.Routing;
using WeatherAppApi.Models;
using WeatherAppApi.Models.Pagination;

namespace WeatherAppApi.Services
{
    public interface IWeatherHistoryService
    {
        Task AddHistory(Weather model);
        Task<IEnumerable<WeatherHistory>> GetAllWeatherHistoryByUserId();
        Task<IEnumerable<WeatherHistory>> GetWeatherHistoryByDate(DateTime date);
        Task<PaginationModel<WeatherHistory>> GetPagedWeatherHistoryByUserId(UrlHelper url, string routeName, int pageNo = 1,
            int pageSize = 50);
    }
}