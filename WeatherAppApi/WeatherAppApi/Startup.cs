using Hangfire;
using Microsoft.Owin;
using Microsoft.Owin.Security.OAuth;
using Ninject.Web.Common.OwinHost;
using Ninject.Web.WebApi.OwinHost;
using Owin;
using System;
using System.Web.Http;
using System.Web.Http.Cors;
using WeatherAppApi.App_Start;
using WeatherAppApi.Providers;
using WeatherAppApi.Services;

[assembly: OwinStartup(typeof(WeatherAppApi.Startup))]

namespace WeatherAppApi
{
    public class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            HttpConfiguration config = new HttpConfiguration();
          
            WebApiConfig.Register(config);
            var db = new HangfireContext();
            app.UseCors(Microsoft.Owin.Cors.CorsOptions.AllowAll);

            ConfigureOAuth(app);
           // app.UseWebApi(config);
            AutoMapperConfig.Initialize();
           
            app.UseNinjectMiddleware(NinjectWebCommon.CreateKernel).UseNinjectWebApi(config);
            Hangfire.GlobalConfiguration.Configuration.UseSqlServerStorage(db.Database.Connection.ConnectionString);
            app.UseHangfireDashboard();
            app.UseHangfireServer();
            RecurringJob.AddOrUpdate<FavoritesService>(x => x.GetWeatherFromFavoritesList(), Cron.Minutely);
        }

        public void ConfigureOAuth(IAppBuilder app)
        {
            OAuthAuthorizationServerOptions OAuthServerOptions = new OAuthAuthorizationServerOptions()
            {
                AllowInsecureHttp = true,
                TokenEndpointPath = new PathString("/token"),
                AccessTokenExpireTimeSpan = TimeSpan.FromDays(1),
                Provider = new SimpleAuthorizationServerProvider()
            };

            // Token Generation
            app.UseOAuthAuthorizationServer(OAuthServerOptions);
            app.UseOAuthBearerAuthentication(new OAuthBearerAuthenticationOptions());
        }
    }
}