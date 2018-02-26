using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

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