import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, tap, map } from 'rxjs/operators';
import { RequestOptions, RequestOptionsArgs } from '@angular/http';
import { AuthService } from './authService';
import { Observable } from 'rxjs/Observable';
import { Login } from '../Models/Login';
import { Register } from '../Models/Register';
import { IUser } from '../Models/User';



@Injectable()
export class AccountService {
    private url = 'http://mypenisred1-001-site1.atempurl.com/token';
    private accountUrl = 'http://mypenisred1-001-site1.atempurl.com/api/account';
    private httpOptions = {
        headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Authorization': `Bearer ${this._authService.getToken()}` })
    };

    private httpOptionsRegister = {
        headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    };
    constructor(private _http: HttpClient, public _authService: AuthService) { }


    Login(loginData: Login): Observable<any> {
        const body = new URLSearchParams();
        body.set('grant_type', 'password');
        body.set('username', loginData.username);
        body.set('password', loginData.password);
        return this._http.post(this.url, body.toString());
    }

    Register(registerData: Register): Observable<Register> {
        const url = `${this.accountUrl}/register`;
        return this._http.post<Register>(url, registerData,  this.httpOptionsRegister).pipe(
            catchError((error: any) => Observable.throw(error.json().error || 'Server error'))
        );
    }
    GetUserInfo(): Observable<IUser> {
        return this._http.get<IUser>(this.accountUrl, this.httpOptions);
    }

    logOut() {
        this._authService.IsAuth = false;
        localStorage.clear();

    }




}
