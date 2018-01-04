using Microsoft.Owin;
using Microsoft.Owin.Security.OAuth;
using Ninject.Web.Common.OwinHost;
using Ninject.Web.WebApi.OwinHost;
using Owin;
using System;
using System.Web.Http;
using Newtonsoft.Json;
using WeatherAppApi.App_Start;
using WeatherAppApi.Providers;

[assembly: OwinStartup(typeof(WeatherAppApi.Startup))]
namespace WeatherAppApi
{
    public class Startup
    {
        public void Configuration(IAppBuilder app)
        { 
            app.UseCors(Microsoft.Owin.Cors.CorsOptions.AllowAll);
            ConfigureOAuth(app);
            AutoMapperConfig.Initialize();
            HttpConfiguration config = new HttpConfiguration();
            WebApiConfig.Register(config);
            app.UseNinjectMiddleware(NinjectWebCommon.CreateKernel).UseNinjectWebApi(config);
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