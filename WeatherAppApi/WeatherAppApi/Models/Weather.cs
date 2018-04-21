namespace WeatherAppApi.Models
{
    public class Weather
    {
        public double Longitude { get;set; }
        public double Latitude { get; set; }
        public double Temperature { get; set; }
        public double Pressure { get; set; }
        public double WindSpeed { get; set; }
        public double WindChill { get; set; }
    }
}