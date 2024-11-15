package com.main.nimap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.main.nimap.entity.Product;
import com.main.nimap.serviceImpl.ProductServiceImpl;

@RestController
public class ProductController {

	@Autowired
	private ProductServiceImpl productService;

	// GET all the products : http://localhost:8080/api/products?page=2

	@GetMapping("/products")
	public ResponseEntity<Page<Product>> getProducts(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "2") int size) {
		return ResponseEntity.ok(productService.getAllProducts(page, size));
	}

	// POST - create a new product : http://localhost:8080/api/products

	@PostMapping("/products")
	public Product addCategory(@RequestBody Product product) {
		return productService.addProduct(product);

	}

	// GET product by Id : http://localhost:8080/api/products/{di}

	@GetMapping("/products/{di}")
	public Product getProductById(@PathVariable int di) {
		return productService.getProductById(di);
	}

	// PUT - update product by id : http://localhost:8080/api/products/{di}

	@PutMapping("/products/{di}")
	public Product updateProduct(@PathVariable int di, @RequestBody Product product) {
		return productService.updateProductById(di, product);
	}

	// DELETE - Delete product by id : http://localhost:8080/api/products/{di}

	@DeleteMapping("/products/{di}")
	public String deleteProductByid(@PathVariable int di) {
		productService.deleteproduct(di);
		return "Product deleted";
	}
}
