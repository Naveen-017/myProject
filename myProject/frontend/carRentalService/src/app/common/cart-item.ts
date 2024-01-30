import { Car } from "./car"

export class CartItem {
  id: String
  model: string
  imageUrl: string
  price_per_day: number
  avilablestatus: String
  
  quantity: number
  

  constructor(car: Car) {
    this.id = car.model;
    this.model = car.model;
    this.imageUrl = car.imageUrl;
    this.price_per_day = car.price_per_day
    this.avilablestatus = car.availablestatus;
    
    this.quantity = 1;
  }
}