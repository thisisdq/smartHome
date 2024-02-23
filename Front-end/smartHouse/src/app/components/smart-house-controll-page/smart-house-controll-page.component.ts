import { Component } from "@angular/core";
import { AuthenticationService } from "../../authentication.service";
import { Router } from "@angular/router";
import { DEVICE_TYPE, Device, Floor, House, Room, TemperatureAndHumidity, UserAccount } from "../../module";
import { CommonModule } from "@angular/common";
import { CalendarComponent } from "../calendar/calendar.component";
import { UserService } from "../../user.service";
import { DeviceService } from "../../device.service";
import { FormsModule } from "@angular/forms";

@Component({
  selector: "app-smart-house-controll-page",
  standalone: true,
  imports: [CommonModule,CalendarComponent, FormsModule],
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
  private username:string = "";
  public time = Date.now();
  public timeInterval: any;
  public TempAndHumiInterval: any;

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

    this.TempAndHumiInterval = setInterval(() => {
      this.fetchTempHumi();
    },1000);
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
    localStorage.setItem('session', JSON.stringify(this.acc))
  }

  fetchTempHumi(){
    const session = JSON.parse(localStorage.getItem('session') || 'null') || {};
    this.userService.fetchTempandHumi(session.username).subscribe( (data : TemperatureAndHumidity) => {
      this.acc.temperature = data.temperature;
      this.acc.humidity = data.humidity;
    })
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



  public deviceClick(device : Device) {
    console.log('deviceClick');
    let d : Device = {};
    d.id = device.id;
    d.isRunning = device.isRunning == 0 ? this.deviceService.STATUS_ON :this.deviceService.STATUS_OFF;
    d.deviceValue = device.deviceValue;
    this.deviceService.updateDevicebyStatus(d).subscribe( (data : Device )=> {
      device = data;
    });
    this.fetchUserData();
  }

  logplus(device : Device, event : Event) {
    event.stopPropagation();
    let d : Device = {};
    d.id = device.id;
    d.isRunning = this.deviceService.STATUS_ON;
    d.deviceValue = (device.deviceValue! + 1) > 32 ? 32 : (device.deviceValue! + 1) ;
    console.log('+ ' + d.deviceValue );
    this.deviceService.updateDevicebyStatus(d).subscribe( (data : Device) => {
      device = data;
      console.log(data.deviceValue);
    });
    this.fetchUserData();
  }
  logsub(device : Device, event : Event) {
    event.stopPropagation();
    let d : Device = {};
    d.id = device.id;
    d.isRunning = this.deviceService.STATUS_ON;
    d.deviceValue = (device.deviceValue! - 1) < 16 ? 16 : (device.deviceValue! - 1);
    console.log('-' + d.deviceValue);
    this.deviceService.updateDevicebyStatus(d).subscribe( (data : Device) => {
      device = data;
      console.log(data.deviceValue);
      
    });
    this.fetchUserData();
  }


  houseChange(house : House){
    console.log(house.houseActive ? 'on' : 'off');
    const n = house.houseActive ? 1 : 0;
    this.deviceService.setAllDeviceInHouse(house.houseID!, n).subscribe( data => {
      console.log(data);
      this.fetchUserData();
    })
  }

  floorChange(floor : Floor){
    console.log(floor.floorActive ? 'on' : 'off');
    const n = floor.floorActive ? 1 : 0;
    this.deviceService.setAllDeviceInFloor(floor.floorID!, n).subscribe( data => {
      console.log(data);
      this.fetchUserData();
    })
  }

  roomChange(room : Room){
    console.log(room.roomActive ? 'on' : 'off');
    const n = room.roomActive ? 1 : 0;
    this.deviceService.setAllDeviceInRoom(room.roomID!, n).subscribe( data => {
      console.log(data);
      this.fetchUserData();
    })
  }
}
