package com.example.demo.service;

import java.util.List;

import com.example.demo.bean.User;


public interface UserService {

	User saveUser(User user);

	List<User> getUsers();

	List<User> findByUserId(int user_id);

}
