using Newtonsoft.Json;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;

namespace WeatherAppApi.Models
{
    public class WeatherStation
    {
        [Key]
        public int WeatherStationId { get; set; }
        public string CityName { get;set; }
        public double Longitude { get; set; }
        public double Latitude { get; set; }
        [JsonIgnore]
        public virtual ICollection<ApplicationUser> ApplicationUsers { get; set; }

        public WeatherStation()
        {
            this.ApplicationUsers = new HashSet<ApplicationUser>();
        }
    }
}