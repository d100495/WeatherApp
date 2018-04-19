using System;
using Microsoft.AspNet.Identity;
using Microsoft.AspNet.Identity.EntityFramework;
using System.Threading.Tasks;
using WeatherAppApi.Interfaces;
using WeatherAppApi.Models;

namespace WeatherAppApi.Repositories
{
    public class AuthRepository : IAuthRepository
    {
        private AuthContext _ctx;
 
        private UserManager<ApplicationUser> _userManager;
 
        public AuthRepository()
        {
            _ctx = new AuthContext();
            _userManager = new UserManager<ApplicationUser>(new UserStore<ApplicationUser>(_ctx));
        }

        public string GetUserId()
        {
            var id =  System.Web.HttpContext.Current.User.Identity.GetUserId();
            if (id == null)
            {
                throw new InvalidOperationException("User not exist");
            }
            return id;

        }

        public async Task<IdentityResult> RegisterUser(UserModel userModel)
        {
            ApplicationUser user = new ApplicationUser()
            {
                UserName = userModel.UserName
            };
 
            var result = await _userManager.CreateAsync(user, userModel.Password);
 
            return result;
        }
 
        public async Task<ApplicationUser> FindUser(string userName, string password)
        {
            ApplicationUser user = (ApplicationUser) await _userManager.FindAsync(userName, password);
            return user;
        }

        public async Task<ApplicationUser> FindById(string id)
        {
            ApplicationUser user = await _userManager.FindByIdAsync(id);
            return user;
        }
      
        public void Dispose()
        {
            _ctx.Dispose();
            _userManager.Dispose();
 
        }
    }
}