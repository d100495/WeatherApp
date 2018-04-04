import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { SharedService } from '../Shared/shared.service';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FavoriteModule } from './favorite/favorite.module';
import { HistoryModule } from './history/history.module';
import { HomeModule } from './home/home.module';
import { LoginComponent } from './login/login.component';
import { MapModule } from './map/map.module';
import { NavComponent } from './nav/nav.component';
import { RegisterModule } from './register/register.module';
import { AccountService } from './Services/accountService';
import { AuthService } from './Services/authService';
import { WeatherDetailsComponent } from './weatherDetails/weatherDetails.component';
import { LoginGuardService } from './Services/loginGuardService';



@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    LoginComponent,
    WeatherDetailsComponent
  ],
  imports: [CommonModule,
    FormsModule,
    MapModule,
    FavoriteModule,
    HistoryModule,
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    RegisterModule,
    HomeModule
  ],
  providers: [SharedService, AuthService, AccountService, LoginGuardService],
  bootstrap: [AppComponent]
})
export class AppModule { }