import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  constructor(private authService: AuthService) {}

  ngOnInit(): void {}

  username: string;
  password: string;
  login() {
    console.log(this.username);
    console.log(this.password);
    if (this.username == 'admin' && this.password == 'password') {
      console.log('yes');
      this.authService.login();
    }
  }
}
