import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  public registerUser(user: User): Observable<User> {
    let urlEndpoint: string = "http://localhost:8080/api/auth/register";
    return this.http.post<User>(urlEndpoint, user);
  }

  public loginUser(user: User): Observable<User> {
    let urlEndpoint: string = "http://localhost:8080/api/auth/login";
    return this.http.post<User>(urlEndpoint, user);
  }
}
