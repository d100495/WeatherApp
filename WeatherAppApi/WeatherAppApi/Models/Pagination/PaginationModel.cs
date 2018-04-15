using System.Collections.Generic;

namespace WeatherAppApi.Models.Pagination
{
    public class PaginationModel<T>
    {
        public IEnumerable<T> PageData { get; set; }
        public PageLinks Paging { get; set; }
    }
}