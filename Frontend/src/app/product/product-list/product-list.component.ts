import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from 'src/app/models/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit{
  products:Product[]=[];

  constructor(private productService:ProductService,private router:Router){}
  
  ngOnInit(): void {
   this.getProducts();
  }

  getProducts(){
    this.productService.getAllProducts().subscribe(data=>{
      this.products=data;
      console.log(data);
    })
  }

  updateProduct(productId:number){
    this.router.navigate(['product-list/product-update/',productId])
  }
  deleteProduct(productId:number){
     this.productService.deleteProduct(productId)
    .subscribe(data=>{
      this.getProducts();
      alert('Product deleted Sucessfully')
    })
  }

  
}
