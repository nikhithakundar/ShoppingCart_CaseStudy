import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { BoardAdminComponent } from './board-admin/board-admin/board-admin.component';
import { BoardUserComponent } from './board-user/board-user/board-user.component';
import { CartComponent } from './cart/cart/cart.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { PaymentComponent } from './payment/payment.component';
import { ProductCreateComponent } from './product/product-create/product-create.component';
import { ProductListComponent } from './product/product-list/product-list.component';
import { ProductUpdateComponent } from './product/product-update/product-update.component';
import { ProfileComponent } from './profile/profile.component';
import { RegisterComponent } from './register/register.component';
import { TermsandconditionComponent } from './termsandcondition/termsandcondition.component';

const routes: Routes = [ 
{ path: 'home', component: HomeComponent },
{ path: 'login', component: LoginComponent },
{ path: 'register', component: RegisterComponent },
{ path: 'profile', component: ProfileComponent },
{ path: 'user', component: BoardUserComponent },
{ path: 'admin', component: BoardAdminComponent },
{ path: '', redirectTo: 'home', pathMatch: 'full' },
{path:'product-list',component:ProductListComponent},
{path:'product-list/product-create',component:ProductCreateComponent},
{path:'product-list/product-update/:productId',component:ProductUpdateComponent},
{path:'cart',component:CartComponent},
{path:'payment',component:PaymentComponent},
{path:'about',component:AboutComponent},
{path:'term',component:TermsandconditionComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
