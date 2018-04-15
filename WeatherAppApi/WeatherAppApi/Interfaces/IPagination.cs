using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WeatherAppApi.Models;

namespace WeatherAppApi.Interfaces
{
    public interface IPagination<T>
    {
        Task<IEnumerable<T>> Paginate(string idUser, int pageNo = 1, int pageSize = 50);
        Task<int> TotalNumberOfRecords();
    }
}
