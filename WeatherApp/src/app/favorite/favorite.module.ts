import { NgModule } from '@angular/core';
import { MapService } from '../Services/mapService';
import { CommonModule } from '@angular/common';
import { FavoriteRoutingModule } from './favorite-routing.module';
import { FavoriteComponent } from './favorite.component';


@NgModule({
    imports: [CommonModule,
        FavoriteRoutingModule],
    exports: [],
    declarations: [FavoriteComponent],
    providers: [MapService],
})
export class FavoriteModule { }
