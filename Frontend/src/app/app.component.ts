import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartService } from './services/cart.service';
import { StorageService } from './_services/storage.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  // title = 'Shopping-Cart';
  public totalItem:number=0;
  public searchTerm:string='';

  private roles: string[] ;
  isLoggedIn = false;
  showAdminBoard = false;
  username: string;

  constructor(private storageService: StorageService,private cartservice:CartService,
    private router:Router) { }

  ngOnInit(): void {
    this.cartservice.getprdt()
    .subscribe(res=>{
      this.totalItem=res.length;
    })

    this.isLoggedIn = !!this.storageService.getToken();
    this.showAdminBoard = !!this.storageService.getToken();

    if (this.isLoggedIn) {
      const user = this.storageService.getUser();
      this.roles = user.roles;

      this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
      
      this.username = user.username;
    }
    if(this.showAdminBoard){
      this.router.navigate(['/product-list'])
    }
    if(!this.showAdminBoard){
      this.router.navigate(['/home'])
    }
  }


   //product searching
   search(event:any){
    this.searchTerm=(event.target as HTMLInputElement).value;
    console.log(this.searchTerm);
    this.cartservice.search.next(this.searchTerm);
  }
 

  logout():void{
    this.storageService.signOut();
    window.location.reload();
  }
}
