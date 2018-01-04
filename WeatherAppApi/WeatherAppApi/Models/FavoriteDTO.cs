using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WeatherAppApi.Models
{
    public class FavoriteDTO
    {
        public string CityName { get; set; }
        public IEnumerable<string> Id { get; set; }
    }
}