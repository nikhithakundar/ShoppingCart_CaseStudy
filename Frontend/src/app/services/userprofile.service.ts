import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Userprofile } from '../models/userprofile';

@Injectable({
  providedIn: 'root'
})
export class UserprofileService {

  constructor(private httpClient:HttpClient) { }
  baseURL="http://localhost:1111/profile";

  getUserDetails():Observable<Userprofile[]>{
    return this.httpClient.get<Userprofile[]>(`${this.baseURL}/users`);
  }
}
