using Microsoft.AspNet.Identity;
using System;
using System.Threading.Tasks;
using WeatherAppApi.Models;

namespace WeatherAppApi.Interfaces
{
    public interface IAuthRepository : IDisposable
    {
        Task<IdentityResult> RegisterUser(UserModel userModel);
        Task<ApplicationUser> FindUser(string userName, string password);
        Task<ApplicationUser> FindById(string id);
        string GetUserId();
        void Dispose();
    }
}