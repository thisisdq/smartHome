import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TestwsComponent } from './testws.component';

describe('TestwsComponent', () => {
  let component: TestwsComponent;
  let fixture: ComponentFixture<TestwsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TestwsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TestwsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
