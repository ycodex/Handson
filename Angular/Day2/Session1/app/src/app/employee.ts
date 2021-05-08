import { Department } from './department';
import { Skill } from './skill';
export interface Employee {
  id: number;
  name: string;
  salary: number;
  permanent: boolean;
  dateOfBirth: Date;
  department: Department;
  skill: Skill[];
}
