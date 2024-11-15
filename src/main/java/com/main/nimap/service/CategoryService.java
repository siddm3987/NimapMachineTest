package com.main.nimap.service;

import org.springframework.data.domain.Page;


import com.main.nimap.entity.Category;

public interface CategoryService  {
	
	public Category addCategory(Category category);
	

	public Category getCategoryById(int id) ;

	public String deleteCategoryByid(int id) ;

	public Category updateCategoryById(int id, Category catgory);
	
	public Page<Category> getCategorys(int page, int size) ;

}
