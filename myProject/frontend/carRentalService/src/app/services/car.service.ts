import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Car } from '../common/car';
import { CarCategory } from '../common/car-category';
//import { CartItem } from '../common/cart-item';

@Injectable({
  providedIn: 'root'
})
export class CarService {
  baseUrl = 'http://localhost:8181/myapp/api/car';
  categoryUrl = 'http://localhost:8181/myapp/api/carCategory';

  constructor(private http: HttpClient) { }


  getCarList(theCarId: number | null | string): Observable<Car[]> {
    const categoryUrl = `${this.baseUrl}/carsByCarCategory/${theCarId}`;
    return this.http.get<Car[]>(categoryUrl);
  }

  getCarCategories(): Observable<CarCategory[]> {
    return this.http.get<CarCategory[]>(this.categoryUrl);
  }

  searchCars(theKeyword: string | null): Observable<Car[]> {
    const searchUrl = `${this.baseUrl}/search/${theKeyword}`;
    return this.http.get<Car[]>(searchUrl);
  }

  getCar(theCarId: number | string | null): Observable<Car> {
    const carUrl = `${this.baseUrl}/${theCarId}`;
    return this.http.get<Car>(carUrl);
  }

  getProducts():Observable<Car[]> {
    return this.http.get<Car[]>(this.baseUrl);
  }

  createCar(data: Car): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}`,data);
  }

  updateCar(carId: number, updatedCarData: any): Observable<any> {
    const url = `${this.baseUrl}/${carId}`;
    return this.http.put(url, updatedCarData);
  }

  deleteCar(carId: number): Observable<any> {
    const url = `${this.baseUrl}/${carId}`;
    return this.http.delete(url);
  }
}
