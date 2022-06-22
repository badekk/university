using Data.Data.Interface;
using Data.Exceptions;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Data.Services
{
    public class EmployeeService
    {
        private readonly IEmployeeData EmployeeData;

        public EmployeeService(IEmployeeData employeeData)
        {
            EmployeeData = employeeData;
        }

        public List<Employee> AddSingleEmployee(Employee employee)
        {
            var employeeList = EmployeeData.GetEmployeeList();
            employeeList.Add(employee);

            return employeeList;
        }

        public List<Employee> AddMultipleEmployees(List<Employee> bulkOfEmployees)
        {
            var employeeList = EmployeeData.GetEmployeeList();
            employeeList.AddRange(bulkOfEmployees);

            return employeeList;
        }

        public List<Employee> DeleteEmployeeById(int id)
        {
            var employeeList = EmployeeData.GetEmployeeList();
            var isPresentId = employeeList.FirstOrDefault(employee => employee.Id == id);

            if (isPresentId != null)
            {
                employeeList.Remove(isPresentId);
            }
            else
            {
                throw new NoEmployeeIndexException("There's no Employee with that ID");
            }

            return employeeList;
        }

        public List<Employee> SortEmployeeByExperienceDescAgeAscNameAlphabetic()
        {
            var employeeList = EmployeeData.GetEmployeeList();
            return employeeList.OrderByDescending(employee => employee.Experience)
                        .ThenBy(employee => employee.Age)
                        .ThenBy(employee => employee.LastName)
                        .ToList();
        }

        public List<Employee> FilterEmployeesByCityName(string cityName)
        {
            var employeeList = EmployeeData.GetEmployeeList();

            return employeeList.Where(employee => employee.EmployeeWorkAdress.CityName == cityName).ToList();
        }

        //Used previously to count EmployeesValue
        /* public List<Employee> CalculateEmployeesValue()
           {
               var employeeList = EmployeeData.GetEmployeeList();
               employeeList.ForEach(employee => employee.Value = employee.GetEmployeesValue());
               return employeeList;
           }*/

        public void SelectAllEmployees()
        {
            var employeeList = EmployeeData.GetEmployeeList();
        }
    }
}
