using System.Web.Http.Routing;

namespace WeatherAppApi.Interfaces
{
    public interface IPageLinkBuilderFactory
    {
        IPageLinkBuilder Create(UrlHelper urlHelper, string routeName, object routeValues, int pageNo,
            int pageSize, long totalRecordCount);
    }
}