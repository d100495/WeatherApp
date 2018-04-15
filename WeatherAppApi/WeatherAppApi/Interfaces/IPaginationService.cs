using System.Collections.Generic;
using System.Threading.Tasks;
using System.Web.Http.Routing;
using WeatherAppApi.Models;
using WeatherAppApi.Models.Pagination;

namespace WeatherAppApi.Interfaces
{
    public interface IPaginationService<T> where T : class
    {
        Task<PaginationModel<T>> GetPageLinks(string idUser, UrlHelper urlHelper,  IEnumerable<T> data,int pageNo = 1, int pageSize = 50);
    }
}