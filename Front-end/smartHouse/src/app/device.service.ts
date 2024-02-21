import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Device } from './module';

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
}
