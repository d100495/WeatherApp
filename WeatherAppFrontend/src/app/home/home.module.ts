import { NgModule } from '@angular/core';
import { HomeComponent } from './home.component';
import { HomeRoutingModule } from './home-routing.module';
import { BrowserModule } from '@angular/platform-browser';


@NgModule({
    imports: [HomeRoutingModule,
        BrowserModule],
    exports: [],
    declarations: [HomeComponent],
    providers: [],
})
export class HomeModule { }
