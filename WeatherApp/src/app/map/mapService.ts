import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Marker } from './Marker';
@Injectable()
export class MapService {

    constructor(private _http: HttpClient) { }
    private apiKey = '&APPID=409014fbcefa18db869de6c154c71e71';

    GetWeather(city: string): Observable<any> {
        const url = `http://api.openweathermap.org/data/2.5/weather?q=${city}&units=metric${this.apiKey}`;
        return this._http.get(url);
    }

    GetMarkers(): Observable<Marker[]> {
        return this._http.get<Marker[]>('../../markers.json');
    }

    GetLayer(): Observable<any[]> {
        return this._http.get<any[]>('http://tile.openweathermap.org/map/clouds_new/1/1/1.png?appid=404e3914151d86a89162768b74f5831c');
    }
}