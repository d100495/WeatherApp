using Microsoft.VisualStudio.TestTools.UnitTesting;
using WeatherAppApi.Repositories;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using FluentAssertions;
using Moq;
using Ninject.Infrastructure.Language;
using WeatherAppApi.Interfaces;
using WeatherAppApi.Models;
using WeatherAppApiTests;

namespace WeatherAppApi.Repositories.Tests
{
    [TestClass()]
    public class WeatherHistoryRepositoryTests
    {
        private WeatherHistoryRepository _weatherHistoryRepository { get; set; }
        private List<WeatherHistory> data { get; set; }

        [TestInitialize]
        public void Setup()
        {
            data = new List<WeatherHistory>();
            for (int i = 0; i < 50; i++)
            {
                data.Add(new WeatherHistory
                {
                    Latitude = 10,
                    Longitude = 10,
                    Date = new DateTime(2010, 10, 10),
                    Temperature = 10,
                    Id = "x",
                    Pressure = 20,
                    WindSpeed = 20,
                    WindChill = 20
                });
                data.Add(new WeatherHistory
                {
                    Latitude = 10,
                    Longitude = 10,
                    Date = new DateTime(1990, 10, 20),
                    Id = "dsad",
                    Temperature = 10,
                    Pressure = 20,
                    WindSpeed = 20,
                    WindChill = 20
                });
            }
            //{
            //    new WeatherHistory
            //    {
            //        Latitude = 10,
            //        Longitude = 10,
            //        Date = new DateTime(2010, 10, 10),
            //        Temperature = 10,
            //        Id = "x",
            //        Pressure = 20,
            //        WindSpeed = 20,
            //        WindChill = 20
            //    },
            //    new WeatherHistory
            //    {
            //        Latitude = 10,
            //        Longitude = 10,
            //        Date = new DateTime(1990, 10, 20),
            //        Id = "dsad",
            //        Temperature = 10,
            //        Pressure = 20,
            //        WindSpeed = 20,
            //        WindChill = 20
            //    }
            //};

           var mockSet = new Mock<DbSet<WeatherHistory>>();
            mockSet.As<IDbAsyncEnumerable<WeatherHistory>>() 
                .Setup(m => m.GetAsyncEnumerator()) 
                .Returns(new TestDbAsyncEnumerator<WeatherHistory>(data.GetEnumerator())); 
            mockSet.As<IQueryable<WeatherHistory>>() 
                .Setup(m => m.Provider) 
                .Returns(new TestDbAsyncQueryProvider<WeatherHistory>(ReturnAsQueryable().Provider)); 

            mockSet.As<IQueryable<WeatherHistory>>().
                Setup(x => x.Expression)
                .Returns(ReturnAsQueryable().Expression);
            mockSet.As<IQueryable<WeatherHistory>>()
                .Setup(x => x.ElementType)
                .Returns(ReturnAsQueryable().ElementType);
            mockSet.As<IQueryable<WeatherHistory>>()
                .Setup(x => x.GetEnumerator())
                .Returns(ReturnAsQueryable().GetEnumerator);

          var dbContext = new Mock<AuthContext>();
           dbContext.Setup(x => x.WeatherHistory).Returns(mockSet.Object);
            
            _weatherHistoryRepository = new WeatherHistoryRepository(dbContext.Object);

        }

        private IQueryable<WeatherHistory> ReturnAsQueryable()
        {
            return data.AsQueryable();
        }
        [TestMethod]
        public void GetAll()
        {
            Assert.AreEqual(100, data.Count());
        }

        [TestMethod]
        public async Task GetByDate_should_return_list_with_results()
        {
            var list =  await _weatherHistoryRepository.GetByDate("x", new DateTime(2010,10,10));
            var listExpected = new List<WeatherHistory>();
            for (int i = 0; i < 50; i++)
            {
                listExpected.Add(  new WeatherHistory
                {
                    Latitude = 10,
                    Longitude = 10,
                    Date = new DateTime(2010,10,10),
                    Id = "x",
                    Temperature = 10,
                    Pressure = 20,
                    WindSpeed = 20,
                    WindChill = 20
                });

            }
           

            listExpected.Should().BeEquivalentTo(list);
        }

        [TestMethod]
        public async Task GetAll_should_return_all_items()
        {
            var list = await _weatherHistoryRepository.GetAll();

            Assert.AreEqual(data.Count(), list.Count());
            data.Should().BeEquivalentTo(list);
        }

        [TestMethod]
        public async Task GetById_should_return_list_with_results()
        {
            var list = await _weatherHistoryRepository.GetByUserId("x");

            var listExpected = new List<WeatherHistory>();
            for (int i = 0; i < 50; i++)
            {
                listExpected.Add(  new WeatherHistory
                {
                    Latitude = 10,
                    Longitude = 10,
                    Date = new DateTime(2010,10,10),
                    Id = "x",
                    Temperature = 10,
                    Pressure = 20,
                    WindSpeed = 20,
                    WindChill = 20
                });

            }

            listExpected.Should().BeEquivalentTo(list);

        }

        [TestMethod]
        public async Task TotalNumberOfRecords_should_count_entities()
        {
            var number = await _weatherHistoryRepository.TotalNumberOfRecords();

            Assert.AreEqual(100, number);
        }

        [TestMethod]
        public async Task Paginate_should_return_number_from_arg_entities()
        {
            var list = await _weatherHistoryRepository.Paginate("x", 1, 20);

            Assert.AreEqual(20, list.Count());

        }

    }
}