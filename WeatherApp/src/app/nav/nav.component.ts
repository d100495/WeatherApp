import { Component, OnInit } from '@angular/core';
import { Output } from '@angular/core/src/metadata/directives';
import { EventEmitter } from '@angular/core/src/event_emitter';
import { SharedService } from '../../Shared/shared.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {
  constructor(private sharedService: SharedService) { }

  SignOut(){
    this.sharedService.SignOut();
  }
  ngOnInit() {
  }

}
