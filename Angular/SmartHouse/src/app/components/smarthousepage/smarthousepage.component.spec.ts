import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SmarthousepageComponent } from './smarthousepage.component';

describe('SmarthousepageComponent', () => {
  let component: SmarthousepageComponent;
  let fixture: ComponentFixture<SmarthousepageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SmarthousepageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SmarthousepageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
