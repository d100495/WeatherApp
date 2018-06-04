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
        private readonly IWeatherService weatherService;
        private readonly IHttpService<WeatherJson> httpService;
        private string openWatherMapsApiKey = "&APPID=409014fbcefa18db869de6c154c71e71";


        public FavoritesService(IFavoriteRepository _repo, IWeatherHistoryRepository _historyRepository, IWeatherService _weatherService,
            IHttpService<WeatherJson> _httpService)
        {
            favoriteRepository = _repo;
            weatherHistoryRepository = _historyRepository;
            weatherService = _weatherService;
            httpService = _httpService;
        }

        public async Task GetWeatherFromFavoritesList()
        {
            var list = await favoriteRepository.GetAll();
            foreach (var item in list)
            {
                var json = httpService.HttpGet("http://api.openweathermap.org/data/2.5/weather?q=" + item.CityName +
                                               "&units=metric"
                                               + openWatherMapsApiKey);

                var weather = Mapper.Map<WeatherJson, Weather>(json);
                weather.WindChill = weatherService.WindChill(weather.Temperature, weather.WindSpeed);
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