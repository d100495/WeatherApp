import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MapRoutingModule } from './map-routing.module';
import { MapService } from '../Services/mapService';
import { MapComponent } from './map.component';
import { AgmCoreModule } from '@agm/core';
import { WeatherService } from '../Services/weatherService';

@NgModule({
    declarations: [MapComponent],
    imports: [CommonModule,
        AgmCoreModule.forRoot({
            apiKey: 'AIzaSyC2MLYTYjIMBmj3P_Mvk2khw0YCcpBymKE'
        }),
        MapRoutingModule],
    exports: [],
    providers: [MapService, WeatherService],
})
export class MapModule { }