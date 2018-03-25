import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { AgmCoreModule } from '@agm/core';
import { MapComponent } from './map/map.component';
import { MapService } from './Services/mapService';

import { NavComponent } from './nav/nav.component';
import { AppRoutingModule } from './app-routing.module';
import { MapModule } from './map/map.module';
import { SharedService } from '../Shared/shared.service';
import { AccountComponent } from './account/account.component';
import { AuthService } from './Services/authService';
import { AccountService } from './Services/accountService';
import { CommonModule, DatePipe } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { HomeComponent } from './home/home.component';
import { HistoryModule } from './history/history.module';
import { FavoriteModule } from './favorite/favorite.module';
import { WeatherDetailsComponent } from './weatherDetails/weatherDetails.component';
import { DateTransformPipe } from './Pipes/DateTransformPipe';


@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    AccountComponent,
    HomeComponent,
    WeatherDetailsComponent,
    DateTransformPipe
  ],
  imports: [CommonModule,
    FormsModule,
    MapModule,
    FavoriteModule,
    HistoryModule,
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
  ],
  providers: [SharedService, AuthService, AccountService],
  bootstrap: [AppComponent]
})
export class AppModule { }