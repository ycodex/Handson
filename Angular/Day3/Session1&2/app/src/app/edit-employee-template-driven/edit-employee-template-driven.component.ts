import { Component, OnInit } from '@angular/core';
import { EmployeeTest } from '../employee-test';
import { Employee } from '../employee';
import { Department } from '../department';
import { Skill } from '../skill';
@Component({
  selector: 'app-edit-employee-template-driven',
  templateUrl: './edit-employee-template-driven.component.html',
  styleUrls: ['./edit-employee-template-driven.component.css'],
})
export class EditEmployeeTemplateDrivenComponent implements OnInit {
  dept: Department = {
    id: 1,
    name: 'Computer',
  };
  departments: Department[] = [
    { id: 1, name: 'Payroll' },

    { id: 2, name: 'Internal' },

    { id: 3, name: 'HR' },
  ];

  skill: Skill[] = [
    { id: 1, name: 'coding' },
    { id: 2, name: 'drawing' },
  ];

  employee: Employee = {
    id: 1,
    name: '',
    salary: 1000,
    permanent: true,
    dateOfBirth: new Date('12/31/2000'),
    department: this.dept,
    skill: this.skill,
  };

  constructor() {}

  ngOnInit(): void {}

  onSubmit() {
    console.log(this.employee);
  }
}
