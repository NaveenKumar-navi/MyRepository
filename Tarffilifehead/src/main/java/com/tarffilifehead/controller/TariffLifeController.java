package com.tarffilifehead.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tarffilifehead.exception.ErrorMessage;
import com.tarffilifehead.exception.RecordNotfoundException;
import com.tarffilifehead.exception.ResponseHandler;
import com.tarffilifehead.model.TariffLife;
import com.tarffilifehead.service.TariffLifeService;

@RestController
@RequestMapping("/api")
public class TariffLifeController {

	    @Autowired
	    private TariffLifeService service;

	    @PostMapping("/Product")
	    public ResponseEntity<Object> Post(@RequestBody TariffLife product){
	        try{
	        	TariffLife result = service.saveTariffLife(product);
	           return ResponseHandler.generateResponse("Successfully added data!",HttpStatus.OK,result);
	        }catch (Exception e){
	          return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
	        }
	    }

	    @GetMapping("/Products")
	    public ResponseEntity<Object> Get(){
	            List<TariffLife> result = (List<TariffLife>) service.getTariffLife();
	          //  return new APIResponse<List<Lob>>(result.size(),result);
	        try {
	            if(result==null){
	           throw new RecordNotfoundException("Record_Not_Found");
	            }
	         return  ResponseHandler.generateResponse("Successfully retrieved Data!",HttpStatus.OK,result);
	       }catch(Exception e){

	            return  ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
	        }

	    }

	    @GetMapping("/Product/{psaf_sys_id}")
	    public ResponseEntity<Object> Get(@PathVariable String mtmMapCode) {
	    	try{
	    		TariffLife result =  this.service.getTariffLifeByMtmMapCode(mtmMapCode);
	    		
	    		if(result==null){
	    			throw new RecordNotfoundException("Record_Not_Found");
	    		}
	    		return ResponseHandler.generateResponse("Successfully retrieved data!",HttpStatus.OK,result);
	    	}catch(RecordNotfoundException e){
	    		return ErrorMessage.ErrorResponse(e.getMessage(),HttpStatus.BAD_REQUEST);
	    	}

	    }

	    @PutMapping("/Product/{psaf_sys_id")
	    public ResponseEntity<Object> Update( @RequestBody TariffLife product){
	        try{
	        	TariffLife result = service.saveTariffLife(product);
	            if(result==null){
	                throw new RecordNotfoundException("Record_Not_Found");
	            }
	            return ResponseHandler.generateResponse("updated",HttpStatus.OK,result);
	        }catch (Exception e){
	            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS,null);
	        }
	    }

	    @DeleteMapping("/Product/{psaf_sys_id}")
	    public ResponseEntity<Object> Delete(@PathVariable String mtmMapCode){
	        try{
	            String result = service.deleteTariffLife(mtmMapCode);
	            if(result==null){
	                throw new RecordNotfoundException("Record_Not_Found");
	           }
	           return ResponseHandler.generateResponse("Deleted!", HttpStatus.OK, result);
	        }catch (Exception e){
	            return  ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);

	        }
	    }


	}

