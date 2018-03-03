using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Threading.Tasks;
using System.Web.Http;
using Microsoft.AspNet.Identity;
using Microsoft.AspNet.Identity.EntityFramework;
using WeatherAppApi.Interfaces;
using WeatherAppApi.Models;
using WeatherAppApi.Repositories;

namespace WeatherAppApi.Controllers
{
    [RoutePrefix("api/Account")]
    public class AccountController : ApiController
    {
        private IAuthRepository _repo;
 
        public AccountController(IAuthRepository _authRepository)
        {
            _repo = _authRepository;
        }

       
        // POST api/Account/Register
        [AllowAnonymous]
        [Route("Register")]
        public async Task<IHttpActionResult> Register(UserModel userModel)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }
 
            IdentityResult result = await _repo.RegisterUser(userModel);
 
            IHttpActionResult errorResult = GetErrorResult(result);
 
            if (errorResult != null)
            {
                return errorResult;
            }
 
            return Ok(userModel);
        }

        [HttpGet]
        public async Task<IHttpActionResult> GetUserInfo()
        {
            string userId = User.Identity.GetUserId();
            if (userId == null)
            {
                return NotFound();
            }
            var user =  await _repo.FindById(userId);
            return Ok(user);

        }
 
        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                _repo.Dispose();
            }
 
            base.Dispose(disposing);
        }
 
        private IHttpActionResult GetErrorResult(IdentityResult result)
        {
            if (result == null)
            {
                return InternalServerError();
            }
 
            if (!result.Succeeded)
            {
                if (result.Errors != null)
                {
                    foreach (string error in result.Errors)
                    {
                        ModelState.AddModelError("", error);
                    }
                }
 
                if (ModelState.IsValid)
                {
                    // No ModelState errors are available to send, so just return an empty BadRequest.
                    return BadRequest();
                }
 
                return BadRequest(ModelState);
            }
 
            return null;
        }
    }
}
