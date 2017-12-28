import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { AccountService } from '../Services/accountService';
import { Login } from './Login';
import { AuthService } from '../Services/authService';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {
  loginModel = new Login('', '');
  isAuthenticated: boolean;
  @Output() isAuth = new EventEmitter();
  constructor(private accountService: AccountService) { }

  Login() {
    //json.stringify
    this.accountService.Login(this.loginModel).subscribe(response => {
      localStorage.setItem('token', response.access_token);
      this.isAuthenticated = true;
      this.isAuth.emit(this.isAuthenticated);
    });

  }


  Order() {
    this.accountService.Get().subscribe(response => {
      console.log(response);
    });
  }


  ngOnInit() {
  }

}
