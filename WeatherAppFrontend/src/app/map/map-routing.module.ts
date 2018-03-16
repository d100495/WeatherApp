import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { MapComponent } from './map.component';
import { WeatherDetailsComponent } from '../weatherDetails/weatherDetails.component';




const routes: Routes = [
    { path: 'map', component: MapComponent},
    { path: 'details/:cityName', component: WeatherDetailsComponent},
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class MapRoutingModule {}
