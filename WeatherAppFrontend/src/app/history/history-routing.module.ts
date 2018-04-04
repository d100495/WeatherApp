import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { HistoryComponent } from './history.component';
import { LoginGuardService } from '../Services/loginGuardService';




const routes: Routes = [
    { path: 'history', component: HistoryComponent, canActivate: [LoginGuardService] },
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class HistoryRoutingModule {}
