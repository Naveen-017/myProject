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

import com.edubridge.app1.model.User;
import com.edubridge.app1.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200/")

public class UserController {

	@Autowired
	private UserService service;

	/*
	 * http://localhost:8181/myapp/api/User
	 */
	// save user
	@PostMapping("/user")
	public ResponseEntity<User> save(@RequestBody User user) {
		User savedUser = service.saveUser(user);
		return new ResponseEntity<>(savedUser, HttpStatus.OK);
	}

	/*
	 * http://localhost:8181/myapp/api/user
	 */

	// < get all users
	@GetMapping("/user")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = service.getUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	/*
	 * http://localhost:8181/myapp/api/user/1
	 */

	// get one user
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getOneUser(@PathVariable("id") Integer UserId) {
		User user = service.getUser(UserId);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	// delete one user
	@DeleteMapping("/user/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable("id") Integer UserId) {
		service.deleteUser(UserId);
		return new ResponseEntity<User>(HttpStatus.OK);
	}

	/*
	 * http://localhost:8181/myapp/api/user/1
	 */
	@PutMapping("/user")
	public ResponseEntity<User> update(@RequestBody User user) {
		service.updateUser(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@PostMapping("user/valid")
	public User login(@RequestBody User user)throws Exception{
		return this.service.sginin(user.getEmail(),user.getPassword());
	}

}
