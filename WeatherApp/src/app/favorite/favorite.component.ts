import { Component, OnInit } from '@angular/core';
import { FavoriteService } from '../Services/favoriteService';
import { Favorite } from '../Models/Favorite';

@Component({
    selector: 'app-favorite',
    templateUrl: 'favorite.component.html',
    styleUrls: ['./favorite.component.css']
})

export class FavoriteComponent implements OnInit {
    constructor(private _favoriteService: FavoriteService) { }

    favorite: Favorite[];

    GetByUserId() {
        return this._favoriteService.GetFavoritesByUserId().subscribe(response => {
            this.favorite = response;
            console.log(response);
        });
    }

    DeleteFavorite(id: number) {
        console.log(id);
        if (id != null) {
            this._favoriteService.DeleteFromFavorite(id).subscribe();
        }
    }


    ngOnInit() {
        this.GetByUserId();
    }
}