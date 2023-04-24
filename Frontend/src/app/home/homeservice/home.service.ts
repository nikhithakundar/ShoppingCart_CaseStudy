import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HomeService {

  constructor(private httpClient:HttpClient) { }

  getprod(){
    return this.httpClient.get<any>("http://localhost:2222/product/products")
    .pipe(map((res:any)=>{
        return res;
    }))
  }
}
