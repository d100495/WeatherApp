using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Http.Routing;
using Ninject;
using Ninject.Parameters;
using Ninject.Syntax;
using WeatherAppApi.Interfaces;

namespace WeatherAppApi.Models.Pagination
{
    public class PageLinkFactory : IPageLinkFactory
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