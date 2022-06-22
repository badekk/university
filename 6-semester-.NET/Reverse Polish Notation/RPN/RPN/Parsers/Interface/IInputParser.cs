using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RPNCalculator.Parsers.Interface
{
    internal interface IInputParser
    {
        IEnumerable<string> GetParts(string input);
    }
}
