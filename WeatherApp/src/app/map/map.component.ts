import { Component, OnInit, Input } from '@angular/core';
import { MapService } from '../Services/mapService';
import { Marker } from './Marker';
import { Weather } from './Weather';
import { IWeather } from './IWeather';
@Component({
    selector: 'app-map',
    templateUrl: './map.component.html',
    styleUrls: ['./map.component.css']
})
export class MapComponent implements OnInit {
    constructor(private _mapService: MapService) { }
    lat = 50.083328;
    lon = 19.91667;
    weather: Weather;
    markers: Marker[];
    infoWindowOpened = null;
    ngOnInit() {
        this.SetMarkers();
    }
    GetWeather(cityName: string, infoWindow) {
        this._mapService.GetWeather(cityName).subscribe(response => {
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
        this._mapService.GetMarkers().subscribe(response => this.markers = response);
    }

    PostWeather() {
        this._mapService.PostWeather(this.weather).subscribe();
    }

}