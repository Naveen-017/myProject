package com.edubridge.app1.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edubridge.app1.model.Admin;
import com.edubridge.app1.model.User;
import com.edubridge.app1.repo.AdminRepository;
@Repository


public class AdminDao {
	
	
	@Autowired
	private AdminRepository repo;
	
	
	public Admin saveAdmin(Admin e) {
		return repo.save(e);
	}

	public Admin findByEmail(String email) {
		return repo.findByEmail(email);
	}
	
	public Admin getAdmin(String email) {
		return repo.findByEmail(email);
	}

}
