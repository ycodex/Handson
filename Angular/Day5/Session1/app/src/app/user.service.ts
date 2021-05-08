import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './user';
import { catchError } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { HandleError, HttpErrorHandler } from './http-error-handling.service';
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    Authorization: 'my-auth-token',
  }),
};

@Injectable({
  providedIn: 'root',
})
export class UserService {
  private handleError: HandleError;
  constructor(private http: HttpClient, httpErrorHandler: HttpErrorHandler) {
    this.handleError = httpErrorHandler.createHandleError('UseresService');
  }

  url = 'https://jsonplaceholder.typicode.com/users';

  getAllUsers(): Observable<User[]> {
    return this.http
      .get<User[]>(this.url)
      .pipe(catchError(this.handleError('getUsers', [])));
  }

  createUser(user: User): Observable<User> {
    return this.http
      .post<User>(this.url, user, httpOptions)
      .pipe(catchError(this.handleError('addUser', user)));
  }

  updateUser(user: User): Observable<User> {
    return this.http
      .put<User>(this.url, user, httpOptions)
      .pipe(catchError(this.handleError('updatePost', user)));
  }

  deleteUser(id: number): Observable<{}> {
    const url = `${this.url}/${id}`;
    return this.http
      .delete(url, httpOptions)
      .pipe(catchError(this.handleError('deleteUser')));
  }
}
