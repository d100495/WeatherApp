import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { FavoriteArray } from '../Models/FavoriteArray';
import { MapService } from './mapService';
import { Weather } from '../Models/Weather';
import { WeatherWithUserId } from '../Models/WeatherWithUserId';
import { Favorite } from '../Models/Favorite';
import { AuthService } from './authService';


@Injectable()
export class FavoriteService {
    private httpOptions = {
        headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Authorization': `Bearer ${this.auth.getToken()}` })
    };

    private urlApi = `http://localhost:55132/api/favorite`;
    favorities: FavoriteArray[];
    weather: Weather;
    private _model: WeatherWithUserId;
    constructor(private _http: HttpClient, private _mapService: MapService, private auth: AuthService) { }
    Init() {
        console.log('initservice');
        setInterval(()=> {
            this.SaveToArray();
        },25000);

        setInterval(() => {
          this.GetWeatherForFavorites();
        }, 30000);
    }

    GetFavoritesByUserId(): Observable<Favorite[]> {
        const url = `${this.urlApi}/GetByUserId`;
        return this._http.get<Favorite[]>(url, this.httpOptions);
    }

    AddToFavorite(model: Favorite): Observable<Favorite> {
        const url = `${this.urlApi}/AddToFavorite`;
        return this._http.post<Favorite>(url, model, this.httpOptions);
    }
    GetAll(): Observable<FavoriteArray[]> {
        const url = `${this.urlApi}/GetAll`;
        return this._http.get<FavoriteArray[]>(url);
    }

    SaveToArray() {
        this.GetAll().subscribe(response => {
            this.favorities = response;
        });
    }

    GetWeatherForFavorites() {
        for (let item of this.favorities) {

            this._mapService.GetWeather(item.cityName).subscribe(response => {
                this.weather = response;
            });
            for (let id of item.id) {
                console.log('PostHistoryFromFavorite');
               setTimeout(() =>{
                this.PostWeatherFromFavorites(id).subscribe();
               }
               , 2000);
            }

        }
    }

    PostWeatherFromFavorites(id: string): Observable<WeatherWithUserId> {
        const url = `http://localhost:55132/api/weather/PostHistoryFromFavorite`;
        this._model = new WeatherWithUserId(this.weather.Temperature,
            this.weather.Longitude, this.weather.Latitude, this.weather.Pressure, this.weather.WindSpeed, id);
        return this._http.post<WeatherWithUserId>(url, this._model);
    }
} 