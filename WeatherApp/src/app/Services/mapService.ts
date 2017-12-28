import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Marker } from '../map/Marker';
import { Weather } from '../map/Weather';
import 'rxjs/add/operator/map';
import { IWeather } from '../map/IWeather';
import { AuthService } from './authService';
@Injectable()
export class MapService {

    private httpOptions = {
        headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Authorization' : `Bearer ${this.auth.getToken()}` })
    };
    private urlApi = 'http://localhost:55132/';
    
    constructor(private _http: HttpClient, private auth: AuthService) { }
    private apiKey = '&APPID=409014fbcefa18db869de6c154c71e71';

    GetWeather(city: string): Observable<IWeather> {
        const url = `http://api.openweathermap.org/data/2.5/weather?q=${city}&units=metric${this.apiKey}`;
        return this._http.get<IWeather>(url);
    }

    PostWeather(model: Weather): Observable<Weather> {
            return this._http.post<Weather>(this.urlApi, model, this.httpOptions);
    }

    GetMarkers(): Observable<Marker[]> {
        return this._http.get<Marker[]>('../../markers.json');
    }

}