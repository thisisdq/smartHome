import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeviceLightComponent } from './device-light.component';

describe('DeviceLightComponent', () => {
  let component: DeviceLightComponent;
  let fixture: ComponentFixture<DeviceLightComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DeviceLightComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DeviceLightComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
