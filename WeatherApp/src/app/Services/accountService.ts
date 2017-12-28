import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, tap, map } from 'rxjs/operators';
import { Login } from '../account/Login';
import { Observable } from 'rxjs/Observable';
import { RequestOptions, RequestOptionsArgs } from '@angular/http';
import { AuthService } from './authService';



@Injectable()
export class AccountService {
    private url = 'http://localhost:55132/token';
    private urll = 'http://localhost:55132/api/orders';
    private httpOptions = {
        headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Authorization' : `Bearer ${this.auth.getToken()}` })
    };
    constructor(private httpClient: HttpClient, public auth: AuthService) { }


    Get(): Observable<any>{
        return this.httpClient.get(this.urll, this.httpOptions);
    }

    Login(loginData: Login): Observable<any> {
        const body = new URLSearchParams();
        body.set('grant_type', 'password');
        body.set('username', loginData.username);
        body.set('password', loginData.password);
        return this.httpClient.post(this.url, body.toString());
    }

    logOut(){
        localStorage.clear();

    }




}
