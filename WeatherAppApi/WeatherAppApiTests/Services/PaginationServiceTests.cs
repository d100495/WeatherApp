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
using Ninject;
using Ninject.Extensions.Factory;
using Ninject.Syntax;
using WeatherAppApi.Interfaces;
using WeatherAppApi.Models;
using WeatherAppApi.Models.Pagination;

namespace WeatherAppApi.Services.Tests
{
    [TestClass()]
    public class PaginationServiceTests
    {
        private Mock<IPagination<WeatherHistory>> pagination;
        private Mock<IPageLinkBuilderFactory> pageLinkFactory;
        private PaginationService<WeatherHistory> paginationService;
        private UrlHelper urlHelper;

        [TestInitialize]
        public void Startup()
        {
            pageLinkFactory = new Mock<IPageLinkBuilderFactory>();
            pagination = new Mock<IPagination<WeatherHistory>>();

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
        public async Task Call_TotalPages_should_invoke_TotalNumberOfRecords()
        {
            paginationService = new PaginationService<WeatherHistory>(pagination.Object, pageLinkFactory.Object);
            await paginationService.TotalPages();

            pagination.Verify(x => x.TotalNumberOfRecords(), Times.Once);
        }


        [TestMethod()]
        public async Task TotalPagesTest()
        {
            pagination.Setup(x => x.TotalNumberOfRecords()).ReturnsAsync(50);
            paginationService = new PaginationService<WeatherHistory>(pagination.Object, pageLinkFactory.Object);

            var expected = await pagination.Object.TotalNumberOfRecords();
            var result = await paginationService.TotalPages();

            Assert.AreEqual(expected, result);
        }

    }
}