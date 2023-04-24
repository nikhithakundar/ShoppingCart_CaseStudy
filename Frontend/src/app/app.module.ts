import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { httpInterceptorProviders } from './_helpers/http.interceptor';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { ProfileComponent } from './profile/profile.component';
import { HomeComponent } from './home/home.component';
import { BoardAdminComponent } from './board-admin/board-admin/board-admin.component';
import { BoardUserComponent } from './board-user/board-user/board-user.component';
import { ProductListComponent } from './product/product-list/product-list.component';
import { ProductCreateComponent } from './product/product-create/product-create.component';
import { ProductUpdateComponent } from './product/product-update/product-update.component';
import { CartComponent } from './cart/cart/cart.component';
import { PaymentComponent } from './payment/payment.component';
import { FilterPipe } from './shared/filter.pipe';
import { AboutComponent } from './about/about.component';
import { TermsandconditionComponent } from './termsandcondition/termsandcondition.component';



@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
    ProfileComponent,
    HomeComponent,
    BoardAdminComponent,
    BoardUserComponent,
    ProductListComponent,
    ProductCreateComponent,
    ProductUpdateComponent,
    CartComponent,
    PaymentComponent,
    FilterPipe,
    AboutComponent,
    TermsandconditionComponent
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  
  ],
  providers: [httpInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
