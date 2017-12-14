import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { AgmCoreModule } from '@agm/core';
import { MapComponent } from './map/map.component';
import { MapService } from './map/mapService';
import { HttpClientModule } from '@angular/common/http';
import { GoogleComponent } from './google/google.component';
import { SocialLoginModule, AuthServiceConfig } from 'angular4-social-login';
import { GoogleLoginProvider } from 'angular4-social-login';
import { NavComponent } from './nav/nav.component';
import { AppRoutingModule } from './app-routing.module';
import { MapModule } from './map/map.module';
import { SharedService } from '../Shared/shared.service';

const config = new AuthServiceConfig([
  {
    id: GoogleLoginProvider.PROVIDER_ID,
    provider: new GoogleLoginProvider('146476582627-eus7lbh08tc3j7sncsui8n79pgjtgtpn.apps.googleusercontent.com')
  }
]);


@NgModule({
  declarations: [
    AppComponent,
    MapComponent,
    GoogleComponent,
    NavComponent
  ],
  imports: [
    MapModule,
    BrowserModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyC2MLYTYjIMBmj3P_Mvk2khw0YCcpBymKE'
    }),
    HttpClientModule,
    SocialLoginModule.initialize(config),
    AppRoutingModule
  ],
  providers: [SharedService, MapService],
  bootstrap: [AppComponent]
})
export class AppModule { }
