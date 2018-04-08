import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Weather } from '../Models/Weather';
import { Observable } from 'rxjs/Observable';
import { ICurrentWeatherApixu } from '../Models/ICurrentWeatherApixu';
import { ForecastWeather } from '../Models/ForecastWeather';
import { IForecastWeatherApixu } from '../Models/IForecastWeatherApixu';
import { IWeatherService } from '../Models/IWeatherService';

@Injectable()
export class ApixuService implements IWeatherService {
    constructor(private _http: HttpClient) { }
    private apiKey = 'be73dbae410147e79fa130000183103';

    GetWeather(lat: number, lon: number): Observable<Weather> {
        console.log('apixu');
        const url = `http://api.apixu.com/v1/current.json?key=${this.apiKey}&q=$${lat},${lon}`;
        return this._http.get<ICurrentWeatherApixu>(url).map(
            res =>
                new Weather(res.current.temp_c, res.location.lon, res.location.lat, res.current.pressure_mb, res.current.wind_kph)
        );
    }

    GetForecastWeather(lat: number, lon: number): Observable<ForecastWeather[]> {
        const url = `http://api.apixu.com/v1/forecast.json?key=${this.apiKey}&q=${lat},${lon}&days=10`;
        return this._http.get<IForecastWeatherApixu>(url).map(
            res => {
                const array = new Array<ForecastWeather>();
                for (let model of res.forecast.forecastday) {
                    array.push(new ForecastWeather(model.date, model.day.condition.text,
                        model.day.condition.icon, model.day.avgtemp_c,
                        model.day.maxtemp_c, model.day.avghumidity, model.day.maxwind_kph, model.day.mintemp_c));
                }
                return array;
            }
        );
    }
}