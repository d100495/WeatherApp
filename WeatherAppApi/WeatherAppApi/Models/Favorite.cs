using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;
using Newtonsoft.Json;

namespace WeatherAppApi.Models
{
    public class Favorite
    {
        [Key]
        public int FavoriteId { get; set; }
        public string CityName { get;set; }
        public double Longitude { get; set; }
        public double Latitude { get; set; }
        [JsonIgnore]
        public virtual ICollection<ApplicationUser> ApplicationUser { get; set; }

        public Favorite()
        {
            this.ApplicationUser = new HashSet<ApplicationUser>();
        }
    }
}