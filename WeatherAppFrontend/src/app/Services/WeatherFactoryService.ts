import { Injectable } from '@angular/core';
import { OpenWeatherMapsService } from './openWeatherMapsService';
import { ApixuService } from './apixuService';
import { IWeatherService } from '../Models/IWeatherService';

@Injectable()
export class WeatherFactoryService {
    public state = 'OpenWeatherMaps';
    constructor(private openWeatherMapService: OpenWeatherMapsService, private apixuService: ApixuService) { }

    public get instance(): IWeatherService {
        if (this.state === 'OpenWeatherMaps') {
            return this.openWeatherMapService;
        } if(this.state === 'Apixu') {
            return this.apixuService;
        }

    }