import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { AuthService } from './authService';
import { Observable } from 'rxjs/Observable';
import { Weather } from '../Models/Weather';
import { ICurrentWeatherOpenWeatherMaps } from '../Models/ICurrentWeatherOpenWeatherMaps';
import { IForecastWeatherOpenWeatherMaps } from '../Models/IForecastWeatherOpenWeatherMaps';
import { ForecastWeather } from '../Models/ForecastWeather';
import { IWeatherService } from '../Models/IWeatherService';

@Injectable()
export class OpenWeatherMapsService implements IWeatherService {

    constructor(private _http: HttpClient) { }
    private apiKey = '&APPID=409014fbcefa18db869de6c154c71e71';

    GetWeather(city: string): Observable<Weather> {
        console.log('open');
        const url = `http://api.openweathermap.org/data/2.5/weather?q=${city}&units=metric${this.apiKey}`;
        return this._http.get<ICurrentWeatherOpenWeatherMaps>(url).map(
            res =>
                new Weather(res.main.temp, res.coord.lon, res.coord.lat, res.main.pressure, res.wind.speed)
        );
    }

    GetForecastWeather(city: string): Observable<ForecastWeather[]> {
        const url = `http://api.openweathermap.org/data/2.5/forecast?q=${city}&units=metric${this.apiKey}`;
        return this._http.get<IForecastWeatherOpenWeatherMaps>(url).map(
            res => {
                console.log(res);
                let array = new Array<ForecastWeather>();
                for (let model of res.list) {
                    array.push(new ForecastWeather(model.dt_txt, model.weather[0].description,
                        `http://openweathermap.org/img/w/${model.weather[0].icon}.png`, model.main.temp,
                        model.main.temp_max, model.main.humidity, model.wind.speed, model.main.temp_min));
                }
                return array;
            }
        );
    }
}