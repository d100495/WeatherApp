using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WeatherAppApi.Services
{
    public class WeatherService : IWeatherService
    {
        public double WindChill(double temperature, double windSpeed)
        {
            if (windSpeed < 0)
            {
                throw new ArgumentOutOfRangeException(null, "windSpeed must be greater than 0");
            }
            return  Math.Round(33 + (0.478 + 0.237 * Math.Sqrt(windSpeed) - 0.0124 * windSpeed)
                               * (temperature - 33)) * 100 / 100;
        }
    }
}