using RPNCalculator.Operation.Types.Base;
using System.Collections.Generic;
using System.Linq;


namespace RPNCalculator.Operation.Types
{
    class SubstractOperationType : OperationBaseType
    {
        public override int ParametersCount => 2;

        protected override long CalculateInternal(IEnumerable<long> parameters)
        {
            return parameters.ElementAt(0) - parameters.ElementAt(1);
        }
    }
}
