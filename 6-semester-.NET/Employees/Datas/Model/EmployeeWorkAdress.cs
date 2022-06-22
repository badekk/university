using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Data
{
    public class EmployeeWorkAdress
    {
        public string StreetName;
        public int BuildingNumber;
        public int OfficeNumber;
        public string CityName;

        public EmployeeWorkAdress(string streetName, int buildingNumber, int officeNumber, string cityName)
        {
            StreetName = streetName;
            BuildingNumber = buildingNumber;
            OfficeNumber = officeNumber;
            CityName = cityName;
        }
    }
}
