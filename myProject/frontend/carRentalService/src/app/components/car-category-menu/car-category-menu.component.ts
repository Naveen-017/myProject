import { Component } from '@angular/core';
import { CarService } from '../../services/car.service';
import { CarCategory } from '../../common/car-category';

@Component({
  selector: 'app-car-category-menu',
  templateUrl: './car-category-menu.component.html',
  styleUrl: './car-category-menu.component.css'
})
export class CarCategoryMenuComponent {


carCategories: CarCategory[];


constructor(private carService: CarService){}



ngOnInit() {
  this.listCarCategories();

}
listCarCategories(){

  this.carService.getCarCategories().subscribe((data) => {
    this.carCategories = data;

    
  })
}
}


