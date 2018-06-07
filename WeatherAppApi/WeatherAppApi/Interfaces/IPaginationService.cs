using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using System.Web.Http.Routing;
using WeatherAppApi.Models;
using WeatherAppApi.Models.Pagination;

namespace WeatherAppApi.Interfaces
{
    public interface IPaginationService<T> where T : class
    {
        PaginationModel<T> GetPageLinks(UrlHelper urlHelper,  IEnumerable<T> data, string routeName, object routeValues, int pageNo = 1, int pageSize = 50);
    }
}