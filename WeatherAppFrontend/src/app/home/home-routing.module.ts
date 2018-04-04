import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home.component';
import { LoginGuardService } from '../Services/loginGuardService';


const routes: Routes = [
    { path: 'home', component: HomeComponent, canActivate: [LoginGuardService] },
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule],
})
export class HomeRoutingModule { }
