export class Weather{
    Temperature: number;
    Longitude: number;
    Latitude: number;
    Pressure: number;
    WindSpeed: number;
    WindChill: number;

    constructor(temperature: number, longitude: number, latitude: number, pressure: number, windSpeed: number){
            this.Temperature = temperature;
            this.Longitude = longitude;
            this.Latitude = latitude;
            this. Pressure = pressure;
            this.WindSpeed = windSpeed;
            this.WindChill = Math.round((13.12 + 0.6215 * this.Temperature - Math.pow((11.37 * this.WindSpeed), 0.16)
             + Math.pow((0.3965 * this.Temperature * this.WindSpeed), 0.16)) * 100) / 100;
    }
}