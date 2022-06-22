using RPNCalculator.Operation.Options;
using RPNCalculator.Operation.Types.Base;
using RPNCalculator.Enums;
using System;
using System.Collections.Generic;
using RPNCalculator.Parsers;

namespace RPNCalculator
{
    public class RPN
    {
        private readonly InputParser _inputParser = new InputParser();
        private readonly Stack<long> _stack = new Stack<long>();

        private readonly OperationOptions _operationOptions = new OperationOptions();
        private readonly OperationRecognizer _operationRecognizer = new OperationRecognizer();

        public long EvalRPN(string input)
        {
            var parts = _inputParser.GetParts(input);

            foreach (var part in parts)
            {
                var calculated = Operate(part);
                _stack.Push(calculated);
            }

            var result = _stack.Pop();

            if (!_stack.IsEmpty)
                throw new InvalidOperationException();

            return result;
        }

        public long Operate(string part)
        {
            var operationType = _operationRecognizer.Recognize(part);

            switch (operationType)
            {
                case OperationType.Store:
                    return long.Parse(part);
                case OperationType.Operate:
                    var operation = _operationOptions.GetOperation(part);
                    var inputList = GetInputParameters(operation);
                    return operation.Calculate(inputList);
            }

            throw new NotImplementedException();
        }

        private IEnumerable<long> GetInputParameters(OperationBaseType operation)
        {
            var result = new List<long>(operation.ParametersCount);

            for (long i = 0; i < operation.ParametersCount; i++)
            {
                var popped = _stack.Pop();
                result.Add(popped);
            }

            return result;
        }
    }
}