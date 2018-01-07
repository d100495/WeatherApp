import { Weather } from './Weather';

export class WeatherWithUserId extends Weather{
    Id: string;

    constructor(temperature: number, longitude: number, latitude: number, pressure: number, windSpeed: number, id: string){
        super(temperature, longitude, latitude, pressure, windSpeed);
        this.Id = id;
    }
}