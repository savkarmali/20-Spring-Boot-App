package com.example.SpringBootRestAPI.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringBootRestAPI.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findOne(String id);

	
}
