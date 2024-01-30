package com.edubridge.app1.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.edubridge.app1.model.Car;
import com.edubridge.app1.model.CarCategory;
import com.edubridge.app1.repo.CarRepository;

@Repository
//@EnableJpaRepositories
public class CarDao {

	@Autowired
	private CarRepository repo;

	public Car saveCar(Car e) {
		return repo.save(e);
	}

	public List<Car> getCars() {
		return repo.findAll();
	}

	public Car getCar(Integer CarId) {
		return repo.findById(CarId).get();
	}

	public void updateCar(Car e) {
		repo.save(e);
	}

	public void deleteCar(Integer CarId) {
		repo.deleteById(CarId);
	}
	
	public List<Car> getCarByCarCatgory(CarCategory category){
		return repo.findByCarCategory(category);
		
	}
	
	public List<Car> getCars(String model){
		return repo.findBymodelContaining(model);
	}

}
