using RPNCalculator.Parsers.Interface;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RPNCalculator.Parsers.ParserTypes
{
    class BinaryParserType : INumberParser
    {
        public string GetNumberParsed(string part)
        {
            var fixedPart = part.Substring(1);
            var converted = Convert.ToInt32(fixedPart, 2);
            return converted.ToString();
        }
    }
}
