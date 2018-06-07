using Microsoft.VisualStudio.TestTools.UnitTesting;
using WeatherAppApi.Services;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WeatherAppApi.Services.Tests
{
    [TestClass()]
    public class WeatherServiceTests
    {
        private IWeatherService weatherService { get;set; }

        [TestInitialize]
        public void Setup()
        {
            weatherService = new WeatherService();
        }

        [TestMethod()]
        public void WindChillTest()
        {
           double result =  weatherService.WindChill(10, 100);
           
            Assert.AreEqual(-4,result);

        }

        [TestMethod]
        public void WindChillTest_when_temp_is_under_zero()
        {
            double result =  weatherService.WindChill(-10, 100);

            Assert.AreEqual(-36, result);
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentOutOfRangeException), "windSpeed must be greater than 0")]
        public void WindChill_should_throw_ArgumentOutOfRangeException_when_windSpeed_is_smaller_than_zero()
        {
            double result = weatherService.WindChill(10, -10);

            Assert.AreEqual(1,result);
        }
    }
}