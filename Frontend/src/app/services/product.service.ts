import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../models/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  baseURL='http://localhost:2222/product';

  constructor(private httpClient:HttpClient) { }

   //getting all product details
  getAllProducts():Observable<Product[]>{
    return this.httpClient.get<Product[]>(`${this.baseURL}/products`);
  }

  //Adding Products
  createProduct(product:Product):Observable<Object>{
    return this.httpClient.post(`${this.baseURL}/add`,product);
}

//update-by id
getProductById(id:number):Observable<Product>{
  return this.httpClient.get<Product>(`${this.baseURL}/findById/${id}`);
}

updateProduct(id:number,product:Product):Observable<Object>{
  return this.httpClient.put(`${this.baseURL}/update/${id}`,product);
}

deleteProduct(id:number):Observable<Object>{
  return this.httpClient.delete(`${this.baseURL}/delete/${id}`);
}

}
