export class Weather {
    Temperature: number;
    Longitude: number;
    Latitude: number;
    Pressure: number;
    WindSpeed: number;
    WindChill: number;

    constructor(temperature: number, longitude: number, latitude: number, pressure: number, windSpeed: number) {
        this.Temperature = temperature;
        this.Longitude = longitude;
        this.Latitude = latitude;
        this.Pressure = pressure;
        this.WindSpeed = windSpeed;
        this.WindChill = Math.round(33 + (0.478 + 0.237 * Math.sqrt(this.WindSpeed) - 0.0124 * this.WindSpeed)
            * (this.Temperature - 33)) * 100 / 100;
    }
}
