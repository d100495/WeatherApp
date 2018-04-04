import { Injectable, EventEmitter, Output } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/of';
@Injectable()
export class AuthService {

  private _isAuth: boolean;
  @Output() fire: EventEmitter<any> = new EventEmitter();
  get IsAuth() {
    return this._isAuth;
  }

  set IsAuth(value: boolean) {
    if(value === true){
    this.fire.emit(true);
    } else{
      this.fire.emit(false);
    }
    this._isAuth = value;
  }
  public getToken(): string {
    return localStorage.getItem('token');
  }

  isLogged() {
    return this.fire;
  }
}