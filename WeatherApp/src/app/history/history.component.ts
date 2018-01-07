import { Component, OnInit } from '@angular/core';
import { MapService } from '../Services/mapService';
import { Weather } from '../Models/Weather';

@Component({
    selector: 'app-history',
    templateUrl: 'history.component.html',
    styleUrls: ['./history.component.css']
})

export class HistoryComponent implements OnInit {
    weather : Weather;
    constructor(private _mapService: MapService) { }

    GetHistory(){
        this._mapService.GetHistory().subscribe(response => {
            this.weather = response;
        });
    }

    ngOnInit() {
        this.GetHistory();
     }
}