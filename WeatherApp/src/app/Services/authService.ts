import { Injectable } from '@angular/core';

@Injectable()
export class AuthService {


//json.parse
  public getToken(): string {
    return localStorage.getItem('token');
  }

 
}