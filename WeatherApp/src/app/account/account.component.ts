import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { AccountService } from '../Services/accountService';
import { Login } from './Login';
import { AuthService } from '../Services/authService';
import { IUser } from './User';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {
  loginModel = new Login('', '');
  isAuthenticated: boolean;
  user: IUser;
  @Output() isAuth = new EventEmitter();
  constructor(private accountService: AccountService) { }

  Login() {
    this.accountService.Login(this.loginModel).subscribe(response => {
      localStorage.setItem('token', response.access_token);
      this.isAuthenticated = true;
      this.isAuth.emit(this.isAuthenticated);
    });
    this.GetUserInfo();
  }

  GetUserInfo(){
    this.accountService.GetUserInfo().subscribe(response => {
      this.user = response
    });
  
  }


  ngOnInit() {
  }

}
