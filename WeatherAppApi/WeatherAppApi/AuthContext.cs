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

        public virtual DbSet<WeatherHistory> WeatherHistory { get; set; }
        public DbSet<WeatherStation> WeatherStation { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);
            modelBuilder.Entity<ApplicationUser>()
                .HasMany<WeatherStation>(w => w.WeatherStations)
                .WithMany(a => a.ApplicationUsers)
                .Map(wa =>
                {
                    wa.MapLeftKey("Id");
                    wa.MapRightKey("WeatherStationId");
                    wa.ToTable("FavoriteWeatherStations");

                });
        }
    }
}