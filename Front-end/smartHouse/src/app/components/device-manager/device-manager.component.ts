import { Component, OnDestroy, OnInit } from '@angular/core';
import { Device, Floor, House, Room, UserAccount } from '../../module';
import { DeviceService } from '../../device.service';
import { UserService } from '../../user.service';
import { AuthenticationService } from '../../authentication.service';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HouseFloorRoomDeviceService } from '../../house-floor-room-device.service';
@Component({
  selector: 'app-device-manager',
  standalone: true,
  imports: [CommonModule, FormsModule,ReactiveFormsModule],
  templateUrl: './device-manager.component.html',
  styleUrl: './device-manager.component.scss'
})
export class DeviceManagerComponent implements OnInit, OnDestroy {
  constructor(private deviceService: DeviceService,private HFRDService : HouseFloorRoomDeviceService, private userService: UserService,private fb: FormBuilder) {
   }
  public userAccount: UserAccount = {};
  public houses : any;

  ngOnInit(): void {
    const session = JSON.parse(localStorage.getItem('session') || 'null') || {}
    if (session.username) {
      this.userService.fetchData(session.username).subscribe((data: UserAccount) => {
        if(data) {
          this.userAccount = data;
          this.HFRDService.getHouseByUserID(this.userAccount.userAccountID!).subscribe(
           res => {
            this.houses = res;
           }
          )
        }
      })
    }
  }
  ngOnDestroy(): void {

  }


  onHouseChange(house : House){
    
  }

  onFloorChange(house : House){
  }

}
