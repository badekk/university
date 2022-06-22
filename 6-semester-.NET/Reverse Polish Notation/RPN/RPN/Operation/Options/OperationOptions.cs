using RPNCalculator.Operation.Types;
using RPNCalculator.Operation.Types.Base;
using System.Collections.Generic;


namespace RPNCalculator.Operation.Options
{
    internal class OperationOptions
    {
        public readonly IReadOnlyDictionary<string, OperationBaseType> Operations = new Dictionary<string, OperationBaseType>()
        {
            ["+"] = new AddOperationType(),
            ["!"] = new FactorialOperationType(),
            ["/"] = new DivideOperationType(),
            ["*"] = new MultiplyOperationType(),
            ["-"] = new SubstractOperationType(),
        };

        public OperationBaseType GetOperation(string operation)
        {
            return Operations[operation];
        }
    }
}
