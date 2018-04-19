using System.Collections.Generic;
using System.Threading.Tasks;
using System.Web.Http.Routing;
using WeatherAppApi.Interfaces;
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

        public async Task<int> TotalPages()
        {
            return await pagination.TotalNumberOfRecords();
        }

        public async Task<PaginationModel<T>> GetPageLinks(UrlHelper urlHelper, IEnumerable<T> data, int pageNo = 1, int pageSize = 50)
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