import { Injectable } from '@angular/core';
import { AuthService } from 'angular4-social-login';
@Injectable()
export class SharedService {

    constructor(private authService: AuthService) { }
    SignOut(){
        this.authService.signOut();
    }
}