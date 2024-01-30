import { Component, OnInit } from '@angular/core';
import { Car } from '../../common/car';
import { CarService } from '../../services/car.service';
import { ActivatedRoute } from '@angular/router';
import { CartService } from '../../services/cart.service';
import { CartItem } from '../../common/cart-item';

@Component({
  selector: 'app-car-list',
  templateUrl: './car-list.component.html',
  styleUrls: ['./car-list.component.css']
})
export class CarListComponent implements OnInit {

  cars: Car[] = [];
  currentCategoryId: number | null | string = null;  
  searchMode: boolean = false;
  keyword: string | null = null;

  constructor(
    private carService: CarService,
    private route: ActivatedRoute,
    private cartService: CartService
  ) {}

  ngOnInit() {
    this.route.paramMap.subscribe(() => {
      this.listCars();
    });
  }

  listCars() {
    this.searchMode = this.route.snapshot.paramMap.has('keyword');

    if (this.searchMode) {
      this.handleSearchCars();
      
    } else {
      this.handleListCars();
    }
  }

  handleSearchCars() {
    this.keyword = this.route.snapshot.paramMap.get('keyword');
    this.carService.searchCars(this.keyword).subscribe((data) => {
        this.cars = data;
     
      }
    );
  }

  handleListCars() {
    this.currentCategoryId = this.route.snapshot.paramMap.get('categoryId');

    
    if (this.currentCategoryId ) {
      this.carService.getCarList(this.currentCategoryId).subscribe(
        (data) => {
          this.cars = data;
    

       
        }
      );
      
    }
  }

  addToCart(theCar: Car) {
    alert("added to cart")
    const theCartItem = new CartItem(theCar);
    alert(JSON.stringify(theCartItem))
    this.cartService.addToCart(theCartItem);
   // console.log("addToCart of carlist");
  }
}
