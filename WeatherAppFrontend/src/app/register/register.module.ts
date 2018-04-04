import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { AccountService } from '../Services/accountService';
import { RegisterComponent } from './register.component';
import { RegisterRoutingModule } from './register-routing.module';
import { FormsModule } from '@angular/forms';


@NgModule({
    imports: [RegisterRoutingModule,
        FormsModule,
        CommonModule],
    exports: [],
    declarations: [RegisterComponent],
    providers: [AccountService],
})
export class RegisterModule { }
