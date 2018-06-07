import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
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

import { MatTabsModule } from '@angular/material/tabs';
import { MatCardModule } from '@angular/material/card';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatDatepickerModule } from '@angular/material/datepicker';
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
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    RegisterModule,
    HomeModule,
    HistoryModule,
    MatTabsModule,
    MatCardModule,
    BrowserAnimationsModule,
    MatExpansionModule,
    
  ],
  providers: [SharedService, AuthService, AccountService, LoginGuardService],
  bootstrap: [AppComponent]
})
export class AppModule { }