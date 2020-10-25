package com.gymondo.api.service;

import java.util.List;

import com.gymondo.api.model.Product;

public interface IProductService {

	List<Product> findAllProducts();
	Product       findProductById(Long id);

}
