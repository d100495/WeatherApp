using Microsoft.Web.Infrastructure.DynamicModuleHelper;
using Ninject;
using Ninject.Web.Common;
using Ninject.Web.Common.WebHost;
using System;
using System.Web;
using Hangfire;
using WeatherAppApi;
using WeatherAppApi.Interfaces;
using WeatherAppApi.Repositories;
using WeatherAppApi.Services;

[assembly: WebActivatorEx.PreApplicationStartMethod(typeof(NinjectWebCommon), "Start")]
[assembly: WebActivatorEx.ApplicationShutdownMethodAttribute(typeof(NinjectWebCommon), "Stop")]
namespace WeatherAppApi
{

    public static class NinjectWebCommon
    {
        private static readonly Bootstrapper bootstrapper = new Bootstrapper();

        public static void Start()
        {
            DynamicModuleUtility.RegisterModule(typeof(OnePerRequestHttpModule));
            DynamicModuleUtility.RegisterModule(typeof(NinjectHttpModule));
            bootstrapper.Initialize(CreateKernel);
        }

        public static void Stop()
        {
            bootstrapper.ShutDown();
        }

        public static IKernel CreateKernel()
        {
            var kernel = new StandardKernel();
            kernel.Bind<Func<IKernel>>().ToMethod(ctx => () => new Bootstrapper().Kernel);
            kernel.Bind<IHttpModule>().To<HttpApplicationInitializationHttpModule>();
            RegisterServices(kernel);
         
            return kernel;
        }
        private static void RegisterServices(IKernel kernel)
        {
            System.Web.Http.GlobalConfiguration.Configuration.DependencyResolver = new Ninject.WebApi.DependencyResolver.NinjectDependencyResolver(kernel);
            GlobalConfiguration.Configuration.UseNinjectActivator(kernel);

            kernel.Bind<IWeatherHistoryRepository>().To<WeatherHistoryRepository>();
            kernel.Bind<IAuthRepository>().To<AuthRepository>();
            kernel.Bind<IFavoriteRepository>().To<FavoriteRepository>();
            kernel.Bind<IFavoritesService>().To<FavoritesService>();
        }
    }
}