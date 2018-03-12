using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Threading.Tasks;
using System.Web;
using AutoMapper;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using WeatherAppApi.Interfaces;
using WeatherAppApi.JsonDeserializeModels;
using WeatherAppApi.Models;
using Weather = WeatherAppApi.Models.Weather;

namespace WeatherAppApi.Services
{


    public class FavoritesService : IFavoritesService
    {
        private readonly IFavoriteRepository _favoriteRepository;
        private readonly IWeatherHistoryRepository _weatherHistoryRepository;
        private string openWatherMapsApiKey = "&APPID=409014fbcefa18db869de6c154c71e71";


        public FavoritesService(IFavoriteRepository _repo, IWeatherHistoryRepository _historyRepo)
        {
            _favoriteRepository = _repo;
            _weatherHistoryRepository = _historyRepo;
        }

        public async Task GetWeatherFromFavoritesList()
        {
            var list = await _favoriteRepository.GetAll();
            foreach (var item in list)
            {
                HttpWebRequest request = (HttpWebRequest)WebRequest.Create("http://api.openweathermap.org/data/2.5/weather?q=" + item.CityName + "&units=metric"
                 + openWatherMapsApiKey);

                var webResponse = (HttpWebResponse)request.GetResponse();
                var reader = new StreamReader(webResponse.GetResponseStream());
                string s = reader.ReadToEnd();
                var json = JsonConvert.DeserializeObject<WeatherJson>(s);
                Weather weather = new Weather();
                weather = Mapper.Map<WeatherJson, Weather>(json);
                weather.WindChill = Math.Round(33 + (0.478 + 0.237 * Math.Sqrt(weather.WindSpeed) - 0.0124 * weather.WindSpeed)
                                   * (weather.Temperature - 33)) * 100 / 100;
                foreach (var user in item.Id)
                {
                    WeatherHistory weatherHistory = Mapper.Map<Weather, WeatherHistory>(weather);
                    weatherHistory.Id = user;
                    weatherHistory.Date = DateTime.Now;
                    await _weatherHistoryRepository.Add(weatherHistory);
                    await _weatherHistoryRepository.Save();
                }

            }
        }


    }
}