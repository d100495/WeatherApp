import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { AccountService } from '../Services/accountService';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {
  constructor(private accountService: AccountService) { }
  isAuthenticated: boolean;
  @Output() isAuth = new EventEmitter();
  ngOnInit() {
  }


  LogOut(){
    this.accountService.logOut();
    this.isAuthenticated = false;
    this.isAuth.emit(this.isAuthenticated);
  }

}
