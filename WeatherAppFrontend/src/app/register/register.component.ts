import { Component, OnInit } from '@angular/core';
import { AccountService } from '../Services/accountService';
import {Register} from '../Models/Register';
import { Router } from '@angular/router';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  registerModel = new Register('', '', '');
  registerResposne: Register;
  isSuccess: boolean;
  isFail: boolean;
  constructor(private _accountService: AccountService, private _router: Router) { }

  ngOnInit() {
  }

  Register() {
    this._accountService.Register(this.registerModel).subscribe(response => {
      this.registerResposne = response;
      if (response) {
        this.isSuccess = true;
        this._router.navigate(['login']);
      }
    },
      error => {
        this.isFail = true;
      });
  }


}
