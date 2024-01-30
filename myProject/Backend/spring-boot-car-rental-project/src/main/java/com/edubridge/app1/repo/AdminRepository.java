package com.edubridge.app1.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edubridge.app1.model.Admin;


public interface AdminRepository  extends JpaRepository<Admin, Integer>{
	Admin findByEmail(String email);

}
