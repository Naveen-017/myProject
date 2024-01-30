package com.edubridge.app1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edubridge.app1.model.Admin;
import com.edubridge.app1.model.User;
import com.edubridge.app1.service.AdminService;




@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200/")

public class AdminController {
	

	@Autowired
	private AdminService service;
	
	/*
	 * http://localhost:8181/myapp/api/Admin
	 */
	// save user
	@PostMapping("/admin")
	public ResponseEntity<Admin> save(@RequestBody Admin admin) {
		Admin savedAdmin = service.saveAdmin(admin);
		return new ResponseEntity<>(savedAdmin, HttpStatus.OK);
	}
	
	/*
	 * http://localhost:8181/myapp/api/admin
	 */
	
	@PostMapping("admin/valid")
	public Admin login(@RequestBody Admin admin)throws Exception{
		return this.service.sginin(admin.getEmail(),admin.getPassword());
	}


}
