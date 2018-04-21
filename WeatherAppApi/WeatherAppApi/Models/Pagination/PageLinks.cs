using System;

namespace WeatherAppApi.Models.Pagination
{
    public class PageLinks
    {
        public Uri First { get; set; }
        public Uri Last { get; set; }
        public Uri Previous { get; set; }
        public Uri Next { get; set; }
    }
}