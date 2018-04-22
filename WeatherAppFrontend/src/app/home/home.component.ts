import { Component, OnInit } from '@angular/core';
import { WeatherFactoryService } from '../Services/WeatherFactoryService';

@Component({
    selector: 'app-home',
    templateUrl: 'home.component.html',
    styleUrls: ['./home.component.css']
})

export class HomeComponent implements OnInit {
    clickedImage;
    constructor( private _weatherFactoryService: WeatherFactoryService) { }
    switchWeatherApi(name: string) {
        if (name === `OpenWeatherMaps`) {
            this._weatherFactoryService.state = 'OpenWeatherMaps';
            this.clickedImage = 'OpenWeatherMaps';

        }else if (name === 'Apixu') {
            this._weatherFactoryService.state = 'Apixu';
            this.clickedImage = 'Apixu';
        }
    }
    ngOnInit() { }
}