import { Component } from '@angular/core';

@Component({
  selector: 'app-test',
  standalone: true,
  imports: [],
  templateUrl: './test.component.html',
  styleUrl: './test.component.scss'
})
export class TestComponent {
  divclick(){
    console.log('div');
    
  }

  btnclick(event : Event){
    event.stopPropagation();
    console.log('btn');
    
  }
}
