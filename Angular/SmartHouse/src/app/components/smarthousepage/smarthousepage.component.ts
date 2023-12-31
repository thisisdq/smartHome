import { Component, OnInit,OnDestroy } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AuthService } from '../../auth.service';
import { Router } from '@angular/router';
import { UserAccount, DEVICE_TYPE } from '../../entity';
@Component({
  selector: 'app-smarthousepage',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './smarthousepage.component.html',
  styleUrl: './smarthousepage.component.scss'
})
export class SmarthousepageComponent implements OnInit, OnDestroy{

  constructor(
    private authService: AuthService,
    private router: Router,
  ) {
    
  }

  timeInterval: any;
  time: any;

  ngOnInit (){
    // this.timeInterval = setInterval( ()=> {console.log('timeInterval');
    // },1000);
  }

  ngOnDestroy () {
    // if(this.timeInterval){
      // clearInterval(this.timeInterval);
    // }
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
