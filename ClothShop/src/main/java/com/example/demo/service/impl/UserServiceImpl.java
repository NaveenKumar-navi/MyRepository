package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repo;
	
	@Override
	public User saveUser(User user) {
		
		return repo.save(user);
	}

	@Override
	public List<User> getUsers() {
		
		return repo.findAll();
	}

	@Override
	public List<User> findByUserId(int user_id) {
		
		return repo.findById(user_id);
	}

}
