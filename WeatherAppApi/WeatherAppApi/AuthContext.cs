using System.Data.Entity;
using Microsoft.AspNet.Identity.EntityFramework;
using WeatherAppApi.Models;

namespace WeatherAppApi
{
    public class AuthContext : IdentityDbContext<IdentityUser>
    {
        public AuthContext()
            : base("AuthContext")
        {
 
        }

        public DbSet<WeatherHistory> WeatherHistory { get; set; }
    }
}