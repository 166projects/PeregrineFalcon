import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewseatsComponent } from './viewseats.component';

describe('ViewseatsComponent', () => {
  let component: ViewseatsComponent;
  let fixture: ComponentFixture<ViewseatsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewseatsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewseatsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
