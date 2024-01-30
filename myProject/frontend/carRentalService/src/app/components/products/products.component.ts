import { Component } from '@angular/core';
import { CarService } from '../../services/car.service';
import { Router } from '@angular/router';
import { Car } from '../../common/car';
import { CartItem } from '../../common/cart-item';
import { CartService } from '../../services/cart.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrl: './products.component.css'
})
export class ProductsComponent {
  cars: Car [];

  constructor(private service: CarService,private router: Router,private cartService: CartService){}

  getProducts(){
    this.service.getProducts().subscribe((data) => {
      this.cars = data;
    })
  }

  ngOnInit(){
    this.getProducts();
  }

  addToCart(theCar: Car) {
    alert("added to cart")
    const theCartItem = new CartItem(theCar);
    this.cartService.addToCart(theCartItem);
  }

  

}
