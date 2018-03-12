import { Component, OnInit } from '@angular/core';
import { MapService } from '../Services/mapService';
import { Weather } from '../Models/Weather';
import { WeatherService } from '../Services/weatherService';

@Component({
    selector: 'app-history',
    templateUrl: 'history.component.html',
    styleUrls: ['./history.component.css']
})

export class HistoryComponent implements OnInit {
    weather: Weather[];
    constructor(private _weatherService: WeatherService) { }

    GetHistory() {
        this._weatherService.GetHistory().subscribe(response => {
            this.weather = response;
        });
    }
    ngOnInit() {
        this.GetHistory();
        // setInterval(() => {
        //     this.GetHistory();
        // }, 5000);


    }
}