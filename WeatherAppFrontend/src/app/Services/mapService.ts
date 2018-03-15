import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs/';
import { IWeatherStation } from '../Models/IWeatherStation';
import { Weather } from '../Models/Weather';
import 'rxjs/add/operator/map';
import { IWeather } from '../Models/IWeather';
import { AuthService } from './authService';
@Injectable()
export class MapService {

    private httpOptions = {
        headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Authorization': `Bearer ${this.auth.getToken()}` })
    };
    private urlApi = 'http://localhost:55132/api/WeatherStation';
    constructor(private _http: HttpClient, private auth: AuthService) { }
    private apiKey = '&APPID=409014fbcefa18db869de6c154c71e71';

    GetMarkers(): Observable<IWeatherStation[]> {
        const url = `${this.urlApi}/GetAll`;
        return this._http.get<IWeatherStation[]>(url, this.httpOptions);
    }
}