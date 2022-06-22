using RPNCalculator.Enums;
using System;
using System.Linq;


namespace RPNCalculator.Operation.Options
{
    internal class OperationRecognizer
    {
        private readonly OperationOptions _chooser = new OperationOptions();

        public OperationType Recognize(string input)
        {
            if (IsNumber(input))
            {
                return OperationType.Store;
            }
            else if (IsOperator(input))
            {
                return OperationType.Operate;
            }

            throw new InvalidOperationException();
        }

        private bool IsNumber(string input) => long.TryParse(input, out _);

        private bool IsOperator(string input) => _chooser.Operations.Keys.Contains(input);
    }
}
