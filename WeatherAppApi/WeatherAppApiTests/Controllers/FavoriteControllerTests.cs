using Microsoft.VisualStudio.TestTools.UnitTesting;
using WeatherAppApi.Controllers;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Security.Claims;
using System.Security.Principal;
using System.Text;
using System.Threading.Tasks;
using System.Web.Http.Results;
using Moq;
using WeatherAppApi.Interfaces;
using WeatherAppApi.Models;
using WeatherAppApi.Repositories;

namespace WeatherAppApi.Controllers.Tests
{
    [TestClass()]
    public class FavoriteControllerTests
    {
        private Mock<IFavoriteRepository> _favoriteRepositoryMock { get; set; }
        private Mock<IAuthRepository> _authRepositoryMock;
        private FavoriteController FavoriteController { get; set; }

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

        [TestInitialize]
        public void Setup()
        {
            _favoriteRepositoryMock = new Mock<IFavoriteRepository>();
            _authRepositoryMock = new Mock<IAuthRepository>();
            FavoriteController = new FavoriteController(_favoriteRepositoryMock.Object, _authRepositoryMock.Object);
        }

        [TestMethod]
        public async Task AddToFavorite_should_return_ok()
        {
            WeatherStation model = new WeatherStation()
            {
                CityName = "Krakow",
                Latitude = 1,
                Longitude = 1,
                WeatherStationId = 2
            };

            _favoriteRepositoryMock.Setup(x => x.AddFavoriteStationValidator(model, It.IsAny<string>()))
                .ReturnsAsync(true);
            var actionResult = await FavoriteController.AddToFavorite(model);

            Assert.IsInstanceOfType(actionResult, typeof(OkResult));
        }

        [TestMethod]
        public async Task AddToFavorite_should_return_BadRequest_when_argument_is_null()
        {
            WeatherStation model = null;

            var actionResult = await FavoriteController.AddToFavorite(model) as BadRequestErrorMessageResult;

            Assert.IsInstanceOfType(actionResult, typeof(BadRequestErrorMessageResult));
            Assert.AreEqual(actionResult.Message, "model cannot be null");
        }

        [TestMethod]
        public async Task AddToFavorite_should_return_BadRequest_when_there_is_same_weather_station_in_database()
        {
            WeatherStation model = new WeatherStation()
            {
                CityName = "Krakow",
                Latitude = 1,
                Longitude = 1,
                WeatherStationId = 2
            };

            _favoriteRepositoryMock.Setup(x => x.AddFavoriteStationValidator(model, It.IsAny<string>()))
                .ReturnsAsync(false);
            var actionResult = await FavoriteController.AddToFavorite(model) as BadRequestErrorMessageResult;

            Assert.IsInstanceOfType(actionResult, typeof(BadRequestErrorMessageResult));
            Assert.AreEqual(actionResult.Message, "There is already same weather station");
        }

        [TestMethod]
        public async Task GetByUserId_should_return_ok_with_body()
        {
            _favoriteRepositoryMock.Setup(x => x.GetByUserId(It.IsAny<string>())).ReturnsAsync(_list);


            var actionResult = await FavoriteController.GetByUserId();
            var contentResult = actionResult as OkNegotiatedContentResult<IEnumerable<WeatherStation>>;

            Assert.IsNotNull(actionResult);
            Assert.IsNotNull(contentResult);
            Assert.IsInstanceOfType(actionResult, typeof(OkNegotiatedContentResult<IEnumerable<WeatherStation>>));
            Assert.AreEqual(_list, contentResult.Content);
        }

        [TestMethod]
        public async Task DeleteById_should_return_ok()
        {
            var actionResult = await FavoriteController.DeleteById(1);

            Assert.IsInstanceOfType(actionResult, typeof(OkResult));
        }
    }
}