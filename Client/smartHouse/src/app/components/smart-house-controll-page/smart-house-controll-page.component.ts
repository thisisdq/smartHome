import { Component } from '@angular/core';
import { AuthenticationService } from '../../authentication.service';
import { Router } from '@angular/router';
import { DEVICE_TYPE, UserAccount } from '../../module';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-smart-house-controll-page',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './smart-house-controll-page.component.html',
  styleUrl: './smart-house-controll-page.component.scss'
})
export class SmartHouseControllPageComponent {
  constructor(
    private authService: AuthenticationService,
    private router: Router,
  ) {

  }

  public time = Date.now();
  public timeInterval :any;

  ngOnInit() {
    this.time = Date.now();
    this.timeInterval = setInterval(() =>{
      this.time = Date.now();
    },1000)
  }

  ngOnDestroy() {
    if(this.timeInterval){
      clearInterval(this.timeInterval);
    }
  }

  public acc: UserAccount = {
    fullname: 'DanhQuy',
    username: 'admin',
    password: 'password',
    house: [{
      houseID: 1,
      address: '1 Dai Co Viet',
      floors: [
        {
          floorID: 1,
          floorName: 'Tầng 1',
          rooms: [{
            roomID: 1,
            roomName: 'Living Room',
            devices: [
              {
                deviceID: 1,
                deviceName: 'TV',
                deviceType: DEVICE_TYPE.TV,
                deviceStatus: 'OFF',
                deviceValue: undefined,
                isRuning: false,
              },
              {
                deviceID: 2,
                deviceName: 'Light Tile',
                deviceType: DEVICE_TYPE.LED,
                deviceStatus: 'ON',
                deviceValue: undefined,
                isRuning: true
              },
            ]
          }]
        }
      ]
    }]
  }

  test() {
    console.log(new Date());
  }

  logout() {
    this.authService.logout();
    this.router.navigateByUrl('/')
  }
}
