import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const AUTH_API='http://localhost:4926/api/auth/';

const httpOptions={
  headers:new HttpHeaders({'content_Type':'application/json'})
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http:HttpClient){}

  login(credentials):Observable<any>{
  return this.http.post(AUTH_API+'signin',{
      username:credentials.username,
      password:credentials.password 
    },httpOptions);    
  }

  registerUser(user):Observable<any>{
    // console.log(user);
    return this.http.post(AUTH_API+'signup',{
      username:user.username,
      email:user.email,
      roles: user.roles,
      password:user.password
    },httpOptions);
  }
}













  // constructor(private httpClient: HttpClient) { }
  // registerUser(user: { 
  //   username: any, 
  //   email: any, 
  //   roles: any[], 
  //   password: any 
  // }): Observable<any> {
  //   console.log(user);
  //   return this.httpClient.post<any>('http://localhost:4926/api/auth/signup',
  //     {
  //       username: user.username,
  //       email: user.email,
  //       roles: user.roles,
  //       password: user.password
  //     });
  // }
  // login(login: {
  //    username: any, 
  //    password: any }): Observable<any> {
  //   return this.httpClient.post('http://localhost:4926/api/auth/signin', login);
  // }




  // logout(): Observable<any> {
  //   return this.http.post(AUTH_API + 'signout', { }, httpOptions);
  // }
