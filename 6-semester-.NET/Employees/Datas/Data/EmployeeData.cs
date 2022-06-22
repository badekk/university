using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Data.Data.Interface;
using Data.Model.Enums;

namespace Data.Data
{
    public class EmployeeData : IEmployeeData
    {
        public readonly List<Employee> employeeList = new List<Employee>();

        public List<Employee> GetEmployeeList()
        {
            return employeeList;
        }
        public List<Employee> LoadEmployeeData()
        {
            Employee employee1 = new OfficeEmployee("Jan", "Nowak", 50, 50, new EmployeeWorkAdress("Smieszna", 12, 10, "Pisz"), 100);
            Employee employee2 = new OfficeEmployee("Tomek", "Azur", 20, 10, new EmployeeWorkAdress("Nieznana", 2, 104, "Augustów"), 74);
            Employee employee3 = new PhysicalEmployee("Piotr", "Niezbedny", 27, 100, new EmployeeWorkAdress("Zlota", 666, 666, "Heaven"), 53);
            Employee employee4 = new PhysicalEmployee("Nikodem", "Baj", 20, 10, new EmployeeWorkAdress("Orkowa", 15, 4, "Kwidzyn"), 122);
            Employee employee5 = new TradeEmployee("Sprzedam", "Matiza", 40, 70, new EmployeeWorkAdress("Niepodam", 1, 1, "Sopot"), TraderEffectivnes.HIGH, 99);
            Employee employee6 = new TradeEmployee("Kupie", "Matkę", 18, 1, new EmployeeWorkAdress("Garnuszek", 1, 2, "Pisz"), TraderEffectivnes.LOW, 2);
            employeeList.Add(employee1);
            employeeList.Add(employee2);
            employeeList.Add(employee3);
            employeeList.Add(employee4);
            employeeList.Add(employee5);
            employeeList.Add(employee6);

            List<Employee> bulkEmployeeList = new List<Employee>()
            {
                new OfficeEmployee("Robert", "Ziomal", 30, 55, new EmployeeWorkAdress("Zlota", 666, 666, "Heaven"), 110),
                new PhysicalEmployee("Pawel", "Zbędny", 31, 150, new EmployeeWorkAdress("Niepodam", 1, 1, "Sopot"), 99),
                new TradeEmployee("Sprzedam", "Matiza", 40, 70, new EmployeeWorkAdress("Orkowa", 15, 4, "Kwidzyn"), TraderEffectivnes.MEDIUM, 9)
            };

            employeeList.AddRange(bulkEmployeeList);

            return employeeList;
        }
    }
}
