import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { FavoriteComponent } from './favorite.component';
import { LoginGuardService } from '../Services/loginGuardService';



const routes: Routes = [
    { path: 'favorite', component: FavoriteComponent, canActivate: [LoginGuardService] },
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class FavoriteRoutingModule {}
