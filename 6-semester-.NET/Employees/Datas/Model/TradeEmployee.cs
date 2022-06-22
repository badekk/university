using Data.Exceptions;
using Data.Model.Enums;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Data
{
    public class TradeEmployee : Employee
    {
        private const int MIN_COMISSION = 0;
        private const int MAX_COMISSION = 99;

        TraderEffectivnes _traderEffectivnes;
        private decimal _comission;
        public decimal Comission
        {
            set
            {
                if (value > MIN_COMISSION && value <= MAX_COMISSION)
                {
                    _comission = value;
                }
                else
                {
                    throw new TraderComissionOutOfRangeException($"You greedy bastard, {MAX_COMISSION}% is max...");
                }
            }
        }

        public TradeEmployee(string name, string lastName, int age, int experience, EmployeeWorkAdress employeeWorkAdress, TraderEffectivnes traderEffectivnes, decimal comission) : base(name, lastName, age, experience, employeeWorkAdress)
        {
            _traderEffectivnes = traderEffectivnes;
            Comission = comission;
            SetEmployeesValue();
        }

        protected override void SetEmployeesValue()
        {
            this.Value = Experience * (int)_traderEffectivnes;
        }
    }
}
