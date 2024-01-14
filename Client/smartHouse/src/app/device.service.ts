import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Device } from './module';

@Injectable({
  providedIn: 'root'
})
export class DeviceService {

  constructor(private http : HttpClient) { }
  baseUrl = 'http://localhost:8888/';

  updateDevice(device :Device) {
    return this.http.post(this.baseUrl +'updateDevice', device).subscribe((device : Device) => device);
  }
}
