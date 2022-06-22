using System;

namespace Data
{
    public abstract class Employee
    {
        public static int EmployeeCounter = 0;
        public int Id;
        public string Name;
        public string LastName;
        public int Age;
        public int Experience;
        public decimal Value;
        public readonly EmployeeWorkAdress EmployeeWorkAdress;

        public Employee(string name, string lastName, int age, int experience, EmployeeWorkAdress employeeWorkAdress)
        {
            EmployeeCounter += 1;
            Id = EmployeeCounter;
            Name = name;
            LastName = lastName;
            Age = age;
            Experience = experience;
            EmployeeWorkAdress = employeeWorkAdress;
        }

        protected abstract void SetEmployeesValue();
    }
}