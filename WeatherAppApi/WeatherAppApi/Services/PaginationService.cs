using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Policy;
using System.Threading.Tasks;
using System.Web;
using System.Web.Http.Routing;
using WeatherAppApi.Interfaces;
using WeatherAppApi.Models;
using WeatherAppApi.Models.Pagination;

namespace WeatherAppApi.Services
{
    public class PaginationService<T> : IPaginationService<T> where T : class
    {
        private IPagination<T> pagination;
        private IPageLinkBuilderFactory pageLinkBuilderFactory;
        public PaginationService(IPagination<T> _pagination, IPageLinkBuilderFactory _pageLinkBuilderFactory)
        {
            pagination = _pagination;
            pageLinkBuilderFactory = _pageLinkBuilderFactory;
        }

        private async Task<int> TotalPages()
        {
            return await pagination.TotalNumberOfRecords();
        }

        public async Task<PaginationModel<T>> GetPageLinks(string idUser, UrlHelper urlHelper, IEnumerable<T> data, int pageNo = 1, int pageSize = 50)
        {
            var total = await TotalPages();
            var linkBuilder = pageLinkBuilderFactory.Create(urlHelper, "GetWeatherByUserId", null, pageNo, pageSize,
                total);
            return new PaginationModel<T>()
            {
                PageData = data,
                Paging = new PageLinks()
                {
                    First = linkBuilder.FirstPage,
                    Last = linkBuilder.LastPage,
                    Previous = linkBuilder.PreviousPage,
                    Next = linkBuilder.NextPage
                }
            };
        }
    }
}