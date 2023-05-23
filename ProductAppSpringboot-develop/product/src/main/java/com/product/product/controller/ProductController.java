package com.product.product.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.product.entity.Product;
import com.product.product.exception.ResourceNotFound;
import com.product.product.service.ProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin("http://localhost:3000")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping
	public Product saveProduct(@RequestBody Product p) {
		try {
			return productService.saveProduct(p);
		} catch (Exception e) {

			throw new ResourceNotFound("Product  not Saved");
		}
	}
	
	//Get All Product
	@GetMapping("/")
	public ResponseEntity<List<Product>> getAllProduct() {
		List<Product> product  = productService.getAllProduct();
		return new ResponseEntity<List<Product>> (product,HttpStatus.OK);
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<List<Product>> getProductByName(@PathVariable String name) {
		List<Product> product  = productService.getByName(name);
		return new ResponseEntity<List<Product>> (product,HttpStatus.OK);
	}


	@GetMapping("/type/{type}")
	public ResponseEntity<List<Product>> getProductByType(@PathVariable String type) {
		List<Product> product  = productService.getByType(type);
		return new ResponseEntity<List<Product>> (product,HttpStatus.OK);
	}
	
	@GetMapping("/pid/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
	Product product  = productService.getById(id);
		return new ResponseEntity<Product> (product,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public ResponseEntity<String> deleteItem(@PathVariable Integer id) {
	   productService.deleteProduct(id);
		return new ResponseEntity<String> ("deleted successfully",HttpStatus.OK);
	}
	
	@GetMapping("/place/{place}")
	public ResponseEntity<List<Product>> getProductByPlace(@PathVariable String place) {
		List<Product> product  = productService.getByPlace(place);
		return new ResponseEntity<List<Product>> (product,HttpStatus.OK);
	}
	
	@GetMapping("/isExp/{warranty}")
	public ResponseEntity<List<Product>> getProductByType(@PathVariable Integer warranty) {
		List<Product> product  = productService.getByExpired(warranty);
		return new ResponseEntity<List<Product>> (product,HttpStatus.OK);
	}

}
