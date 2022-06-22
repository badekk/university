using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RPNCalculator.Operation.Exceptions
{
    [Serializable]
    class WrongCountException : Exception
    {
        public WrongCountException(string message) : base(message)
        {
        }
    }
}

