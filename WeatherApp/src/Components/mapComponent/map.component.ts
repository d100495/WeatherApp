import { Component, OnInit, Input } from '@angular/core';
import { MapService } from './mapService';
import { Marker } from './Marker';
@Component({
    selector: 'app-map',
    templateUrl: './map.component.html',
    styleUrls: ['./map.component.css']
})
export class MapComponent implements OnInit {
    constructor(private _mapService: MapService) { }
    lat: number = 50.083328;
    lon: number = 19.91667;
    weather;
    markers: Marker[];
    flag: boolean;
    infoWindowOpened = null;
    ngOnInit() {
        this.SetMarkers();
    }
    GetWeather(cityName: string, infoWindow) {
        this._mapService.GetWeather(cityName).subscribe(response => {
            this.weather = response;
        });

       

        if (this.infoWindowOpened !== null) {
            this.infoWindowOpened.close();
        }
        this.infoWindowOpened = infoWindow;
    }
    SetMarkers() {
        this._mapService.GetMarkers().subscribe(response => this.markers = response);

    }




}