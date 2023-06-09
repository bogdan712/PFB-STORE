import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private readonly baseUrl = 'http://localhost:8080';  
  constructor(private httpClient: HttpClient) { }

  public register(user: any): Observable<any> {
    return this.httpClient.post<any>(`${this.baseUrl}/register`, user);
  }

  public login(credentials: any): Observable<any> {
    return this.httpClient.post<any>(`${this.baseUrl}/login`, credentials);
  }

  public isAuthenticated(): boolean {
    return !!localStorage.getItem('currentUser');
  }

  public logout(): void {
    localStorage.removeItem('currentUser');
  }
}
