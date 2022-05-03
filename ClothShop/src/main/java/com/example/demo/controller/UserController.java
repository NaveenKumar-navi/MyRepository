package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.User;
import com.example.demo.exception.ClothNotfoundException;
import com.example.demo.response.ResponseHandler;
import com.example.demo.service.UserService;


@RestController
public class UserController {

	@Autowired
	private UserService Service;
	
	 @PostMapping("/user")
	    public ResponseEntity<Object> Post(@Valid @RequestBody User user){
	        try{
	           User result = Service.saveUser(user);
	           return ResponseHandler.generateResponse("Successfully added data!",HttpStatus.OK,result);
	        }catch (Exception e){
	          return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
	        }
	    }

	    @GetMapping("/Users")
	    public ResponseEntity<Object> Get(){
	            List<User> result = (List<User>) Service.getUsers();
	          //  return new APIResponse<List<Lob>>(result.size(),result);
	        try {
	            if(result==null){
	           throw new ClothNotfoundException("Record_Not_Found");
	            }
	         return  ResponseHandler.generateResponse("Successfully retrieved Data!",HttpStatus.OK,result);
	       }catch(Exception e){

	            return  ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
	        }

	    }
	    	
		    @GetMapping("/User/{user_id}")
		    public ResponseEntity<Object> Get(@PathVariable int user_id) {
		    	try{
		    		List<User>
		    		result =  this.Service.findByUserId(user_id);
		    		
		    		if(result==null){
		    			throw new ClothNotfoundException("Record_Not_Found");
		    		}
		    		return ResponseHandler.generateResponse("Successfully retrieved data!",HttpStatus.OK,result);
		    	}catch(ClothNotfoundException e){
		    		return  ResponseHandler.generateResponse(e.getMessage(),HttpStatus.BAD_REQUEST,null);
		    	}

	    }
}
