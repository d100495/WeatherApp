using AutoMapper;
using Newtonsoft.Json;
using System;
using System.IO;
using System.Net;
using System.Threading.Tasks;
using WeatherAppApi.Interfaces;
using WeatherAppApi.JsonDeserializeModels;
using WeatherAppApi.Models;
using Weather = WeatherAppApi.Models.Weather;

namespace WeatherAppApi.Services
{


    public class FavoritesService : IFavoritesService
    {
        private readonly IFavoriteRepository favoriteRepository;
        private readonly IWeatherHistoryRepository weatherHistoryRepository;
        private readonly IAuthRepository authRepository;
        private string openWatherMapsApiKey = "&APPID=409014fbcefa18db869de6c154c71e71";


        public FavoritesService(IFavoriteRepository _repo, IWeatherHistoryRepository _historyRepository, IAuthRepository _authRepository)
        {
            favoriteRepository = _repo;
            weatherHistoryRepository = _historyRepository;
            authRepository = _authRepository;
        }

        public async Task GetWeatherFromFavoritesList()
        {
            var list = await favoriteRepository.GetAll();
            foreach (var item in list)
            {
                HttpWebRequest request = (HttpWebRequest)WebRequest.Create("http://api.openweathermap.org/data/2.5/weather?q=" + item.CityName + "&units=metric"
                 + openWatherMapsApiKey);

                var webResponse = (HttpWebResponse)request.GetResponse();
                var reader = new StreamReader(webResponse.GetResponseStream() ?? throw new InvalidOperationException());
                string s = reader.ReadToEnd();
                var json = JsonConvert.DeserializeObject<WeatherJson>(s);
                var weather = Mapper.Map<WeatherJson, Weather>(json);
                weather.WindChill = Math.Round(33 + (0.478 + 0.237 * Math.Sqrt(weather.WindSpeed) - 0.0124 * weather.WindSpeed)
                                   * (weather.Temperature - 33)) * 100 / 100;
                foreach (var user in item.Id)
                {
                    WeatherHistory weatherHistory = Mapper.Map<Weather, WeatherHistory>(weather);
                    weatherHistory.Id = user;
                    weatherHistory.Date = DateTime.Now;
                    await weatherHistoryRepository.Add(weatherHistory);
                    await weatherHistoryRepository.Save();
                }

            }
        }
    }
}