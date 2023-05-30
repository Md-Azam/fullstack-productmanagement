package com.product.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.product.entity.Category;
import com.product.product.service.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin("http://localhost:3000")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping
	public Category saveCategory(@RequestBody Category category) {
		return categoryService.addCategory(category);
		
	}
	
	@GetMapping("/{cId}")
	public Category   fetchCategoryById(@PathVariable Integer cId) {
		return categoryService.getCategoryById(cId);
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getAllCategories() {
		return ResponseEntity.ok(this.categoryService.getCategories());
	}

}
