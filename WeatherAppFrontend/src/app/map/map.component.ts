import { Component, OnInit, Input } from '@angular/core';
import { MapService } from '../Services/mapService';
import { IWeatherStation } from '../Models/IWeatherStation';
import { Weather } from '../Models/Weather';
import { FavoriteService } from '../Services/favoriteService';
import { Favorite } from '../Models/Favorite';
import { WeatherService } from '../Services/weatherService';
import { ActivatedRoute, Router } from '@angular/router';
import { OpenWeatherMapsService } from '../Services/openWeatherMapsService';
import { WeatherFactoryService } from '../Services/WeatherFactoryService';

@Component({
    selector: 'app-map',
    templateUrl: './map.component.html',
    styleUrls: ['./map.component.css']
})
export class MapComponent implements OnInit {
    constructor(private _mapService: MapService, private _favService: FavoriteService, private _weatherService: WeatherService,
        private _router: Router, private _weatherFactoryService: WeatherFactoryService) { }
    lat = 50.083328;
    lon = 19.91667;
    weather: Weather;
    markers: IWeatherStation[];
    infoWindowOpened = null;
    favorite = new Favorite();
    ngOnInit() {
        this.SetMarkers();
    }

    GetWeather(lat: number, lon: number, infoWindow) {
        this._weatherFactoryService.instance.GetWeather(lat, lon).subscribe(response => {
            this.weather = response;
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

    onDetails(lat: number, lon: number){
        const params = {
            lat: lat,
            lon : lon
        };
        this._router.navigate(['details'], {queryParams: params});
    }
}