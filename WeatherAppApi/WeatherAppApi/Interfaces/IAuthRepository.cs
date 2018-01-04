using System;
using System.Threading.Tasks;
using Microsoft.AspNet.Identity;
using Microsoft.AspNet.Identity.EntityFramework;
using WeatherAppApi.Models;

namespace WeatherAppApi.Interfaces
{
    public interface IAuthRepository : IDisposable
    {
        Task<IdentityResult> RegisterUser(UserModel userModel);
        Task<ApplicationUser> FindUser(string userName, string password);
        Task<ApplicationUser> FindById(string id);
        void Dispose();
    }
}