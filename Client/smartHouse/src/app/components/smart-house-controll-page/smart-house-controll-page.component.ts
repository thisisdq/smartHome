import { Component } from "@angular/core";
import { AuthenticationService } from "../../authentication.service";
import { Router } from "@angular/router";
import { DEVICE_TYPE, Device, Floor, House, Room, UserAccount } from "../../module";
import { CommonModule } from "@angular/common";
import { CalendarComponent } from "../calendar/calendar.component";

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
    private router: Router
  ) {}

  public time = Date.now();
  public timeInterval: any;

  ngOnInit() {
    this.fetchUserData();
    this.time = Date.now();
    this.timeInterval = setInterval(() => {
      this.time = Date.now();
    }, 1000);
  }

  ngOnDestroy() {
    if (this.timeInterval) {
      clearInterval(this.timeInterval);
    }
  }

  public acc: UserAccount = {};
  public houses? : House[];
  public floors? : Floor[];
  public rooms?: Room[];
  public devices?: Device[];

  fetchUserData() {
    this.acc = JSON.parse(localStorage.getItem('session') || '') || {
      userAccountID: 2,
      username: "danhquy2502",
      password: undefined,
      fullname: "Danh Quý",
      houses: [
          {
              houseID: 1,
              address: "1 Dai Co Viet",
              userID: 2,
              floors: [
                  {
                      floorID: 1,
                      floorName: "Tầng 1 - Quán CAFE",
                      houseID: 1,
                      rooms: [
                          {
                              roomID: 1,
                              roomName: "Quầy pha Cafe",
                              floorID: 1,
                              devices: [
                                  {
                                      id: 1,
                                      deviceName: "Máy pha cafe",
                                      deviceStatus: "Đang tắt",
                                      deviceType: undefined,
                                      deviceValue: 0,
                                      isRunning: 0,
                                      roomID: 1,
                                      devicePort: undefined
                                  },
                                  {
                                      id: 2,
                                      deviceName: "Máy đun nước",
                                      deviceStatus: "Đang tắt",
                                      deviceType: undefined,
                                      deviceValue: 0,
                                      isRunning: 0,
                                      roomID: 1,
                                      devicePort: undefined
                                  },
                                  {
                                      id: 3,
                                      deviceName: "Đèn quầy",
                                      deviceStatus: "Đang tắt",
                                      deviceType: undefined,
                                      deviceValue: 0,
                                      isRunning: 0,
                                      roomID: 1,
                                      devicePort: undefined
                                  },
                                  {
                                      id: 12,
                                      deviceName: "Nhiệt độ tại quầy",
                                      deviceStatus: "đang tắt",
                                      deviceType: undefined,
                                      deviceValue: 0,
                                      isRunning: 0,
                                      roomID: 1,
                                      devicePort: undefined
                                  },
                                  {
                                      id: 13,
                                      deviceName: "Độ ẩm tại quầy",
                                      deviceStatus: "đang tắt",
                                      deviceType: undefined,
                                      deviceValue: 0,
                                      isRunning: 0,
                                      roomID: 1,
                                      devicePort: undefined
                                  }
                              ]
                          },
                          {
                              roomID: 2,
                              roomName: "Phòng 101",
                              floorID: 1,
                              devices: [
                                  {
                                      id: 4,
                                      deviceName: "Đèn Phòng 101",
                                      deviceStatus: "Đang bật",
                                      deviceType: undefined,
                                      deviceValue: 1,
                                      isRunning: 1,
                                      roomID: 2,
                                      devicePort: undefined
                                  },
                                  {
                                      id: 14,
                                      deviceName: "Điều hoà P101",
                                      deviceStatus: "Đang tắt",
                                      deviceType: undefined,
                                      deviceValue: 0,
                                      isRunning: 0,
                                      roomID: 2,
                                      devicePort: undefined
                                  }
                              ]
                          },
                          {
                              roomID: 3,
                              roomName: "Phòng 102",
                              floorID: 1,
                              devices: [
                                  {
                                      id: 5,
                                      deviceName: "Đèn Phòng 102",
                                      deviceStatus: "Đang bật",
                                      deviceType: undefined,
                                      deviceValue: 1,
                                      isRunning: 1,
                                      roomID: 3,
                                      devicePort: undefined
                                  },
                                  {
                                      id: 15,
                                      deviceName: "Điều hoà P102",
                                      deviceStatus: "Đang tắt",
                                      deviceType: undefined,
                                      deviceValue: 0,
                                      isRunning: 0,
                                      roomID: 3,
                                      devicePort: undefined
                                  },
                                  {
                                      id: 16,
                                      deviceName: "Điều hoà P103",
                                      deviceStatus: "Đang tắt",
                                      deviceType: undefined,
                                      deviceValue: 0,
                                      isRunning: 0,
                                      roomID: 3,
                                      devicePort: undefined
                                  }
                              ]
                          },
                          {
                              roomID: 4,
                              roomName: "Phòng 103",
                              floorID: 1,
                              devices: [
                                  {
                                      id: 6,
                                      deviceName: "Đèn Phòng 103",
                                      deviceStatus: "Đang bật",
                                      deviceType: undefined,
                                      deviceValue: 1,
                                      isRunning: 1,
                                      roomID: 4,
                                      devicePort: undefined
                                  }
                              ]
                          }
                      ]
                  },
                  {
                      floorID: 2,
                      floorName: "Tầng 2 - Nhà ở",
                      houseID: 1,
                      rooms: [
                          {
                              roomID: 5,
                              roomName: "Phòng ngủ 1",
                              floorID: 2,
                              devices: [
                                  {
                                      id: 7,
                                      deviceName: "Đèn ngủ",
                                      deviceStatus: "Đang tắt",
                                      deviceType: undefined,
                                      deviceValue: 0,
                                      isRunning: 0,
                                      roomID: 5,
                                      devicePort: undefined
                                  }
                              ]
                          },
                          {
                              roomID: 6,
                              roomName: "Phòng ngủ 2",
                              floorID: 2,
                              devices: [
                                  {
                                      id: 8,
                                      deviceName: "Đèn ngủ",
                                      deviceStatus: "Đang tắt",
                                      deviceType: undefined,
                                      deviceValue: 0,
                                      isRunning: 0,
                                      roomID: 6,
                                      devicePort: undefined
                                  }
                              ]
                          },
                          {
                              roomID: 7,
                              roomName: "Phòng khách",
                              floorID: 2,
                              devices: [
                                  {
                                      id: 9,
                                      deviceName: "TV",
                                      deviceStatus: "Đang tắt",
                                      deviceType: undefined,
                                      deviceValue: 0,
                                      isRunning: 0,
                                      roomID: 7,
                                      devicePort: undefined
                                  },
                                  {
                                      id: 10,
                                      deviceName: "Điều hoà",
                                      deviceStatus: "Đang tắt",
                                      deviceType: undefined,
                                      deviceValue: 0,
                                      isRunning: 0,
                                      roomID: 7,
                                      devicePort: undefined
                                  }
                              ]
                          },
                          {
                              roomID: 8,
                              roomName: "Ban công",
                              floorID: 2,
                              devices: [
                                  {
                                      id: 11,
                                      deviceName: "Đèn ban công",
                                      deviceStatus: "Đang tắt",
                                      deviceType: undefined,
                                      deviceValue: 0,
                                      isRunning: 0,
                                      roomID: 8,
                                      devicePort: undefined
                                  }
                              ]
                          }
                      ]
                  }
              ]
          }
      ]
  }
  }
  test() {
    console.log(new Date());
  }

  logout() {
    this.authService.logout();
    this.router.navigateByUrl("/");
  }
}
