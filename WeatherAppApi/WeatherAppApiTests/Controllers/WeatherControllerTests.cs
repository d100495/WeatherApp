﻿using System;
using System.Collections.Generic;
using System.Net;
using System.Security.Claims;
using System.Security.Principal;
using System.Threading.Tasks;
using System.Web.Http;
using System.Web.Http.Results;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Moq;
using WeatherAppApi.App_Start;
using WeatherAppApi.Controllers;
using WeatherAppApi.Interfaces;
using WeatherAppApi.Models;

namespace WeatherAppApiTests.Controllers
{
    [TestClass]
    public class WeatherControllerTests
    {
        private Mock<IWeatherHistoryRepository> _weatherHistoryRepositoryMock { get; set; }
        private Mock<IPaginationService<WeatherHistory>> _paginationServiceMock { get; set; }
        private WeatherHistoryController _weatherController;

        [TestInitialize]
        public void Setup()
        {
            _weatherHistoryRepositoryMock = new Mock<IWeatherHistoryRepository>();
            _paginationServiceMock = new Mock<IPaginationService<WeatherHistory>>();
            _weatherController = new WeatherHistoryController(_weatherHistoryRepositoryMock.Object, _paginationServiceMock.Object);
        }

        [TestMethod]
        public async Task PostHistory_should_return_ok()
        {
            AutoMapperConfig.Initialize();

            var weather = new Weather
            {
                Latitude = 20,
                Longitude = 10,
                Pressure = 1000,
                Temperature = -20,
                WindChill = 20,
                WindSpeed = 30
            };

            var actionResult = await _weatherController.PostHistory(weather);
            Assert.IsInstanceOfType(actionResult, typeof(OkResult));
        }

        [TestMethod]
        public async Task PostHistory_should_return_badRequest_when_model_is_null()
        {
            Weather weather = null;
            var actionResult = await _weatherController.PostHistory(weather);
            Assert.IsInstanceOfType(actionResult, typeof(BadRequestResult));
        }


        [TestMethod]
        public async Task GetWeatherByUserId_should_return_Ok()
        {
            var list = new List<WeatherHistory>
            {
                new WeatherHistory
                {
                    Latitude = 10,
                    Longitude = 10,
                    Date = new DateTime(2000, 10, 20),
                    Id = "dsad",
                    Temperature = 10,
                    Pressure = 20,
                    WindSpeed = 20,
                    WindChill = 20
                },
                new WeatherHistory
                {
                    Latitude = 10,
                    Longitude = 10,
                    Date = new DateTime(2000, 10, 20),
                    Id = "dsad",
                    Temperature = 10,
                    Pressure = 20,
                    WindSpeed = 20,
                    WindChill = 20
                }
            };


            var claims = new List<Claim>
            {
                new Claim(ClaimTypes.Name, "Testname"),
                new Claim(ClaimTypes.NameIdentifier, "1")
            };
            var identity = new ClaimsIdentity(claims);
            IPrincipal user = new ClaimsPrincipal(identity);
            _weatherController.User = user;
            _weatherHistoryRepositoryMock.Setup(x => x.GetByUserId(It.IsAny<string>())).ReturnsAsync(list);
            var actionResult = await _weatherController.GetAllWeatherHistoryByUserId();
            var contentResult = actionResult as OkNegotiatedContentResult<IEnumerable<WeatherHistory>>;

            Assert.IsNotNull(actionResult);
            Assert.IsNotNull(contentResult);
            Assert.IsInstanceOfType(actionResult, typeof(OkNegotiatedContentResult<IEnumerable<WeatherHistory>>));
            Assert.AreEqual(list, contentResult.Content);
        }

        [TestMethod]
        public async Task GetWeatherByUserId_should_return_notFound_when_user_is_not_logged()
        {
            var actionResult = await _weatherController.GetAllWeatherHistoryByUserId();
            
            Assert.IsInstanceOfType(actionResult, typeof(NotFoundResult));
        }
    }


    
}