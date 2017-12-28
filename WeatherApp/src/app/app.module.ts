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
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';


@NgModule({
  declarations: [
    AppComponent,
    MapComponent,
    NavComponent,
    AccountComponent
  ],
  imports: [CommonModule,
    FormsModule,
    MapModule,
    BrowserModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyC2MLYTYjIMBmj3P_Mvk2khw0YCcpBymKE'
    }),
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [SharedService, MapService, AuthService, AccountService],
  bootstrap: [AppComponent]
})
export class AppModule { }
