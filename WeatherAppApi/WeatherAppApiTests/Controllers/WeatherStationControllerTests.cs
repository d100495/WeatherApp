using Microsoft.VisualStudio.TestTools.UnitTesting;
using WeatherAppApi.Controllers;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Web.Http.Results;
using Moq;
using WeatherAppApi.Interfaces;
using WeatherAppApi.Models;

namespace WeatherAppApi.Controllers.Tests
{
    [TestClass()]
    public class WeatherStationControllerTests
    {
        private Mock<IWeatherStationRepository> _weatherStationRepositoryMock { get; set; }
        private WeatherStationController WeatherStationController;
        private readonly List<WeatherStation> _list = new List<WeatherStation>()
        {
            new WeatherStation()
            {
                CityName = "Krakow",
                Latitude = 1,
                Longitude = 1,
                WeatherStationId = 2
            },
            new WeatherStation()
            {
                CityName = "Krakow",
                Latitude = 1,
                Longitude = 1,
                WeatherStationId = 4
            }
        };
        [TestInitialize()]
        public void Setup()
        {
            _weatherStationRepositoryMock = new Mock<IWeatherStationRepository>();
            WeatherStationController = new WeatherStationController(_weatherStationRepositoryMock.Object);
        }

        [TestMethod()]
        public async Task GetAll_should_return_ok()
        {
            _weatherStationRepositoryMock.Setup(x => x.GetAll()).ReturnsAsync(_list);

            var actionResult = await WeatherStationController.GetAll();
            var contentResult =  actionResult as OkNegotiatedContentResult<IEnumerable<WeatherStation>>;

            Assert.IsNotNull(actionResult);
            Assert.IsNotNull(contentResult);
            Assert.IsInstanceOfType(actionResult, typeof(OkNegotiatedContentResult<IEnumerable<WeatherStation>>));
            Assert.AreEqual(_list, contentResult.Content);
        }
    }
}