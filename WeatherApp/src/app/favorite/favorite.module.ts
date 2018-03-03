import { NgModule } from '@angular/core';
import { MapService } from '../Services/mapService';
import { CommonModule } from '@angular/common';
import { FavoriteRoutingModule } from './favorite-routing.module';
import { FavoriteComponent } from './favorite.component';
import { FavoriteService } from '../Services/favoriteService';


@NgModule({
    imports: [CommonModule,
        FavoriteRoutingModule],
    exports: [],
    declarations: [FavoriteComponent],
    providers: [MapService, FavoriteService],
})
export class FavoriteModule { }
