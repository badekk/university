using RPNCalculator.Operation.Types.Base;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RPNCalculator.Operation.Types
{
    class AddOperationType : OperationBaseType
    {
        public override int ParametersCount => 2;

        protected override long CalculateInternal(IEnumerable<long> parameters)
        {
            return parameters.ElementAt(0) + parameters.ElementAt(1);
        }
    }
}
