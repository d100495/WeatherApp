using System;
using System.Web.Http.Routing;
using WeatherAppApi.Interfaces;

namespace WeatherAppApi.Models.Pagination
{
    public class PageLinkBuilder : IPageLinkBuilder
    {
        public Uri FirstPage { get;  set; }
        public Uri LastPage { get;  set; }
        public Uri NextPage { get;  set; }
        public Uri PreviousPage { get;  set; }

        public PageLinkBuilder(UrlHelper urlHelper, string routeName, object routeValues, int pageNo, int pageSize, long totalRecordCount)
        {
            var pageCount = totalRecordCount > 0
                ? (int) Math.Ceiling(totalRecordCount/(double) pageSize)
                : 0;

            FirstPage = new Uri(urlHelper.Link(routeName, new HttpRouteValueDictionary(routeValues)
            {
                {"pageNo", 1},
                {"pageSize", pageSize}
            }));
            LastPage = new Uri(urlHelper.Link(routeName, new HttpRouteValueDictionary(routeValues)
            {
                {"pageNo", pageCount},
                {"pageSize", pageSize}
            }));
            if (pageNo > 1)
            {
                PreviousPage = new Uri(urlHelper.Link(routeName, new HttpRouteValueDictionary(routeValues)
                {
                    {"pageNo", pageNo - 1},
                    {"pageSize", pageSize}
                }));
            }
            if (pageNo < pageCount)
            {
                NextPage = new Uri(urlHelper.Link(routeName, new HttpRouteValueDictionary(routeValues)
                {
                    {"pageNo", pageNo + 1},
                    {"pageSize", pageSize}
                }));
            }
        }
    }
}