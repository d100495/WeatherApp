import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs/';
import { Marker } from '../Models/Marker';
import { Weather } from '../Models/Weather';
import 'rxjs/add/operator/map';
import { IWeather } from '../Models/IWeather';
import { AuthService } from './authService';
@Injectable()
export class MapService {

    private httpOptions = {
        headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Authorization': `Bearer ${this.auth.getToken()}` })
    };
    private urlApi = 'http://localhost:55132/api/weather';
    constructor(private _http: HttpClient, private auth: AuthService) { }
    private apiKey = '&APPID=409014fbcefa18db869de6c154c71e71';

    GetMarkers(): Observable<Marker[]> {
        return this._http.get<Marker[]>('../../markers.json');
    }
}