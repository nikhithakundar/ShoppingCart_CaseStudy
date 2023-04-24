import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from 'src/app/models/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent {
  products:Product = new Product();

  constructor(private productService:ProductService,private router:Router){}
  onSubmit(){
      console.log(this.products);
      this.saveProduct();
      alert('Product added successfully !');
  }
  saveProduct(){
    this.productService.createProduct(this.products)
    .subscribe(data=>{
      console.log(data);
      this.gotToProductList();
        })
  }
  gotToProductList(){
    this.router.navigate(['/product-list']);
  }

}



