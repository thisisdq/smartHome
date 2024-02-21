import { TestBed } from '@angular/core/testing';

import { HouseFloorRoomDeviceService } from './house-floor-room-device.service';

describe('HouseFloorRoomDeviceService', () => {
  let service: HouseFloorRoomDeviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HouseFloorRoomDeviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
