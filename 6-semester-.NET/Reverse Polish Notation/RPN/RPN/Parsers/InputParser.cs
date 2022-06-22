using RPNCalculator.Parsers.Interface;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RPNCalculator.Parsers
{
    class InputParser : IInputParser
    {
        private readonly ParserOptions _parserOptions = new ParserOptions();

        public IEnumerable<string> GetParts(string input)
        {
            var dirtyParts = input.Split(' ');
            var result = new List<string>();
            foreach (var part in dirtyParts)
            {
                var parsed = part;
                var parser = _parserOptions.ParseValue(part[0]);

                if (parser != null)
                {
                    parsed = parser.GetNumberParsed(part);
                }

                result.Add(parsed);
            }

            return result;
        }
    }
}
