import { Component, OnInit, Input } from '@angular/core';
import { MapService } from '../Services/mapService';
import { IWeatherStation } from '../Models/IWeatherStation';
import { Weather } from '../Models/Weather';
import { IWeather } from '../Models/IWeather';
import { FavoriteService } from '../Services/favoriteService';
import { Favorite } from '../Models/Favorite';
import { WeatherService } from '../Services/weatherService';
import { ActivatedRoute } from '@angular/router';

@Component({
    selector: 'app-map',
    templateUrl: './map.component.html',
    styleUrls: ['./map.component.css']
})
export class MapComponent implements OnInit {
    constructor(private _mapService: MapService, private _favService: FavoriteService, private _weatherService: WeatherService,
        private _route: ActivatedRoute) { }
    lat = 50.083328;
    lon = 19.91667;
    weather: Weather;
    markers: IWeatherStation[];
    infoWindowOpened = null;
    favorite = new Favorite();
    ngOnInit() {
        this.SetMarkers();
    }
    GetWeather(cityName: string, infoWindow) {
        this._weatherService.GetWeather(cityName).subscribe(response => {
            this.weather = response;
            console.log(this.weather);
            this.PostWeather();
        });
        if (this.infoWindowOpened !== null) {
            this.infoWindowOpened.close();
        }
        this.infoWindowOpened = infoWindow;
    }
    SetMarkers() {
        this._mapService.GetMarkers().subscribe(response =>
            this.markers = response);
    }

    PostWeather() {
        this._weatherService.PostWeather(this.weather).subscribe();
    }

    AddToFavorite(cityName: string, lat: number, lon: number) {
        this.favorite.cityName = cityName;
        this.favorite.latitude = lat;
        this.favorite.longitude = lon;
        this._favService.AddToFavorite(this.favorite).subscribe();
    }

}