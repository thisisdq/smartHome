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

  public acc: UserAccount = {};
  public tempDevice :any;
  public humiDevice : any;
  public env = {temp: null, humi : null}
  private username:string = "";

  fetchTempHumi(){
    let i = this.userService.fetchTempandHumi(this.username).subscribe(data => {});
  }
  
  public time = Date.now();
  public timeInterval: any;

  public userDataInterval:  any;
  events_Currentday = ['No more event for today','Event 1 was here']

  ngOnInit() {
    this.acc = JSON.parse(localStorage.getItem('session') || 'null') || {};
    if(this.acc.username){
      this.username = this.acc.username;
    }
    this.fetchUserData();
    this.time = Date.now();

    this.timeInterval = setInterval(() => {
      this.time = Date.now();
    }, 1000);
    this.userDataInterval = setInterval(() => {
      this.fetchUserData();
      console.log('IntervalFetch');
    },10000);
  }

  ngOnDestroy() {
    if (this.timeInterval) {
      clearInterval(this.timeInterval);
    }
    if(this.userDataInterval){
      clearInterval(this.userDataInterval);
    }
  }


  fetchUserData() {
    const session = JSON.parse(localStorage.getItem('session') || 'null') || {};
    this.userService.fetchData(session.username).subscribe( (data : any) => {
      this.acc = data;
    });
  }

  logout() {
    console.log('out');
    this.authService.logout();
    this.router.navigateByUrl("/");
    localStorage.removeItem('session');
  }

  saveSession() {
    localStorage.setItem('session', JSON.stringify(this.acc));
  }

  public deviceClick(device : Device) {
    this.saveSession();
    this.deviceService.updateDevicebyStatus(device, device.isRunning == 0 ? this.deviceService.STATUS_ON :this.deviceService.STATUS_OFF);
  }
}
