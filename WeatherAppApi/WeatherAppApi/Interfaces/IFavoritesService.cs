using System.Threading.Tasks;

namespace WeatherAppApi.Interfaces
{
    public interface IFavoritesService
    {
        Task GetWeatherFromFavoritesList();
    }
}
