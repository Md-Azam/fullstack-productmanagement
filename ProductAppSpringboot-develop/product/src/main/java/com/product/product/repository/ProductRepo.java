package com.product.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.product.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
	
	public List<Product> findByName(String name);
	
	public List<Product> findByPlace(String place);
	
	public List<Product> findByType(String type);
	
public List<Product> findByWarrantyLessThan(Integer warranty);
}
