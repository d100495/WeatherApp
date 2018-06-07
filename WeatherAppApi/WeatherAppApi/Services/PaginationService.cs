using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Web.Http.Routing;
using WeatherAppApi.Interfaces;
using WeatherAppApi.Models.Pagination;

namespace WeatherAppApi.Services
{
    public class PaginationService<T> : IPaginationService<T> where T : class
    {
        private IPageLinkBuilderFactory pageLinkFactory;

        public PaginationService(IPageLinkBuilderFactory _pageLinkFactory)
        {
            pageLinkFactory = _pageLinkFactory;
        }


        private IEnumerable<T> Paginate(IEnumerable<T> data, int pageNo = 1, int pageSize = 50)
        {
            int skip = (pageNo - 1) * pageSize;

            var list = data
                .Skip(skip)
                .Take(pageSize)
                .ToList();
            return list;
        }

        public PaginationModel<T> GetPageLinks(UrlHelper urlHelper, IEnumerable<T> data, string routeName, object routeValues, int pageNo = 1, int pageSize = 50)
        {
            var list = Paginate(data.Reverse(), pageNo, pageSize);
            var total = data.Count();
            var linkBuilder = pageLinkFactory.Create(urlHelper, routeName, routeValues, pageNo, pageSize,
                total);
            return new PaginationModel<T>()
            {
                PageData = list,
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