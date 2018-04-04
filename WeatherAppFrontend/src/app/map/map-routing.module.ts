import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { MapComponent } from './map.component';
import { WeatherDetailsComponent } from '../weatherDetails/weatherDetails.component';
import { LoginGuardService } from '../Services/loginGuardService';




const routes: Routes = [
    { path: 'map', component: MapComponent, canActivate: [LoginGuardService] },
    { path: 'details/:cityName', component: WeatherDetailsComponent},
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class MapRoutingModule {}
