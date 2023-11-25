import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { DeviceLightComponent } from "./components/device-light/device-light.component";
import { LoginPageComponent } from './components/login-page/login-page.component';

import { FormsModule } from '@angular/forms';


@Component({
    selector: 'app-root',
    standalone: true,
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css'],
    imports: [CommonModule, RouterOutlet, DeviceLightComponent,LoginPageComponent]
})
export class AppComponent {
  title = 'SmartHouse';
}
