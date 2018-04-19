using System;

namespace WeatherAppApi.Interfaces
{
    public interface IPageLinkBuilder
    {
        Uri FirstPage { get; set; }
        Uri LastPage { get; set; }
        Uri NextPage { get; set; }
        Uri PreviousPage { get; set; }
    }
}