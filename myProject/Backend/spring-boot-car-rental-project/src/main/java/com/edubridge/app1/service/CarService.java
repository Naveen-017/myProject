package com.edubridge.app1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import com.edubridge.app1.dao.CarDao;

import com.edubridge.app1.model.Car;
import com.edubridge.app1.model.CarCategory;

@Service

public class CarService {
	
	@Autowired
	private CarDao dao;

	public Car saveCar(Car e) {
		return dao.saveCar(e);
	}

	public List<Car> getCars() {
		return dao.getCars();
	}

	public Car getCar(Integer CarId) {
		return dao.getCar(CarId);
	}

	public void updateCar(Car e) {
		dao.updateCar(e);

	}

	public void deleteCar(Integer CarId) {
		dao.deleteCar(CarId);
	}
	public List<Car> getCarByCarCatgory(CarCategory category){
		return dao.getCarByCarCatgory(category);
		
	}
	
	public List<Car> getCars(String model){
		return dao.getCars(model) ;
	}
}


