import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SmartHouseControllPageComponent } from './smart-house-controll-page.component';

describe('SmartHouseControllPageComponent', () => {
  let component: SmartHouseControllPageComponent;
  let fixture: ComponentFixture<SmartHouseControllPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SmartHouseControllPageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SmartHouseControllPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
