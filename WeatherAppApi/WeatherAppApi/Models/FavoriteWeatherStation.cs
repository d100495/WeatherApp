using System.Collections.Generic;

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