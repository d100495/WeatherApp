import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs/';
import { MapService } from './mapService';
import { Weather } from '../Models/Weather';
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
    private urlApi = `http://weatherapp-001-site1.gtempurl.com/api/favorite`;
    weather: Weather;
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
