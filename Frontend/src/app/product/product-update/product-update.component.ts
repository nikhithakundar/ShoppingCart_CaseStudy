import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from 'src/app/models/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-update',
  templateUrl: './product-update.component.html',
  styleUrls: ['./product-update.component.css']
})
export class ProductUpdateComponent implements OnInit {

  constructor(private productService:ProductService,private route:ActivatedRoute,
    private router:Router){}

  products:Product=new Product();
  productId:number;

  ngOnInit(): void {
    this.productId=this.route.snapshot.params['productId'];
  
    this.productService.getProductById(this.productId)
    .subscribe(data=>{
      this.products=data;
      console.log(this.products)
    })
  }
  
  onSubmit(){
    this.productService.updateProduct(this.productId,this.products)
    .subscribe(data=>{
      console.log(data);
      alert('Product Updated Successfully !')
      this.goToProductList();
    })
  }
  goToProductList(){
    this.router.navigate(['/product-list'])
  }
}
