import { NgModule } from '@angular/core';
import { HistoryRoutingModule } from './history-routing.module';
import { HistoryComponent } from './history.component';
import { MapService } from '../Services/mapService';
import { CommonModule, DatePipe } from '@angular/common';
import { WeatherService } from '../Services/weatherService';
import { MatDatepickerModule } from '@angular/material/datepicker';
import {MatInputModule, MatFormFieldModule, MatSelectModule, MatNativeDateModule, DateAdapter, MAT_DATE_FORMATS} from '@angular/material';
import { FormsModule } from '@angular/forms';

@NgModule({
    imports: [CommonModule,
        HistoryRoutingModule,
        MatDatepickerModule,
        MatInputModule,
        MatFormFieldModule,
        MatSelectModule,
        MatNativeDateModule,
        FormsModule,
    ],
    exports: [MatNativeDateModule],
    declarations: [HistoryComponent],
    providers: [WeatherService, DatePipe],
})
export class HistoryModule { }
