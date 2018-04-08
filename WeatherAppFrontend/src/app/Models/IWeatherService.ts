import { Observable } from 'rxjs/Observable';
import { Weather } from './Weather';
import { ForecastWeather } from './ForecastWeather';

export interface IWeatherService {
    GetWeather(lon: number, lat: number): Observable<Weather>;
    GetForecastWeather(lon: number, lat: number): Observable<ForecastWeather[]>;
}