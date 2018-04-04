import { Injectable } from '@angular/core';
import { AuthService } from './authService';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class LoginGuardService implements CanActivate {


    constructor(private _authService: AuthService, private _router: Router) { }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | Observable<boolean> | Promise<boolean> {
        if (!this._authService.IsAuth) {
            this._router.navigate(['login']);
        }
        return true;
    }
}