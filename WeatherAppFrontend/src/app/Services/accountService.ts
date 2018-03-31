import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, tap, map } from 'rxjs/operators';
import { Login } from '../account/Login';
import { RequestOptions, RequestOptionsArgs } from '@angular/http';
import { AuthService } from './authService';
import { Observable } from 'rxjs/Observable';
import { IUser } from '../account/User';
import { Register } from '../account/Register';



@Injectable()
export class AccountService {
    private url = 'http://localhost:55132/token';
    private accountUrl = 'http://localhost:55132/api/account';
    private httpOptions = {
        headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Authorization': `Bearer ${this.auth.getToken()}` })
    };

    private httpOptionsRegister = {
        headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    };
    constructor(private _http: HttpClient, public auth: AuthService) { }


    Login(loginData: Login): Observable<any> {
        const body = new URLSearchParams();
        body.set('grant_type', 'password');
        body.set('username', loginData.username);
        body.set('password', loginData.password);
        return this._http.post(this.url, body.toString());
    }

    Register(registerData: Register): Observable<Register> {
        const url = 'http://localhost:55132/api/account/register';
        return this._http.post<Register>(url, registerData,  this.httpOptionsRegister).pipe(
            catchError((error: any) => Observable.throw(error.json().error || 'Server error'))
        );
    }
    GetUserInfo(): Observable<IUser> {
        return this._http.get<IUser>(this.accountUrl, this.httpOptions);
    }

    logOut() {
        localStorage.clear();

    }




}