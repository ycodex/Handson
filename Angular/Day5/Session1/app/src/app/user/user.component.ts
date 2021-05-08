import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css'],
})
export class UserComponent implements OnInit {
  constructor(private userService: UserService) {}

  ngOnInit(): void {
    this.getAllUser();
    console.log(this.getAllUser());
    console.log(this.users);
  }

  users: User[];

  getAllUser() {
    this.userService.getAllUsers().subscribe((user) => (this.users = user));
  }

  delete(user: User): void {
    this.users = this.users.filter((h) => h !== user);
    this.userService.deleteUser(user.id).subscribe();
    /*
    // oops ... subscribe() is missing so nothing happens
    this.postService.deletePost(post.id);
    */
  }
}
