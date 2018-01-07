using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;
using Newtonsoft.Json;

namespace WeatherAppApi.Models
{
    public class WeatherHistory
    {
        [Key]
        public int WeatherId { get; set; }
        public double Longitude { get;set; }
        public double Latitude { get; set; }
        public double Temperature { get; set; }
        public double Pressure { get; set; }
        public double WindSpeed { get; set; }
        public double WindChill { get; set; }
        public DateTime Date { get;set; }
        public string Id { get; set; }
        [JsonIgnore]
        public virtual ApplicationUser ApplicationUser { get; set; }

    }
}