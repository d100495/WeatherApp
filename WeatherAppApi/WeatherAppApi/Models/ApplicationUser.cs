using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Microsoft.AspNet.Identity.EntityFramework;
using Newtonsoft.Json;

namespace WeatherAppApi.Models
{
    public class ApplicationUser : IdentityUser
    {
        public ICollection<WeatherHistory> WeatherHistory { get; set; }
    
        public ICollection<Favorite> Favorite { get; set; }

        public ApplicationUser()
        {
            this.Favorite = new HashSet<Favorite>();
        }
    }
}