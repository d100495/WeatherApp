import { Component, OnInit } from '@angular/core';
import { MapService } from '../Services/mapService';
import { Weather } from '../Models/Weather';
import { WeatherService } from '../Services/weatherService';
import { IPaginateWeatherHistory } from '../Models/IPaginateWeatherHistory';

@Component({
    selector: 'app-history',
    templateUrl: 'history.component.html',
    styleUrls: ['./history.component.css']
})

export class HistoryComponent implements OnInit {
    weather: IPaginateWeatherHistory;
    constructor(private _weatherService: WeatherService) { }

    GetHistory() {
        this._weatherService.GetPaginateHistory().subscribe(response => {
            this.weather = response;
        });
    }
    ngOnInit() {
        this.GetHistory();
    }

    NextPage(){
        this._weatherService.GoToPages(this.weather.paging.next).subscribe(response => {
            this.weather = response;
        });
    }

    PreviousPage(){
        this._weatherService.GoToPages(this.weather.paging.previous).subscribe(response => {
            this.weather = response;
        });
    }

    FirstPage(){
        this._weatherService.GoToPages(this.weather.paging.first).subscribe(response => {
            this.weather = response;
        });
    }

    LastPage(){
        this._weatherService.GoToPages(this.weather.paging.last).subscribe(response => {
            this.weather = response;
        });
    }
}