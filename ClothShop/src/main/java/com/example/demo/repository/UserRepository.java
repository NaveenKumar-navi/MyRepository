package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.bean.User;


public interface UserRepository extends JpaRepository<User,Integer>{

	List<User> findById(int user_id);

}
