package com.gymondo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gymondo.api.model.Product;
import com.gymondo.api.service.IProductService;

@RestController
public class ProductController {
	
	@Autowired
	public IProductService productService;
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> findAllProducts(){
 		return new ResponseEntity<List<Product>>(productService.findAllProducts(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public ResponseEntity<Product> findProductById(@PathVariable Long id){
		return new ResponseEntity<Product>(productService.findProductById(id), HttpStatus.OK);
	}

}
