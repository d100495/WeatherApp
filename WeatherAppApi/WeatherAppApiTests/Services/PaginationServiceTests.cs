using System;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Moq;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Hosting;
using System.Web.Http.Routing;
using WeatherAppApi.Interfaces;
using WeatherAppApi.Models;

namespace WeatherAppApi.Services.Tests
{
    [TestClass()]
    public class PaginationServiceTests
    {
        private Mock<IPageLinkBuilderFactory> pageLinkBuilderFactory { get; set; }
        private PaginationService<WeatherHistory> paginationService { get; set; }
        private UrlHelper urlHelper;
        private List<WeatherHistory> list { get; set; }
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
            pageLinkBuilderFactory = new Mock<IPageLinkBuilderFactory>();
            list = new List<WeatherHistory>();
            
            for (int i = 0; i < 20; i++)
            {
                list.Add(new WeatherHistory());
            }
        }

        [TestMethod]
        public void GetPageLinks_should_return_10_records()
        {
            Mock<IPageLinkBuilder> pageLinkBuilderMock = new Mock<IPageLinkBuilder>();
          
            pageLinkBuilderFactory.Setup(x => x.Create(urlHelper, It.IsAny<string>(), It.IsAny<object>(), It.IsAny<int>(), It.IsAny<int>(), 20))
                .Returns(pageLinkBuilderMock.Object);
            paginationService = new PaginationService<WeatherHistory>(pageLinkBuilderFactory.Object);

            var result = paginationService.GetPageLinks(urlHelper, list.ToList(), "GetWeatherByUserId",null, 1, 10);

            pageLinkBuilderFactory.Verify();
            Assert.AreEqual(10, result.PageData.Count());
        }
    }
}