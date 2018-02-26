using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using AutoMapper;
using WeatherAppApi.JsonDeserializeModels;
using WeatherAppApi.Models;
using Weather = WeatherAppApi.Models.Weather;

namespace WeatherAppApi.App_Start
{
    public class AutoMapperConfig
    {
        
            public static void Initialize()
            {
                Mapper.Initialize((config) =>
                {
                    config.CreateMap<Weather, WeatherHistory>().ReverseMap();
                    config.CreateMap<WeatherJson, Weather>()
                        .ForMember(dest => dest.Temperature, opt => opt.MapFrom(src => src.main.temp))
                        .ForMember(dest => dest.Pressure, opt => opt.MapFrom(src => src.main.pressure))
                        .ForMember(dest => dest.Longitude, opt => opt.MapFrom(src => src.coord.lon))
                        .ForMember(dest => dest.Latitude, opt => opt.MapFrom(src => src.coord.lat))
                        .ForMember(dest => dest.WindSpeed, opt => opt.MapFrom(src => src.wind.speed));
                    //config.CreateMap<WeatherWithUserId, WeatherHistory>().ReverseMap();
                });
            }
       
    }
}