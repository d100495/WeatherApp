using System.Web.Http.Routing;
using WeatherAppApi.Interfaces;

namespace WeatherAppApi.Models.Pagination
{
    public interface IPageLinkFactory
    {
        IPageLinkBuilder Create(UrlHelper urlHelper, string routeName, object routeValues, int pageNo,
            int pageSize, long totalRecordCount);
    }
}