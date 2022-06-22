using RPNCalculator.Operation.Types.Base;
using System;
using System.Collections.Generic;
using System.Linq;

namespace RPNCalculator.Operation.Types
{
    class DivideOperationType : OperationBaseType
    {
        public override int ParametersCount => 2;

        protected override long CalculateInternal(IEnumerable<long> parameters)
        {
            var secondElement = parameters.ElementAt(1);

            if (secondElement == 0)
            {
                throw new DivideByZeroException();
            }

            return parameters.ElementAt(0) / secondElement;
        }
    }
}
