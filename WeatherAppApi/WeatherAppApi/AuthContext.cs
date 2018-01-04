using System.Data.Entity;
using Microsoft.AspNet.Identity.EntityFramework;
using WeatherAppApi.Models;

namespace WeatherAppApi
{
    public class AuthContext : IdentityDbContext<ApplicationUser>
    {
        public AuthContext()
            : base("AuthContext")
        {
 
        }

        public DbSet<WeatherHistory> WeatherHistory { get; set; }
        public DbSet<Favorite> Favorite { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);
        }
    }
}