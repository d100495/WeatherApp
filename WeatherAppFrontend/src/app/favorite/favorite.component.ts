import { Component, OnInit, NgZone } from '@angular/core';
import { FavoriteService } from '../Services/favoriteService';
import { Favorite } from '../Models/Favorite';
import { Observable } from 'rxjs/Observable';

@Component({
    selector: 'app-favorite',
    templateUrl: 'favorite.component.html',
    styleUrls: ['./favorite.component.css']
})

export class FavoriteComponent implements OnInit {
    constructor(private _favoriteService: FavoriteService) { }

    favorite: Favorite[];

    ngOnInit() {
        this.GetByUserId();
    }
    GetByUserId() {
        return this._favoriteService.GetFavoritesByUserId().subscribe(response => {
            this.favorite = response;
        });
    }

    DeleteFavorite(id: number) {
        if (id != null) {
            this._favoriteService.DeleteFromFavorite(id).subscribe();
            this.GetByUserId();
        }
    }


}
