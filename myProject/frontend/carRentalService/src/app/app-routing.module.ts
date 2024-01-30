import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CarListComponent } from './components/car-list/car-list.component';
import { CarDetailsComponent } from './components/car-details/car-details.component';
import { CheckoutComponent } from './components/checkout/checkout.component';
import { CartDetailsComponent } from './components/cart-details/cart-details.component';
import { ProductsComponent } from './components/products/products.component';
import { HomepageComponent } from './components/homepage/homepage.component';
import { SigninComponent } from './components/signin/signin.component';
import { SignupComponent } from './components/signup/signup.component';
import { UserpageComponent } from './components/userpage/userpage.component';
import { UserprofileComponent } from './components/userprofile/userprofile.component';
import { CarCategoryMenuComponent } from './components/car-category-menu/car-category-menu.component';
import { AdminhomeComponent } from './components/adminhome/adminhome.component';
import { AdminpageComponent } from './components/adminpage/adminpage.component';
import { FaqComponent } from './components/faq/faq.component';
import { AboutusComponent } from './components/aboutus/aboutus.component';
import { ContactusComponent } from './components/contactus/contactus.component';


const routes: Routes = [
  {path:'checkout',component:CheckoutComponent},
  {path:'cart-details',component:CartDetailsComponent},
{path :'cars',component:CarListComponent},
{path: 'category',component:CarListComponent},
{path: 'cars/:id', component: CarDetailsComponent},
{path: 'category/:categoryId',component:CarListComponent},
{path: 'products', component:ProductsComponent},
{path: 'homepage',component:HomepageComponent},
{path: 'signin',component:SigninComponent},
{path: 'signup',component:SignupComponent},
{path: 'userpage',component:UserpageComponent},
{path: 'userprofile',component: UserprofileComponent},
{path: 'adminhome',component: AdminhomeComponent},
{path: 'adminpage',component: AdminpageComponent},
{path: 'faq',component: FaqComponent},
{path: 'aboutus',component: AboutusComponent},
{path: 'contactus',component: ContactusComponent},
{path: 'userprofile',component: UserprofileComponent},

{path: 'search/:keyword', component: CarListComponent},
{path: 'car-category-menu', component:CarCategoryMenuComponent},





{path: '',redirectTo: '/homepage', pathMatch: 'full'}

];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

