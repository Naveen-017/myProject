package com.edubridge.app1.repo;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.edubridge.app1.model.Car;
import com.edubridge.app1.model.CarCategory;


@Repository

public interface CarRepository extends JpaRepository<Car, Integer> {
	List<Car> findByCarCategory(CarCategory category) ;
	List<Car> findBymodelContaining(String model);

}
