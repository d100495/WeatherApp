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
    public class PageLinkBuilderFactory : IPageLinkBuilderFactory
    {
        private IResolutionRoot resolutionRoot;
        public PageLinkBuilderFactory(IResolutionRoot _resolutionRoot)
        {
            resolutionRoot = _resolutionRoot;
        }

        public IPageLinkBuilder Create(UrlHelper urlHelper, string routeName, object routeValues, int pageNo,
            int pageSize, long totalRecordCount)
        {
            return resolutionRoot.Get<IPageLinkBuilder>(
                new ConstructorArgument("urlHelper", urlHelper),
                new ConstructorArgument("routeName", routeName),
                new ConstructorArgument("routeValues", routeValues),
                new ConstructorArgument("pageNo", pageNo),
                new ConstructorArgument("totalRecordsCount", totalRecordCount)
            );

        }
    }
}