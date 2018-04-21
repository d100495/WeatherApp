using System.Collections.Generic;
using System.Threading.Tasks;

namespace WeatherAppApi.Interfaces
{
    public interface IPagination<T>
    {
        Task<IEnumerable<T>> Paginate(string idUser, int pageNo = 1, int pageSize = 50);
        Task<int> TotalNumberOfRecords();
    }
}
