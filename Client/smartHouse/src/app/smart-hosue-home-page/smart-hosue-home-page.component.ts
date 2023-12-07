import { CommonModule } from '@angular/common';
import { Component, OnInit, OnDestroy } from '@angular/core';

@Component({
  selector: 'app-smart-hosue-home-page',
  standalone: true,
  imports: [CommonModule,],
  templateUrl: './smart-hosue-home-page.component.html',
  styleUrl: './smart-hosue-home-page.component.scss'
})
export class SmartHosueHomePageComponent implements OnInit,OnDestroy {
  constructor(){

  }

  ngOnInit(): void {
    this.time = Date.now();
    this.timeInterval = setInterval(() =>{
      this.time = Date.now();
    },1000)
  }

  ngOnDestroy(): void {

  }

  time : any;
  timeInterval :any;


}
