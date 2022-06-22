using NUnit.Framework;
using System;
using Data;
using Data.Services;
using Data.Data;
using Data.Exceptions;
using System.Collections.Generic;
using Data.Model.Enums;

namespace EmployeeTests
{
    [TestFixture]
    public class Tests
    {
        private EmployeeData _employeeData;
        private EmployeeService _employeeService;

        [SetUp]
        public void Setup()
        {
            _employeeData = new EmployeeData();
            _employeeService = new EmployeeService(_employeeData);

        }

        [Test, Order(1)]
        public void CheckIfTestWorks()
        {
            Assert.Pass();
        }

        [Test, Order(2)]
        public void CheckIfCanCreateSut()
        {
            Assert.That(_employeeService, Is.Not.Null);
        }

        [Test, Order(3)]
        public void CheckIfListIsNull()
        {
            Assert.That(_employeeData.GetEmployeeList().Count, Is.EqualTo(0));
        }

        [Test, Order(4)]
        public void CheckIfDeleteEmployeeByIdWorks()
        {
            List<Employee> bulkEmployeeList = new List<Employee>()
            {
                new OfficeEmployee("Robert", "Ziomal", 30, 55, new EmployeeWorkAdress("Zlota", 666, 666, "Heaven"), 110),
                new PhysicalEmployee("Pawel", "Zbêdny", 31, 150, new EmployeeWorkAdress("Niepodam", 1, 1, "Sopot"), 99),
                new TradeEmployee("Sprzedam", "Matiza", 40, 70, new EmployeeWorkAdress("Orkowa", 15, 4, "Kwidzyn"), TraderEffectivnes.MEDIUM, 9)
            };

            var employeeLsitToCheckAgainst = _employeeService.AddMultipleEmployees(bulkEmployeeList);
            Assert.That(employeeLsitToCheckAgainst.Count, Is.EqualTo(3));
            _employeeService.DeleteEmployeeById(2);
            Assert.That(_employeeData.GetEmployeeList().Count, Is.EqualTo(2));
        }

        [Test, Order(5)]
        public void CheckIfSingleEmployeeAdditionWorks()
        {
            Employee employeeTest = new OfficeEmployee("Robert", "Ziomal", 30, 55, new EmployeeWorkAdress("Zlota", 666, 666, "Heaven"), 110);

            var employeeLsitToCheckAgainst = _employeeService.AddSingleEmployee(employeeTest);
            Assert.That(employeeLsitToCheckAgainst.Count, Is.EqualTo(1));
        }

        [Test, Order(6)]
        public void CheckIfMultipleEmployeeAdditionWorks()
        {
            List<Employee> bulkEmployeeList = new List<Employee>()
            {
                new OfficeEmployee("Robert", "Ziomal", 30, 55, new EmployeeWorkAdress("Zlota", 666, 666, "Heaven"), 110),
                new PhysicalEmployee("Pawel", "Zbêdny", 31, 150, new EmployeeWorkAdress("Niepodam", 1, 1, "Sopot"), 99),
                new TradeEmployee("Sprzedam", "Matiza", 40, 70, new EmployeeWorkAdress("Orkowa", 15, 4, "Kwidzyn"), TraderEffectivnes.MEDIUM, 9)
            };

            var employeeLsitToCheckAgainst = _employeeService.AddMultipleEmployees(bulkEmployeeList);
            Assert.That(employeeLsitToCheckAgainst.Count, Is.EqualTo(3));
        }

        [Test, Order(7)]
        public void CheckEmployeesValueCalculation()
        {
            List<Employee> bulkEmployeeList = new List<Employee>()
            {
                new OfficeEmployee("Robert", "Ziomal", 30, 55, new EmployeeWorkAdress("Zlota", 666, 666, "Heaven"), 110),
                new PhysicalEmployee("Pawel", "Zbêdny", 30, 150, new EmployeeWorkAdress("Niepodam", 1, 1, "Sopot"), 99),
                new TradeEmployee("Sprzedam", "Matiza", 40, 70, new EmployeeWorkAdress("Orkowa", 15, 4, "Kwidzyn"), TraderEffectivnes.MEDIUM, 9)
            };
            _employeeService.AddMultipleEmployees(bulkEmployeeList);

            Assert.That(_employeeData.GetEmployeeList()[0].Value, Is.EqualTo(6050));
            Assert.That(_employeeData.GetEmployeeList()[1].Value, Is.EqualTo(495));
            Assert.That(_employeeData.GetEmployeeList()[2].Value, Is.EqualTo(6300));
        }

        [Test, Order(8)]
        public void CheckFilterEmployeesByCity()
        {
            List<Employee> bulkEmployeeList = new List<Employee>()
            {
                new OfficeEmployee("Jan", "Nowak", 50, 50, new EmployeeWorkAdress("Smieszna", 12, 10, "Pisz"), 100),
                new PhysicalEmployee("Piotr", "Niezbedny", 27, 100, new EmployeeWorkAdress("Zlota", 666, 666, "Pisz"), 53),
                new OfficeEmployee("Robert", "Ziomal", 30, 55, new EmployeeWorkAdress("Zlota", 666, 666, "Heaven"), 110),
                new PhysicalEmployee("Pawel", "Zbêdny", 31, 150, new EmployeeWorkAdress("Niepodam", 1, 1, "Sopot"), 99),
                new TradeEmployee("Sprzedam", "Matiza", 40, 70, new EmployeeWorkAdress("Orkowa", 15, 4, "Kwidzyn"), TraderEffectivnes.MEDIUM, 9),
                new TradeEmployee("Kupie", "Matkê", 18, 1, new EmployeeWorkAdress("Garnuszek", 1, 2, "Pisz"), TraderEffectivnes.LOW, 2)
            };
            _employeeService.AddMultipleEmployees(bulkEmployeeList);
            var employeeLsitToCheckAgainst = _employeeService.FilterEmployeesByCityName("Pisz");

            Assert.That(employeeLsitToCheckAgainst[0].EmployeeWorkAdress.CityName, Is.EqualTo("Pisz"));
            Assert.That(employeeLsitToCheckAgainst[1].EmployeeWorkAdress.CityName, Is.EqualTo("Pisz"));
            Assert.That(employeeLsitToCheckAgainst[2].EmployeeWorkAdress.CityName, Is.EqualTo("Pisz"));
        }

        [Test, Order(9)]
        public void ChceckSortByExperienceDescByAgeAscByNameAlphabetic()
        {
            List<Employee> bulkEmployeeList = new List<Employee>()
            {
                new OfficeEmployee("Jan", "Nowak", 50, 50, new EmployeeWorkAdress("Smieszna", 12, 10, "Pisz"), 100),
                new PhysicalEmployee("Piotr", "Niezbedny", 27, 100, new EmployeeWorkAdress("Zlota", 666, 666, "Pisz"), 53),
                new OfficeEmployee("Robert", "Ziomal", 30, 50, new EmployeeWorkAdress("Zlota", 666, 666, "Heaven"), 110),
                new PhysicalEmployee("Pawel", "Zbêdny", 31, 150, new EmployeeWorkAdress("Niepodam", 1, 1, "Sopot"), 99),
                new TradeEmployee("Sprzedam", "Matiza", 40, 100, new EmployeeWorkAdress("Orkowa", 15, 4, "Kwidzyn"), TraderEffectivnes.MEDIUM, 9),
                new TradeEmployee("Kupie", "Matkê", 18, 1, new EmployeeWorkAdress("Garnuszek", 1, 2, "Pisz"), TraderEffectivnes.LOW, 2)
            };
            _employeeService.AddMultipleEmployees(bulkEmployeeList);
            var employeeLsitToCheckAgainst = _employeeService.SortEmployeeByExperienceDescAgeAscNameAlphabetic();

            Assert.That(employeeLsitToCheckAgainst[0].Experience, Is.EqualTo(150));
            Assert.That(employeeLsitToCheckAgainst[1].Age, Is.EqualTo(27));
            Assert.That(employeeLsitToCheckAgainst[2].LastName, Is.EqualTo("Matiza"));
            Assert.That(employeeLsitToCheckAgainst[3].LastName, Is.EqualTo("Ziomal"));
            Assert.That(employeeLsitToCheckAgainst[4].Age, Is.EqualTo(50));
            Assert.That(employeeLsitToCheckAgainst[5].Experience, Is.EqualTo(1));
        }
    }
}