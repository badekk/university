using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RPNCalculator.Parsers.Interface
{
    interface INumberParser
    {
        string GetNumberParsed(string part);
    }
}
