import { Component, OnInit } from '@angular/core';
import { CartService } from '../services/cart.service';
import { HomeService } from './homeservice/home.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  
    public productList:any;
    searchKey:string="";

    constructor(private homeservice:HomeService,private cartservice:CartService){}   
    
    ngOnInit(): void {
      this.homeservice.getprod()
      .subscribe(res=>{
        this.productList=res;
  
        //to show quantity and price 
        this.productList.forEach((a:any)=>{
          Object.assign(a,{quantity:1,total:a.price})        

        });
      });

       //Serching
       this.cartservice.search.subscribe((val:any)=>{
        this.searchKey=val;
        
      })

    }
  
    addtocart(item:any){
      this.cartservice.addtoCart(item);
    }

}















//to show the no.when cart is added
          // this.cartservice.getprdt()
          // .subscribe(res=>{
          //   this.totalItem=res.length;
          // })






  // content: string;

  // constructor(private userService: UserService) { }

  // ngOnInit(): void {
  //   this.userService.getPublicContent().subscribe(
  //      data => {
  //       this.content = data;
  //     },
  //     err=>{
  //       this.content=JSON.parse(err.error).message;
  //     }
  //     );
  // }

   //public totalItem:number=0;

  

