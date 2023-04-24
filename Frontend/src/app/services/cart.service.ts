import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  public cartItemList:any=[];
  public productList=new BehaviorSubject<any>([]) ;

  public search=new BehaviorSubject<string>("") ;

  constructor(private httpClient:HttpClient) { }

  baseURL:"http://localhost:3333/cart";

  getCartDetails():Observable<any>{
      return this.httpClient.get<any>(`http://localhost:3333/cart/getallcarts`);
     }


  getprdt(){
    return this.productList.asObservable();
  }
  setprdt(product:any){
    this.cartItemList.push(...product)
    this.productList.next(product);
  }
  addtoCart(product:any){
    this.cartItemList.push(product);
    this.productList.next(this.cartItemList);
    this.getTotalPrice();

    console.log(this.cartItemList);
  } 
  getTotalPrice():number{
    let grandTotal=0;
    this.cartItemList.map((a:any)=>{
        grandTotal+=a.total;
    })
    return grandTotal;
  }

  removeCartItem(product:any){
    this.cartItemList.map((a:any,index:any)=>{
      if(product.productId===a.productId){
        this.cartItemList.splice(index,1);
      }
    })
    //afetr removing particular product from cart ..no must decrease at carticon
    this.productList.next(this.cartItemList); 
  }

  removeAllCart(){
    this.cartItemList=[];
    this.productList.next(this.cartItemList);
  }


 
}
