import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs/';
import { Weather } from '../Models/Weather';
import 'rxjs/add/operator/map';
import { ICurrentWeatherOpenWeatherMaps } from '../Models/ICurrentWeatherOpenWeatherMaps';
import { AuthService } from './authService';

@Injectable()
export class WeatherService {

    private httpOptions = {
        headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Authorization': `Bearer ${this.auth.getToken()}` })
    };
    private urlApi = 'http://weatherapp-001-site1.gtempurl.com/api/weather';
    constructor(private _http: HttpClient, private auth: AuthService) { }
    private apiKey = '&APPID=409014fbcefa18db869de6c154c71e71';


    PostWeather(model: Weather): Observable<Weather> {
        const url = `${this.urlApi}/PostHistory`;
        return this._http.post<Weather>(url, model, this.httpOptions);
    }


    GetHistory(): Observable<Weather[]> {
        const url = `${this.urlApi}/GetWeatherByUserId`;
        return this._http.get<Weather[]>(url, this.httpOptions);
    }

}
