package com.edubridge.app1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edubridge.app1.dao.UserDao;
import com.edubridge.app1.model.User;
import com.edubridge.app1.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserDao dao;
	
	
	public User saveUser(User e) {
		return dao.saveUser(e);
	}

	public List<User> getUsers() {
		return dao.getUsers();
	}

	public User getUser(Integer UserId) {
		return dao.getUser(UserId);
	}

	public void updateUser(User e) {
		dao.updateUser(e);

	}

	public void deleteUser(Integer UserId) {
		dao.deleteUser(UserId);
	}
	public User sginin(String email, String password) throws Exception { 
//	 
		User user = dao.getUser(email);
		System.out.println(user.getPassword()); 
		if(user.getEmail().equals(email) && user.getPassword().equals(password)) { 
			return user; 
			} else { 
				throw new Exception("Invalid Credentials"); 
				} 
		}

	}


