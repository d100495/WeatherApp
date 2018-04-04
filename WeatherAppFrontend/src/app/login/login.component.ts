import { Component, OnInit } from '@angular/core';
import { AccountService } from '../Services/accountService';
import { Login } from '../Models/Login';
import { AuthService } from '../Services/authService';
import { Router } from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginModel = new Login('', '');

  constructor(private accountService: AccountService, private _authService: AuthService, private _router: Router) { }

  ngOnInit() {
  }

  Login() {
    this.accountService.Login(this.loginModel).subscribe(response => {
      if (response) {
        this._authService.IsAuth = true;
        localStorage.setItem('token', response.access_token);
        this._router.navigate(['/home']);
      }
    },
  error => {
    this._authService.IsAuth = false;
  });
  }

}
