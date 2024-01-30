package com.edubridge.app1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edubridge.app1.model.Car;
import com.edubridge.app1.model.CarCategory;
import com.edubridge.app1.service.CarCategoryService;
import com.edubridge.app1.service.CarService;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api")

public class CarController {

	@Autowired
	private CarService service;
	@Autowired
	private CarCategoryService carCategoryService;

	/*
	 * http://localhost:8181/myapp/api/car
	 */
	// save car
	@PostMapping("/car")
	public ResponseEntity<Car> save(@RequestBody Car car) {
		Car savedCar = service.saveCar(car);
		return new ResponseEntity<>(savedCar, HttpStatus.OK);
	}

	/*
	 * http://localhost:8181/myapp/api/car
	 */

	// < get all cars
	@GetMapping("/car")
	public ResponseEntity<List<Car>> getAllCars() {
		List<Car> cars = service.getCars();
		return new ResponseEntity<>(cars, HttpStatus.OK);
	}

	/*
	 * http://localhost:8181/myapp/api/car/1
	 */

	// get one car
	@GetMapping("/car/{id}")
	public ResponseEntity<Car> getOneCar(@PathVariable("id") Integer CarId) {
		Car car = service.getCar(CarId);
		return new ResponseEntity<Car>(car, HttpStatus.OK);
	}

	// delete one car
	@DeleteMapping("/car/{id}")
	public ResponseEntity<Car> deleteCar(@PathVariable("id") Integer CarId) {
		service.deleteCar(CarId);
		return new ResponseEntity<Car>(HttpStatus.OK);
	}

	/*
	 * http://localhost:8181/myapp/api/car/1
	 */
	@PutMapping("/car")
	public ResponseEntity<Car> update(@RequestBody Car car) {
		service.updateCar(car);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@GetMapping("/car/carsByCarCategory/{CategoryId}")
	public ResponseEntity<List<Car>> getCarsByCarCategory(@PathVariable Long CategoryId) {
	CarCategory carCategory = carCategoryService.getCarCategory(CategoryId);
	List<Car> cars = service.getCarByCarCatgory(carCategory);
	return new ResponseEntity<>(cars,HttpStatus.OK);
	}
	
	
	@GetMapping("/car/search/{model}")
	public ResponseEntity<List<Car>> getmodelcar(@PathVariable String model){
		List<Car> cars = service.getCars(model);
		return new ResponseEntity<>(cars,HttpStatus.OK);
	}
	
}
