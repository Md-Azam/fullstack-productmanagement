package com.product.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.product.entity.Product;
import com.product.product.exception.ResourceNotFound;
import com.product.product.repository.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo repositiory;
	
	public Product saveProduct(Product p) {
		return repositiory.save(p);
	}
	
	public List<Product> getAllProduct() {
		try {
			return repositiory.findAll();
		}catch(Exception e) {
			throw new ResourceNotFound("No Product Found");
		}
	}
	
	public List<Product> getByName(String name) {
		try {
		List<Product> getProductByName = repositiory.findByName(name);
		return getProductByName;
		}catch(Exception e) {
			throw new ResourceNotFound("Product Name not found");
		}
	}
	
	
	public Product getById(Integer id) {
		try {
	Product getByPid = repositiory.findById(id).orElseThrow(() -> new ResourceNotFound("ID not found"));
			return getByPid;
		}catch(Exception e) {
			throw new ResourceNotFound("Product Name not found");
		}
	}
	
	
	public String deleteProduct(Integer id) {
		try {
	Product getByPid = repositiory.findById(id).orElseThrow(() -> new ResourceNotFound("ID not found"));
			repositiory.delete(getByPid);
	return "product deleted";
		}catch(Exception e) {
			throw new ResourceNotFound("Product Name not found");
		}
	}
	
	public List<Product> getByPlace(String place) {
		try {
		List<Product> getProduct = repositiory.findByPlace(place);
		return getProduct;
		}catch(Exception e) {
			throw new ResourceNotFound("Product By Place not found");
		}
	}
	
	public List<Product> getByType(String type) {
		try {
		List<Product> getProduct = repositiory.findByType(type);
		return getProduct;
		}catch(Exception e) {
			throw new ResourceNotFound("Product Type not found");
		}
	}
	
	public List<Product> getByExpired(Integer warranty){
		try {
		return repositiory.findByWarrantyLessThan(warranty);
		}catch(Exception e) {
			throw new ResourceNotFound("Product warranty not found");
		}
	}
	
	
}
