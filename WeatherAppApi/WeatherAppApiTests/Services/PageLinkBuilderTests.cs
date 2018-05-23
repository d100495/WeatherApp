using Microsoft.VisualStudio.TestTools.UnitTesting;
using WeatherAppApi.Services;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using System.Web.Http;
using System.Web.Http.Hosting;
using System.Web.Http.Routing;
using System.Web.Routing;
using Moq;

namespace WeatherAppApi.Services.Tests
{
    [TestClass()]
    public class PageLinkBuilderTests
    {
        private UrlHelper urlHelper;
        private PageLinkBuilder pageLinkBuilder;
        [TestInitialize]
        public void Startup()
        {
            var routeCollection = new HttpRouteCollection();
            routeCollection.MapHttpRoute("GetWeatherByUserId", "GetWeatherByUserId");
            var configuration = new HttpConfiguration(routeCollection);
            configuration.EnsureInitialized();
            var httpRequestMessage = 
                new HttpRequestMessage(HttpMethod.Get, "http://localhost/");
            httpRequestMessage
                .Properties
                .Add(HttpPropertyKeys.HttpConfigurationKey, configuration);
            urlHelper = new UrlHelper(httpRequestMessage);
        }

        [TestMethod()]
        public void Set_pageNo_2_should_build_all_urls()
        {
            pageLinkBuilder = new PageLinkBuilder(urlHelper, "GetWeatherByUserId", null, 2, 5, 15);

            Uri firstPageExpected = new Uri("http://localhost/GetWeatherByUserId?pageNo=1&pageSize=5");
            Uri lastPageExpected = new Uri("http://localhost/GetWeatherByUserId?pageNo=3&pageSize=5");
            Uri nextPageExpected = new Uri("http://localhost/GetWeatherByUserId?pageNo=3&pageSize=5");
            Uri previousPageExpected = new Uri("http://localhost/GetWeatherByUserId?pageNo=1&pageSize=5");

            Uri firstPage = pageLinkBuilder.FirstPage;
            Uri lastPage = pageLinkBuilder.LastPage;
            Uri nextPage = pageLinkBuilder.NextPage;
            Uri previousPase = pageLinkBuilder.PreviousPage;


            Assert.AreEqual(firstPageExpected, firstPage);
            Assert.AreEqual(lastPageExpected, lastPage);
            Assert.AreEqual(nextPageExpected, nextPage);
            Assert.AreEqual(previousPageExpected, previousPase);
            
        }
    }
}