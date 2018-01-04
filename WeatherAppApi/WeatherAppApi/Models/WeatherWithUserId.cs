using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WeatherAppApi.Models
{
    public class WeatherWithUserId: Weather
    {
        public string Id { get; set; }
    }
}