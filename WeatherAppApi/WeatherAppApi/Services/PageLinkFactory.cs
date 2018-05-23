using System.Web.Http.Routing;
using WeatherAppApi.Interfaces;

namespace WeatherAppApi.Services
{
    public class PageLinkFactory
    {
        private IPageLinkBuilderFactory _pageLinkBuilderFactory;
        public PageLinkFactory(IPageLinkBuilderFactory pageLinkBuilderFactory)
        {
            _pageLinkBuilderFactory = pageLinkBuilderFactory;
        }

        public IPageLinkBuilder Create(UrlHelper urlHelper, string routeName, object routeValues, int pageNo,
            int pageSize, long totalRecordCount)
        {
            return _pageLinkBuilderFactory.Create(urlHelper, routeName, routeValues, pageNo,
                pageSize, totalRecordCount);
        }
    }
}