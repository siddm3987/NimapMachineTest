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

import com.main.nimap.entity.Category;
import com.main.nimap.serviceImpl.CategoryServiceImpl;

@RestController
public class CategoryController {

	@Autowired
	private CategoryServiceImpl categoryService;

	// GET all the categories : http://localhost:8080/api/categories?page=3

	@GetMapping("/categories")
	public ResponseEntity<Page<Category>> getPaginatedProducts(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "3") int size) {
		return ResponseEntity.ok(categoryService.getCategorys(page, size));
	}

	// POST - create a new category : http://localhost:8080/api/categories

	@PostMapping("/categories")
	public Category addCategory(@RequestBody Category category) {
		return categoryService.addCategory(category);
	}

	// GET category by Id : http://localhost:8080/api/categories/{di}

	@GetMapping("/categories/{di}")
	public Category getCategoryById(@PathVariable int di) {
		return categoryService.getCategoryById(di);
	}

	// PUT - update category by id : http://localhost:8080/api/categories/{di}

	@PutMapping("/categories/{di}")
	public Category updateCategory(@PathVariable int di, @RequestBody Category catgory) {
		System.err.println("Catgory Updated");
		return categoryService.updateCategoryById(di, catgory);
	}

	// DELETE - Delete category by id : http://localhost:8080/api/categories/{di}

	@DeleteMapping("/categories/{di}")
	public String deleteCategoryByid(@PathVariable int di) {
		categoryService.deleteCategoryByid(di);
		return "category deleted";
	}

}
