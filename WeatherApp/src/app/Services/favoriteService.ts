import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs/';
import { FavoriteArray } from '../Models/FavoriteArray';
import { MapService } from './mapService';
import { Weather } from '../Models/Weather';
import { WeatherWithUserId } from '../Models/WeatherWithUserId';
import { Favorite } from '../Models/Favorite';
import { AuthService } from './authService';
import 'rxjs/add/operator/do';

@Injectable()
export class FavoriteService {
    private httpOptions = {
        headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Authorization': `Bearer ${this.auth.getToken()}` })
    };

    private htttpDelete = {
        headers: new HttpHeaders({ 'Authorization': `Bearer ${this.auth.getToken()}` })
    };
    private urlApi = `http://localhost:55132/api/favorite`;
    favorities: FavoriteArray[];
    weather: Weather;
    private _model: WeatherWithUserId;
    constructor(private _http: HttpClient, private _mapService: MapService, private auth: AuthService) { }

    GetFavoritesByUserId(): Observable<Favorite[]> {
        const url = `${this.urlApi}/GetByUserId`;
        return this._http.get<Favorite[]>(url, this.httpOptions);
    }


    AddToFavorite(model: Favorite): Observable<Favorite> {
        const url = `${this.urlApi}/AddToFavorite`;
        return this._http.post<Favorite>(url, model, this.httpOptions);
    }

    DeleteFromFavorite(id: number) {
        const url = `${this.urlApi}/DeleteById/${id}`;
        return this._http.delete(url, this.htttpDelete);
    }
 
} 