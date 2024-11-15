package com.main.nimap.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.main.nimap.entity.Product;
import com.main.nimap.repository.ProductRepository;
import com.main.nimap.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product getProductById(int id) {
		return productRepository.findById(id).orElse(null);
	}

	@Override
	public Product updateProductById(int id, Product product) {

		@SuppressWarnings("deprecation")
		Product products = productRepository.getById(id);
		products.setDescription(product.getDescription());
		products.setName(product.getName());
		products.setCategory(product.getCategory());
		return productRepository.save(products);
	}

	public void deleteproduct(int id) {
		Product pro = productRepository.getById(id);
		productRepository.delete(pro);
	}

	@Override
	public Page<Product> getAllProducts(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return productRepository.findAll(pageable);
	}

}
