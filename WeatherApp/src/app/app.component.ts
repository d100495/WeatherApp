import { Component, OnInit } from '@angular/core';
import { FavoriteService } from './Services/favoriteService';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
 
  title = 'app';
  isAuth = false;

  constructor(private _favoriteService: FavoriteService){}
  
  ngOnInit(): void {
    
   }
 
}
