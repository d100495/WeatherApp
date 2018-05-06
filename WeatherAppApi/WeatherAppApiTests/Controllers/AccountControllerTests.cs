using Microsoft.VisualStudio.TestTools.UnitTesting;
using WeatherAppApi.Controllers;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Web.Http.Results;
using Microsoft.AspNet.Identity;
using Moq;
using WeatherAppApi.App_Start;
using WeatherAppApi.Interfaces;
using WeatherAppApi.Models;

namespace WeatherAppApi.Controllers.Tests
{
    [TestClass()]
    public class AccountControllerTests
    {
        private Mock<IAuthRepository> _authRepositoryMock { get; set; }
        private AccountController _accountController { get; set; }

        [TestInitialize]
        public void Startup()
        {
            _authRepositoryMock = new Mock<IAuthRepository>();
            _accountController = new AccountController(_authRepositoryMock.Object);
        }
        [TestMethod()]
        public async Task Register_should_return_ok()
        {
            UserModel user = new UserModel()
            {
                UserName = "test",
                Password = "test",
                ConfirmPassword = "test"
            };

            _authRepositoryMock.Setup(x => x.RegisterUser(user)).ReturnsAsync(IdentityResult.Success);
            var actionResult = await _accountController.Register(user);
            var contentResult = actionResult as OkNegotiatedContentResult<UserModel>;

            Assert.IsNotNull(actionResult);
            Assert.IsNotNull(contentResult);
            Assert.IsInstanceOfType(actionResult, typeof(OkNegotiatedContentResult<UserModel>));
            Assert.AreEqual(user, contentResult.Content);

        }
    }
}