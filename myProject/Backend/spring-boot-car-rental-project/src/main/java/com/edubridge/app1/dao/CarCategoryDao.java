package com.edubridge.app1.dao;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edubridge.app1.model.CarCategory;
import com.edubridge.app1.repo.CarCategoryRepository;

@Repository
public class CarCategoryDao {
    
    @Autowired
    private CarCategoryRepository repo;

    public CarCategory saveCarCategory(CarCategory e) {
        return repo.save(e);
    }

    public List<CarCategory> getCarCategories() {
        return repo.findAll();
    }
    public CarCategory getCarCategory(Long CategoryId) {
		return repo.findById(CategoryId).get();
    }
    public void updateCarCategory(CarCategory e) {
        repo.save(e);
    }

    public void deleteCarCategory(Long carCategoryId) {
        repo.deleteById(carCategoryId);
    }
    
    
}
