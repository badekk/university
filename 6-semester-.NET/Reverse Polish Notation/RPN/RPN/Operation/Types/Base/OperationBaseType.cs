using RPNCalculator.Operation.Exceptions;
using System.Collections.Generic;
using System.Linq;


namespace RPNCalculator.Operation.Types.Base
{
    internal abstract class OperationBaseType
    {
        public abstract int ParametersCount { get; }

        public long Calculate(IEnumerable<long> parameters)
        {
            if (parameters.Count() != ParametersCount)
            {
                throw new WrongCountException("Wrong parameters count");
            }

            return CalculateInternal(parameters);
        }

        protected abstract long CalculateInternal(IEnumerable<long> parameters);
    }
}
