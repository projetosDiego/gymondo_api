package com.gymondo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gymondo.api.model.UserApi;
import com.gymondo.api.service.IUserService;

@RestController
public class UserController {
	
	@Autowired
	public IUserService userService;
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<UserApi>> findAllUsers(){
 		return new ResponseEntity<List<UserApi>>(userService.findAllUsers(), HttpStatus.OK);
	}

}
