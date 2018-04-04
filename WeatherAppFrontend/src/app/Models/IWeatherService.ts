import { Observable } from 'rxjs/Observable';
import { Weather } from './Weather';
import { ForecastWeather } from './ForecastWeather';

export interface IWeatherService{
    GetWeather(city: string) : Observable<Weather>;
    GetForecastWeather(city: string): Observable<ForecastWeather[]>;
}