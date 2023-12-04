import { Component, OnInit, OnDestroy } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent  implements OnInit, OnDestroy {
  title = 'smartHouse';

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
