import { Component } from "@angular/core";
import { AuthenticationService } from "../../authentication.service";
import { Router } from "@angular/router";
import { DEVICE_TYPE, Device, Floor, House, Room, UserAccount } from "../../module";
import { CommonModule } from "@angular/common";
import { CalendarComponent } from "../calendar/calendar.component";
import { UserService } from "../../user.service";
import { DeviceService } from "../../device.service";

@Component({
  selector: "app-smart-house-controll-page",
  standalone: true,
  imports: [CommonModule,CalendarComponent],
  templateUrl: "./smart-house-controll-page.component.html",
  styleUrl: "./smart-house-controll-page.component.scss",
})
export class SmartHouseControllPageComponent {
  constructor(
    private authService: AuthenticationService,
    private router: Router,
    private userService: UserService,
    private deviceService: DeviceService
  ) {}

  public time = Date.now();
  public timeInterval: any;
  events_Currentday = ['No more event for today','Event 1 was here']

  ngOnInit() {
    this.fetchUserData();
    
    this.time = Date.now();
    this.timeInterval = setInterval(() => {
      this.time = Date.now();
    }, 1000);

    //Conection Websocket
  }

  ngOnDestroy() {
    this.saveSession();
    if (this.timeInterval) {
      clearInterval(this.timeInterval);
    }

    // Destroy Websocket Connection
  }

  public acc: UserAccount = {};

  fetchUserData() {
    this.acc = JSON.parse(localStorage.getItem('session') || 'null') || {};
  }

  logout() {
    this.authService.logout();
    this.router.navigateByUrl("/");
    localStorage.removeItem('session');
  }

  saveSession() {
    localStorage.setItem('session', JSON.stringify(this.acc));
  }

  public deviceClick(device : Device) {
    console.log(device);
    device.isRunning = device.isRunning == 0 ? 1 : 0;
    this.saveSession();
    this.deviceService.updateDevice(device);
  }
}
