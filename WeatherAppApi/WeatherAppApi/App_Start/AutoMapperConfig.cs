using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using AutoMapper;
using WeatherAppApi.Models;

namespace WeatherAppApi.App_Start
{
    public class AutoMapperConfig
    {
        
            public static void Initialize()
            {
                Mapper.Initialize((config) =>
                {
                    config.CreateMap<Weather, WeatherHistory>().ReverseMap();
                });
            }
       
    }
}