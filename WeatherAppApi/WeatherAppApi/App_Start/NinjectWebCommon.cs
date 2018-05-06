using Microsoft.Web.Infrastructure.DynamicModuleHelper;
using Ninject;
using Ninject.Web.Common;
using Ninject.Web.Common.WebHost;
using System;
using System.Web;
using Hangfire;
using Ninject.Extensions.Factory;
using WeatherAppApi;
using WeatherAppApi.Interfaces;
using WeatherAppApi.Models;
using WeatherAppApi.Models.Pagination;
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

            kernel.Bind<IWeatherHistoryRepository>().To<WeatherHistoryRepository>().InSingletonScope();
            kernel.Bind<IAuthRepository>().To<AuthRepository>();
            kernel.Bind<IFavoriteRepository>().To<FavoriteRepository>();
            kernel.Bind<IFavoritesService>().To<FavoritesService>();
            kernel.Bind<IWeatherStationRepository>().To<WeatherStationRepository>();
            kernel.Bind(typeof(IPaginationService<>)).To(typeof(PaginationService<>));
            kernel.Bind<IPagination<WeatherHistory>>().To<WeatherHistoryRepository>().InSingletonScope();
            kernel.Bind<IPageLinkBuilder>().To<PageLinkBuilder>();
            kernel.Bind<IPageLinkBuilderFactory>().ToFactory();
            kernel.Bind<IWeatherHistoryService>().To<WeatherHistoryService>();
            kernel.Bind<IPageLinkFactory>().To<PageLinkFactory>();
        }
    }
}