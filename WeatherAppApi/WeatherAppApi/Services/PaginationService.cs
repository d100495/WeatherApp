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
        private IPageLinkBuilderFactory pageLinkFactory;

        public PaginationService(IPagination<T> _pagination, IPageLinkBuilderFactory _pageLinkFactory)
        {
            pagination = _pagination;
            pageLinkFactory = _pageLinkFactory;
        }

        public async Task<int> TotalPages()
        {
            return await pagination.TotalNumberOfRecords();
        }

        public async Task<PaginationModel<T>> GetPageLinks(UrlHelper urlHelper, IEnumerable<T> data, string routeName, int pageNo = 1, int pageSize = 50)
        {
            var total = await TotalPages();
            var linkBuilder = pageLinkFactory.Create(urlHelper, routeName, null, pageNo, pageSize,
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