using RPNCalculator.Operation.Types.Base;
using System.Collections.Generic;
using System.Linq;


namespace RPNCalculator.Operation.Types
{
    class FactorialOperationType : OperationBaseType
    {
        public override int ParametersCount => 1;

        protected override long CalculateInternal(IEnumerable<long> parameters)
        {
            var number = parameters.ElementAt(0);
            if (number == 0)
            {
                return 1;
            }
            return number * CalculateInternal(new List<long>() { number - 1 });
        }
    }
}
