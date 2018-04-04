import { Component, OnInit } from '@angular/core';
import { AuthService } from './Services/authService';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  isAuth: boolean;

  constructor(private _authService: AuthService) { }

  ngOnInit(): void {
    this.isLogged();
  }

  isLogged() {
    this._authService.isLogged().subscribe(response => {
      this.isAuth = response;
    });
  }
}
