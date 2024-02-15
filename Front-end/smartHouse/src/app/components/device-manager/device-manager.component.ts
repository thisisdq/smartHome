import { Component, OnDestroy , OnInit } from '@angular/core';
import { UserAccount } from '../../module';
import { DeviceService } from '../../device.service';
import { UserService } from '../../user.service';
import { AuthenticationService } from '../../authentication.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-device-manager',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './device-manager.component.html',
  styleUrl: './device-manager.component.scss'
})
export class DeviceManagerComponent implements OnInit, OnDestroy{

  
  constructor(private deviceService: DeviceService, private userService: UserService, private authService: AuthenticationService){}
  public userAccount : UserAccount = {};
  ngOnInit(): void {
    const session =  JSON.parse(localStorage.getItem('session') || 'null') || {}
    
    if(session.username){
      this.userService.fetchData(session.username).subscribe( (data : any) => {
        this.userAccount = data;
      })
    }
  }
  ngOnDestroy(): void {
      
  }
  



}
