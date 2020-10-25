package com.gymondo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gymondo.api.service.IPurchaseService;

@RestController
public class PurchaseController {
	
	@Autowired
	public IPurchaseService purchaseService;
	
	@RequestMapping(value = "/purchase/{userId}/{productId}", method = RequestMethod.POST)
	public ResponseEntity<String> findAllProducts(@PathVariable Long userId, @PathVariable Long productId){
		return new ResponseEntity<String>(purchaseService.buyPlan(userId, productId), HttpStatus.OK);
	}

}
