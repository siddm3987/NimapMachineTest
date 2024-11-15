package com.main.nimap.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.main.nimap.entity.Category;
import com.main.nimap.repository.CategoryRepository;
import com.main.nimap.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	// create category method

	@Override
	public Category addCategory(Category category) {
		System.out.println("Hello Siddesh i am in catgory service layer");
		return categoryRepository.save(category);
	}

	@Override
	public Category getCategoryById(int id) {
		return categoryRepository.findById(id).orElse(null);
	}

	@Override
	public String deleteCategoryByid(int id) {
		categoryRepository.deleteById(id);
		return "category deleted";
	}

	@Override
	public Category updateCategoryById(int id, Category catgory) {
		@SuppressWarnings("deprecation")
		Category categorys = categoryRepository.getById(id);
		categorys.setCategory_name(catgory.getCategory_name());
		return categoryRepository.save(categorys);
	}

	@Override
	public Page<Category> getCategorys(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return categoryRepository.findAll(pageable);
	}
}
