package com.product.product.service;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.product.entity.Category;
import com.product.product.exception.ResourceNotFound;
import com.product.product.repository.CategoryRepo;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;

	public Category addCategory(Category category) {
		return categoryRepo.save(category);
	}
	
	public Category getCategoryById(Integer cId) {
		Category cat = categoryRepo.findById(cId).orElseThrow(()-> new ResourceNotFound("id not found"));
		return cat ;
	}
	
	public Set<Category> getCategories(){
		return new LinkedHashSet<>(this.categoryRepo.findAll());
	}
}
