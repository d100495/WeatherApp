import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs/';
import { Marker } from '../Models/Marker';
import { Weather } from '../Models/Weather';
import 'rxjs/add/operator/map';
import { IWeather } from '../Models/IWeather';
import { AuthService } from './authService';

@Injectable()
export class WeatherService {

    private httpOptions = {
        headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Authorization': `Bearer ${this.auth.getToken()}` })
    };
    private urlApi = 'http://localhost:55132/api/weather';
    constructor(private _http: HttpClient, private auth: AuthService) { }
    private apiKey = '&APPID=409014fbcefa18db869de6c154c71e71';

    GetWeather(city: string): Observable<Weather> {
        const url = `http://api.openweathermap.org/data/2.5/weather?q=${city}&units=metric${this.apiKey}`;
        return this._http.get<IWeather>(url).map(
            res =>
                new Weather(res.main.temp, res.coord.lon, res.coord.lat, res.main.pressure, res.wind.speed)
        );
    }

    PostWeather(model: Weather): Observable<Weather> {
        const url = `${this.urlApi}/PostHistory`;
        return this._http.post<Weather>(url, model, this.httpOptions);
    }


    GetHistory(): Observable<Weather[]> {
        const url = `${this.urlApi}/GetWeatherByUserId`;
        return this._http.get<Weather[]>(url, this.httpOptions);
    }
}