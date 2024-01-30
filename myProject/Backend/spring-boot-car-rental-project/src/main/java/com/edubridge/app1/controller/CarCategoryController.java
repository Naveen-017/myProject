package com.edubridge.app1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
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

import com.edubridge.app1.model.CarCategory;
import com.edubridge.app1.service.CarCategoryService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CarCategoryController {

	@Autowired
	private CarCategoryService service;

	/*
	 * http://localhost:8181/myapp/api/carCategory
	 */
	// save carCategory
	@PostMapping("/carCategory")
	public ResponseEntity<CarCategory> save(@RequestBody CarCategory carCategory) {
		CarCategory savedCarCategory = service.saveCarCategory(carCategory);
		return new ResponseEntity<>(savedCarCategory, HttpStatus.OK);
	}

	/*
	 * http://localhost:8181/myapp/api/carCategory
	 */

	// < get all carCategories
	@GetMapping("/carCategory")
	public ResponseEntity<List<CarCategory>> getAllCarCategories() {
		List<CarCategory> carCategories = service.getCarCategories();
		return new ResponseEntity<>(carCategories, HttpStatus.OK);
	}

	/*
	 * http://localhost:8181/myapp/api/carCategory/1
	 */

	// get one carCategory
	@GetMapping("/carCategory/{id}")
	public ResponseEntity<CarCategory> getOneCarCategory(@PathVariable("id") Long categoryId) {
		CarCategory carCategory  = service.getCarCategory(categoryId);
		return new ResponseEntity<CarCategory>(carCategory, HttpStatus.OK);
		
		 
	}		   
	

	// delete one carCategory
	@DeleteMapping("/carCategory/{id}")
	public ResponseEntity<CarCategory> deleteCarCategory(@PathVariable("id") Long categoryId) {
		service.deleteCarCategory(categoryId);
		return new ResponseEntity<CarCategory>(HttpStatus.OK);
	}

	/*
	 * http://localhost:8181/myapp/api/carCategory/1
	 */
	@PutMapping("/carCategory")
	public ResponseEntity<CarCategory> update(@RequestBody CarCategory carCategory) {
		service.updateCarCategory(carCategory);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
