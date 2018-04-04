export class ForecastWeather {
    Date: string;
    Description: string;
    IconUrl: string;
    Temperature: number;
    TempMin: number;
    Humidity: number;
    WindSpeed: number;
    TempMax: number;
    WindChill: number;

    constructor(date: string, description: string, iconUrl: string, temperature: number, tempMax: number,
        humidity: number, windSpeed: number, tempMin: number) {
        this.Date = date;
        this.Description = description;
        this.IconUrl = iconUrl;
        this.Temperature = temperature;
        this.TempMax = tempMax;
        this.Humidity = humidity;
        this.WindSpeed = windSpeed;
        this.TempMin = tempMin;
        this.WindChill = Math.round(33 + (0.478 + 0.237 * Math.sqrt(this.WindSpeed) - 0.0124 * this.WindSpeed)
            * (this.Temperature - 33)) * 100 / 100;
    }
}
