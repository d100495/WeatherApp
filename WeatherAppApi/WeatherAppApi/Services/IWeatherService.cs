namespace WeatherAppApi.Services
{
    public interface IWeatherService
    {
        double WindChill(double temperature, double windSpeed);
    }
}