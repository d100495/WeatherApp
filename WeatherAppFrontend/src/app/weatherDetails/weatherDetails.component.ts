import { Component, OnInit } from '@angular/core';
import { WeatherService } from '../Services/weatherService';
import { IWeatherForecast } from '../Models/IWeatherForecast';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-weatherDetails',
  templateUrl: './weatherDetails.component.html',
  styleUrls: ['./weatherDetails.component.css'],
})
export class WeatherDetailsComponent implements OnInit {
  weather: IWeatherForecast;
  constructor(private _weatherService: WeatherService, private _route: ActivatedRoute, private _router: Router) { }
  ngOnInit() {
    this.GetForecastWeather();
  }

  GetForecastWeather(){
    const cityName = this._route.snapshot.paramMap.get('cityName');
    return this._weatherService.GetForecastWeather(cityName).subscribe(response => {
      this.weather = response;
      console.log(this.weather);
    });
  }

}
