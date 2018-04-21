using System.Data.Entity;

namespace WeatherAppApi
{
    public class HangfireContext : DbContext
    {
        public HangfireContext() : base("HangfireContext")
        {
            Database.SetInitializer<HangfireContext>(null);
            Database.CreateIfNotExists();
        }
    }
}