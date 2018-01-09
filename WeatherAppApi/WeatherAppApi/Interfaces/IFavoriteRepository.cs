using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WeatherAppApi.Models;

namespace WeatherAppApi.Interfaces
{
   public interface IFavoriteRepository
    {
        Task Save();
        Task Add(Favorite model, string id);
        Task<IEnumerable<FavoriteDTO>> GetAll();
        Task<IEnumerable<Favorite>> GetByUserId(string id);
        Task Delete(int favId, string userId);
    }
}
