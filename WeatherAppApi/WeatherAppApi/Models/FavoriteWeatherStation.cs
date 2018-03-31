﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WeatherAppApi.Models
{
    public class FavoriteWeatherStation
    {
        public int FavoriteWeatherStationId { get; set; }
        public string CityName { get; set; }
        public double Longitude { get; set; }
        public double Latitude { get; set; }
        public IEnumerable<string> Id { get; set; }
    }
}