import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { Department } from '../department';
import { Skill } from '../skill';
import { EmployeeService } from '../employee.service';
@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css'],
})
export class EmployeeListComponent implements OnInit {
  searchItem: string;

  constructor(private empService: EmployeeService) {}
  dept: Department = {
    id: 1,
    name: 'Computer',
  };

  skill: Skill[] = [
    { id: 1, name: 'coding' },
    { id: 2, name: 'drawing' },
  ];

  // employees: Employee[] = [
  //   {
  //     id: 1,
  //     name: 'Test',
  //     salary: 1000,
  //     permanent: true,
  //     dateOfBirth: new Date('12/31/2000'),
  //     department: this.dept,
  //     skill: this.skill,
  //   },
  //   {
  //     id: 2,
  //     name: 'Test2',
  //     salary: 2000,
  //     permanent: true,
  //     dateOfBirth: new Date('12/31/2000'),
  //     department: this.dept,
  //     skill: this.skill,
  //   },
  // ];
  employees: Employee[] = this.empService.getAllEmployees();
  filteredEmployees: Employee[] = this.employees;
  search() {
    this.filteredEmployees = this.employees.filter((s) =>
      s.name.includes(this.searchItem)
    );
  }

  ngOnInit(): void {}
}
