package com.gymondo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymondo.api.model.Product;
import com.gymondo.api.repository.ProductRepository;

@Service
public class ProductServiceImpl implements IProductService{
	
	@Autowired
	public ProductRepository productRepository;

	@Override
	public List<Product> findAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product findProductById(Long id) {
		return productRepository.findById(id);
	}

}
