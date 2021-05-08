import { Injectable } from '@angular/core';
import { Employee } from './employee';
import { Department } from './department';
import { Skill } from './skill';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root',
})
export class EmployeeService {
  constructor() {}

  dept: Department = {
    id: 1,
    name: 'Computer',
  };

  skill: Skill[] = [
    { id: 1, name: 'coding' },
    { id: 2, name: 'drawing' },
  ];

  employeeList: Employee[] = [
    {
      id: 1,
      name: 'Test',
      salary: 1000,
      permanent: true,
      dateOfBirth: new Date('12/31/2000'),
      department: this.dept,
      skill: this.skill,
    },
    {
      id: 2,
      name: 'Test2',
      salary: 2000,
      permanent: true,
      dateOfBirth: new Date('12/31/2000'),
      department: this.dept,
      skill: this.skill,
    },
  ];
  getAllEmployees(): Employee[] {
    return this.employeeList;
  }
  getEmployee(employeeId: number): Employee {
    for (let emp of this.employeeList) {
      if (emp.id == employeeId) {
        return emp;
      }
    }
  }
}
