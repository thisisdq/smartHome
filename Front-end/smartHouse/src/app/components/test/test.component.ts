import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-test',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './test.component.html',
  styleUrl: './test.component.scss'
})
export class TestComponent {

  isChecked : boolean = true;

  checkValue(ischeck : boolean) {
    console.log(ischeck ? "on" : "off");
  }

  btn(){
    this.isChecked = true;
    console.log(this.isChecked);
  }
}
