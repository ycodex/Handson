import { Component, OnInit } from '@angular/core';
import { EmployeeTest } from '../employee-test';
import { Employee } from '../employee';
import { Department } from '../department';
import { Skill } from '../skill';
@Component({
  selector: 'app-view-emp',
  templateUrl: './view-emp.component.html',
  styleUrls: ['./view-emp.component.css'],
})
export class ViewEmpComponent implements OnInit {
  constructor() {}
  dept: Department = {
    id: 1,
    name: 'Computer',
  };

  skill: Skill[] = [
    { id: 1, name: 'coding' },
    { id: 2, name: 'drawing' },
  ];

  employee: Employee = {
    id: 1,
    name: 'Test',
    salary: 1000,
    permanent: true,
    dateOfBirth: new Date('12/31/2000'),
    department: this.dept,
    skill: this.skill,
  };

  empTest = new EmployeeTest(this.employee);

  ngOnInit(): void {}
}
