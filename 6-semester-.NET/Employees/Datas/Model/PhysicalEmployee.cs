using Data.Exceptions;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Data
{
    public class PhysicalEmployee : Employee
    {
        private const int MIN_STRENGTH = 0;
        private const int MAX_STRENGTH = 100;
        private int _physicalStrength;
        public int PhysicalStrength
        {
            get
            {
                return _physicalStrength;
            }
            set
            {
                if (value > MIN_STRENGTH && value <= MAX_STRENGTH)
                {
                    _physicalStrength = value;
                }
                else
                {
                    throw new OutOfScaleStrengthException($"His powerlevel is over {MAX_STRENGTH} or below {MIN_STRENGTH}!!");
                }
            }
        }

        public PhysicalEmployee(string name, string lastName, int age, int experience, EmployeeWorkAdress employeeWorkAdress, int physicalStrength) : base(name, lastName, age, experience, employeeWorkAdress)
        {
            PhysicalStrength = physicalStrength;
            SetEmployeesValue();
        }

        protected override void SetEmployeesValue()
        {
            this.Value = Experience * _physicalStrength / Age;
        }
    }
}
