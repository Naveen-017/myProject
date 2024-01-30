import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CarListComponent } from './components/car-list/car-list.component';
import { CarCategoryMenuComponent } from './components/car-category-menu/car-category-menu.component';
import { CarDetailsComponent } from './components/car-details/car-details.component';
import { SearchComponent } from './components/search/search.component';
import { CartDetailsComponent } from './components/cart-details/cart-details.component';
import { CartStatusComponent } from './components/cart-status/cart-status.component';
import { CheckoutComponent } from './components/checkout/checkout.component';
import { ProductsComponent } from './components/products/products.component';
import { HomepageComponent } from './components/homepage/homepage.component';
import { SigninComponent } from './components/signin/signin.component';
import { SignupComponent } from './components/signup/signup.component';
import { UserpageComponent } from './components/userpage/userpage.component';
import { UserprofileComponent } from './components/userprofile/userprofile.component';
import { AdminhomeComponent } from './components/adminhome/adminhome.component';
import { AdminpageComponent } from './components/adminpage/adminpage.component';
import { FaqComponent } from './components/faq/faq.component';
import { AboutusComponent } from './components/aboutus/aboutus.component';
import { ContactusComponent } from './components/contactus/contactus.component';


@NgModule({
  declarations: [
    AppComponent,
    CarListComponent,
    CarCategoryMenuComponent,
    CarDetailsComponent,
    SearchComponent,
    CartDetailsComponent,
    CartStatusComponent,
    CheckoutComponent,
    ProductsComponent,
    HomepageComponent,
    SigninComponent,
    SignupComponent,
    UserpageComponent,
    UserprofileComponent,
    AdminhomeComponent,
    AdminpageComponent,
    FaqComponent,
    AboutusComponent,
    ContactusComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
