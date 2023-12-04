import { CommonModule } from '@angular/common';
import { Component , OnInit,OnDestroy } from '@angular/core';

@Component({
  selector: 'app-test',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './test.component.html',
  styleUrl: './test.component.scss'
})
export class TestComponent implements OnInit, OnDestroy {
  constructor(){

  }

  public time = Date.now();
  public timeInterval :any;

  ngOnInit(): void {
    this.time = Date.now();
    this.timeInterval = setInterval(() =>{
      this.time = Date.now();
    },1000)
  }

  ngOnDestroy(): void {
      if(this.timeInterval){
        clearInterval(this.timeInterval);
      }
  }
}
