using Data.Exceptions;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Data
{
    public class OfficeEmployee : Employee
    {
        private const int MIN_IQ = 70;
        private const int MAX_IQ = 150;

        private static int _officeEmployee = 0;
        private int _workPlaceId;
        private int _iq;
        public int Iq
        {
            get
            {
                return _iq;
            }
            set
            {
                if (value >= MIN_IQ && value <= MAX_IQ)
                {
                    _iq = value;
                }
                else
                {
                    throw new WrongIqExceptions("This employee is too el STUPIDO");
                }
            }
        }

        public OfficeEmployee(string name, string lastName, int age, int experience, EmployeeWorkAdress employeeWorkAdress, int iq) : base(name, lastName, age, experience, employeeWorkAdress)
        {
            _officeEmployee += 1;
            _workPlaceId = _officeEmployee;
            Iq = iq;
            SetEmployeesValue();
        }

        protected override void SetEmployeesValue()
        {
            this.Value = Experience * _iq;
        }
    }
}
