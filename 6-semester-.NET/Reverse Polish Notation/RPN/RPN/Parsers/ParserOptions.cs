using RPNCalculator.Parsers.Interface;
using RPNCalculator.Parsers.ParserTypes;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RPNCalculator.Parsers
{
    class ParserOptions
    {
        public readonly IReadOnlyDictionary<char, INumberParser> Parsers = new Dictionary<char, INumberParser>()
        {
            ['B'] = new BinaryParserType(),
            ['D'] = new DecimalParserType(),
            ['#'] = new HexaDecimalParserType(),
        };

        public INumberParser ParseValue(char parser)
        {
            INumberParser rest;
            Parsers.TryGetValue(parser, out rest);
            return rest;
        }
    }
}
