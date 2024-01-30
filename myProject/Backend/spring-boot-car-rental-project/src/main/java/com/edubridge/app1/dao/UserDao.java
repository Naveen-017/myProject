package com.edubridge.app1.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.edubridge.app1.model.User;
import com.edubridge.app1.repo.UserRepository;

@Repository
public class UserDao {
	
	
		@Autowired
		private UserRepository repo;

		public User saveUser(User e) {
			return repo.save(e);
		}

		public List<User> getUsers() {
			return repo.findAll();
		}

		public User getUser(Integer UserId) {
			return repo.findById(UserId).get();
		}

		public void updateUser(User e) {
			repo.save(e);
		}

		public void deleteUser(Integer UserId) {
			repo.deleteById(UserId);
		}
		
		public User findByEmail(String email) {
			return repo.findByEmail(email);
		}
		
		public User getUser(String email) {
			return repo.findByEmail(email);
		}

}
