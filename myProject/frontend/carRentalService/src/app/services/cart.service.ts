import { Injectable } from '@angular/core';
import { CartItem } from '../common/cart-item';
import { BehaviorSubject, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  cartItems: CartItem[] = [];

  totalQuantity: Subject<number> = new BehaviorSubject<number>(0);
  totalPrice:Subject<number> = new BehaviorSubject<number>(0);

//storage: Storage = sessionStorage

storage: Storage = localStorage

  constructor() {
  let data = JSON.parse( this.storage.getItem('cartItems'))
  if(data != null){
    this.cartItems = data;
    this.computeCartTotal();
  }

  }

   persistCartItems(){
    this.storage.setItem('cartItems',JSON.stringify(this.cartItems));
   }

  //addToCart

  addToCart(theCartItem: CartItem) {
    console.log("addToCart of cartservice");
  
    let existingCartItem = this.cartItems.find(
      (tempCartItem) => tempCartItem.model === theCartItem.model
    );
  
    if (existingCartItem != undefined) {
      // Item already exists in the cart, increment quantity
      existingCartItem.quantity++;
    } else {
      // Item doesn't exist in the cart, add it
      this.cartItems.push(theCartItem);
    }
  
    this.computeCartTotal();
  
  
  }
    computeCartTotal(){
      let totalPriceValue = 0;
      let toatalQuantityValue = 0;

      for(let currentCartItem of this.cartItems){
        totalPriceValue += currentCartItem.quantity * currentCartItem.price_per_day;
      toatalQuantityValue += currentCartItem.quantity;
      }
      this.totalPrice.next(totalPriceValue);
      this.totalQuantity.next(toatalQuantityValue);

      this.persistCartItems();
    }
    
    remove(theCartItem: CartItem){
    let itemIndex =  this.cartItems.findIndex((CartItem) => 
        CartItem.id === theCartItem.id
      );


if(itemIndex > -1){
  this.cartItems.splice(itemIndex,1)
  this.computeCartTotal();

}
  }

  decrementQuantity(theCartItem: CartItem){
    theCartItem.quantity--;
    if(theCartItem.quantity == 0){
      this.remove(theCartItem);
    }else{
      this.computeCartTotal();
    }
  }

}