﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Data.Exceptions
{
    class NoEmployeeIndexException : Exception
    {
        public NoEmployeeIndexException(string message) : base(message)
        {
        }
    }
}
