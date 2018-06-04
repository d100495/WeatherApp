namespace WeatherAppApi.Services
{
    public interface IHttpService<T> where T : class
    {
        T HttpGet(string url);
    }
}