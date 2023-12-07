import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SmartHosueHomePageComponent } from './smart-hosue-home-page.component';

describe('SmartHosueHomePageComponent', () => {
  let component: SmartHosueHomePageComponent;
  let fixture: ComponentFixture<SmartHosueHomePageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SmartHosueHomePageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SmartHosueHomePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
