package com.edubridge.app1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edubridge.app1.dao.AdminDao;

import com.edubridge.app1.model.Admin;
import com.edubridge.app1.model.User;

@Service
public class AdminService {
	
	@Autowired
	private AdminDao dao;

	public Admin saveAdmin(Admin e) {
		return dao.saveAdmin(e);
	}
	
	public Admin sginin(String email, String password) throws Exception { 
	 
			Admin admin = dao.getAdmin(email);
			System.out.println(admin.getPassword()); 
			if(admin.getEmail().equals(email) && admin.getPassword().equals(password)) { 
				return admin ;
				} else { 
					throw new Exception("Invalid Credentials"); 
					} 
			}

}
