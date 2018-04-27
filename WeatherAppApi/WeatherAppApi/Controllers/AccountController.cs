using Microsoft.AspNet.Identity;
using System.Threading.Tasks;
using System.Web.Http;
using WeatherAppApi.Interfaces;
using WeatherAppApi.Models;

namespace WeatherAppApi.Controllers
{
    [RoutePrefix("api/Account")]
    public class AccountController : ApiController
    {
        private IAuthRepository authRepository;
 
        public AccountController(IAuthRepository _authRepository)
        {
            authRepository = _authRepository;
        }

       
        [AllowAnonymous]
        [Route("Register")]
        public async Task<IHttpActionResult> Register(UserModel userModel)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }
 
            IdentityResult result = await authRepository.RegisterUser(userModel);
 
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
            string userId = authRepository.GetUserId();
            if (userId == null)
            {
                return NotFound();
            }
            var user =  await authRepository.FindById(userId);
            return Ok(user);

        }
 
        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                authRepository.Dispose();
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
                    return BadRequest();
                }
 
                return BadRequest(ModelState);
            }
 
            return null;
        }
    }
}
