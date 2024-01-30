import { Component, OnInit } from '@angular/core';
import { Car } from '../../common/car';
import { CarService } from '../../services/car.service';
import { ActivatedRoute } from '@angular/router';
import { CartService } from '../../services/cart.service';
import { CartItem } from '../../common/cart-item';

@Component({
  selector: 'app-car-details',
  templateUrl: './car-details.component.html',
  styleUrls: ['./car-details.component.css']
})
export class CarDetailsComponent {

  car: Car = new Car();

  constructor(
    private service: CarService,
    private route: ActivatedRoute,
    private cartService: CartService
  ) {}

  ngOnInit() {
    this.route.paramMap.subscribe(() => {
      this.listCars();
    });
  }

  listCars() {
    const theCarId: number | string | null = this.route.snapshot.paramMap.get("CarId");
    this.service.getCar(theCarId).subscribe(
      (data) => {
        this.car = data;
       
       } );
  }

  // Add to cart
  addToCart(theCar: Car) {
    alert("added to cart")
    const theCartItem = new CartItem(theCar);
    this.cartService.addToCart(theCartItem);
  }
}
