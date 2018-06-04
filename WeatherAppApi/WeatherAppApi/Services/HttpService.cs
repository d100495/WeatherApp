using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Web;
using Newtonsoft.Json;
using WeatherAppApi.JsonDeserializeModels;

namespace WeatherAppApi.Services
{
    public class HttpService<T> : IHttpService<T> where T : class 
    {
        public T HttpGet(string url)
        {
            HttpWebRequest request = (HttpWebRequest)WebRequest.Create(url);
            var webResponse = (HttpWebResponse)request.GetResponse();
            var reader = new StreamReader(webResponse.GetResponseStream() ?? throw new InvalidOperationException());
            string s = reader.ReadToEnd();
            return JsonConvert.DeserializeObject<T>(s);
        }
    }
}