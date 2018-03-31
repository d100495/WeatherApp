import { Component, OnInit } from '@angular/core';
import { WeatherFactoryService } from '../Services/WeatherFactoryService';

@Component({
    selector: 'app-home',
    templateUrl: 'home.component.html'
})

export class HomeComponent implements OnInit {
    constructor( private _weatherFactoryService: WeatherFactoryService) { }
    switchWeatherApi(name: string) {
        if (name === `OpenWeatherMaps`) {
            this._weatherFactoryService.state = 'OpenWeatherMaps';

        }else if (name === 'Apixu') {
            this._weatherFactoryService.state = 'Apixu';
        }
    }
    ngOnInit() { }
}