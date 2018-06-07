import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs/';
import { Weather } from '../Models/Weather';
import 'rxjs/add/operator/map';
import { ICurrentWeatherOpenWeatherMaps } from '../Models/ICurrentWeatherOpenWeatherMaps';
import { AuthService } from './authService';
import { IPaginateWeatherHistory } from '../Models/IPaginateWeatherHistory';

@Injectable()
export class WeatherService {

    private httpOptions = {
        headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Authorization': `Bearer ${this.auth.getToken()}` })
    };
    private urlApi = 'http://localhost:55132/api/weatherhistory';
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

    GetPaginateHistory(): Observable<IPaginateWeatherHistory>{
        const url = `${this.urlApi}/GetPagedWeatherHistoryByUserId?pageNo=1&pageSize=10`;
        return this._http.get<IPaginateWeatherHistory>(url,this.httpOptions);
    }

    GetPaginateHistoryByDate(date: string): Observable<IPaginateWeatherHistory>{
        const url = `${this.urlApi}/GetPagedWeatherHistoryByDate?date=${date}&pageNo=1&pageSize=10`;
        return this._http.get<IPaginateWeatherHistory>(url, this.httpOptions);
    }

    GoToPages(url: string): Observable<IPaginateWeatherHistory>{
        return this._http.get<IPaginateWeatherHistory>(url, this.httpOptions);
    }
}
