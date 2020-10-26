package com.gymondo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gymondo.api.model.UserSubscription;
import com.gymondo.api.service.IUserService;

@RestController
public class UserController {
	
	@Autowired
	public IUserService userService;

	@RequestMapping(value = "/userInformations/{userId}", method = RequestMethod.GET)
	public ResponseEntity<UserSubscription> findUserInformations(@PathVariable Long userId){
 		return new ResponseEntity<UserSubscription>(userService.findUserInformations(userId), HttpStatus.OK);
	}

}
