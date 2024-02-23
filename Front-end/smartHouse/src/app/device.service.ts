import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Device, House } from './module';

@Injectable({
  providedIn: 'root'
})
export class DeviceService {
  STATUS_ON = 1;
  STATUS_OFF = 0;

  constructor(private http : HttpClient) { }
  baseUrl = 'http://localhost:8888/';

  updateDevicebyStatus(devicei :Device) {
    return this.http.post(this.baseUrl +'updateDevice', devicei);
  }

  setAllDeviceInHouse(id : number, value : number){
    return this.http.post<House>(this.baseUrl+ 'devices/setAllInHouse',{id : id, value : value})
  }

  setAllDeviceInFloor(id : number, value : number){
    return this.http.post<House>(this.baseUrl+ 'devices/setAllInFloor',{id : id, value : value})
  }

  setAllDeviceInRoom(id : number, value : number){
    return this.http.post<House>(this.baseUrl+ 'devices/setAllInRoom',{id : id, value : value})
  }

}
