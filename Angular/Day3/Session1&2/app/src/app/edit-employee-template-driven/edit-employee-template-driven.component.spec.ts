import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditEmployeeTemplateDrivenComponent } from './edit-employee-template-driven.component';

describe('EditEmployeeTemplateDrivenComponent', () => {
  let component: EditEmployeeTemplateDrivenComponent;
  let fixture: ComponentFixture<EditEmployeeTemplateDrivenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditEmployeeTemplateDrivenComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditEmployeeTemplateDrivenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
