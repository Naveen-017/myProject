package com.edubridge.app1.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	

	import com.edubridge.app1.dao.CarCategoryDao;
	import com.edubridge.app1.model.CarCategory;

	@Service
	public class CarCategoryService {

	    @Autowired
	    private CarCategoryDao dao;

	  
	    public CarCategory saveCarCategory(CarCategory e) {
	        return dao.saveCarCategory(e);
	    }

	   
	    public List<CarCategory> getCarCategories() {
	        return dao.getCarCategories();
	    }

	    public CarCategory getCarCategory(Long CategoryId) {
			return dao.getCarCategory(CategoryId);
	    }
	  
	   
	    public void updateCarCategory(CarCategory e) {
	        dao.updateCarCategory(e);
	    }

	   
	    public void deleteCarCategory(Long CategoryId) {
	        dao.deleteCarCategory(CategoryId);
	    }
	}



