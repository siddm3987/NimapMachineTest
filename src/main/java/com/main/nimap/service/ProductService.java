package com.main.nimap.service;

import org.springframework.data.domain.Page;

import com.main.nimap.entity.Product;

public interface ProductService {

	public Product addProduct(Product product);
	
	public Product getProductById(int id);
	
	public Product updateProductById(int id, Product product) ;
	
	public void deleteproduct(int id);
	
	public Page<Product> getAllProducts(int page, int size);
	
}
