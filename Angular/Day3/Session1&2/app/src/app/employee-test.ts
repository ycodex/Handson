import { Employee } from './employee';
import { Department } from './department';
import { Skill } from './skill';

export class EmployeeTest {
  employee: Employee;
  constructor(emp: Employee) {
    this.employee = emp;
  }
  display() {
    return 'Hello' + this.employee;
  }
}

const dept: Department = {
  id: 1,
  name: 'Computer',
};

const skill: Skill[] = [
  { id: 1, name: 'coding' },
  { id: 2, name: 'drawing' },
];

const employee: Employee = {
  id: 1,
  name: 'Test',
  salary: 1000,
  permanent: true,
  dateOfBirth: new Date('12/31/2000'),
  department: dept,
  skill: skill,
};

const emp = new EmployeeTest(employee);
