using Microsoft.AspNet.Identity.EntityFramework;
using System.Collections.Generic;

namespace WeatherAppApi.Models
{
    public class ApplicationUser : IdentityUser
    {
        public ICollection<WeatherHistory> WeatherHistory { get; set; }
    
        public ICollection<WeatherStation> WeatherStations { get; set; }

        public ApplicationUser()
        {
            this.WeatherStations = new HashSet<WeatherStation>();
        }
    }
}