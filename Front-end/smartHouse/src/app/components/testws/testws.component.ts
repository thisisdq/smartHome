import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-testws',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './testws.component.html',
  styleUrl: './testws.component.scss'
})
export class TestwsComponent {
  data:any; 
}
