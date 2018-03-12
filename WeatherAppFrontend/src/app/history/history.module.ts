import { NgModule } from '@angular/core';
import { HistoryRoutingModule } from './history-routing.module';
import { HistoryComponent } from './history.component';
import { MapService } from '../Services/mapService';
import { CommonModule } from '@angular/common';
import { WeatherService } from '../Services/weatherService';


@NgModule({
    imports: [CommonModule,
        HistoryRoutingModule],
    exports: [],
    declarations: [HistoryComponent],
    providers: [WeatherService],
})
export class HistoryModule { }
