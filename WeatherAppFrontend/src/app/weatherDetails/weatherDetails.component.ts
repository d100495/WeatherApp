import { Component, OnInit } from '@angular/core';
import { WeatherService } from '../Services/weatherService';
import { ActivatedRoute, Router } from '@angular/router';
import { OpenWeatherMapsService } from '../Services/openWeatherMapsService';
import { WeatherFactoryService } from '../Services/WeatherFactoryService';
import { ForecastWeather } from '../Models/ForecastWeather';

@Component({
  selector: 'app-weatherDetails',
  templateUrl: './weatherDetails.component.html',
  styleUrls: ['./weatherDetails.component.css'],
})
export class WeatherDetailsComponent implements OnInit {
  weather: ForecastWeather[];
  constructor(private _weatherService: WeatherFactoryService, private _route: ActivatedRoute, private _router: Router) { }
  ngOnInit() {
    this.GetForecastWeather();
  }

  GetForecastWeather() {
    const lat = this._route.snapshot.paramMap.get('lat');
    const lon = this._route.snapshot.paramMap.get('lon');
    return this._weatherService.instance.GetForecastWeather(+lat, +lon).subscribe(response => {
      this.weather = response;
    });
  }

}
