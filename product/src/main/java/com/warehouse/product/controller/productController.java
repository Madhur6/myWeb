package com.warehouse.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.warehouse.product.model.product;
import com.warehouse.product.service.productService;

@RestController
public class productController {
	@Autowired
	private productService pService;
	
	@PostMapping("/product/add")
	private Object postProduct(@RequestBody product p) {
		return pService.postProduct(p);
	}
	
	@GetMapping("/product/get")
	private Object getProduct() {
		return pService.getProduct();
	}
	
	@PutMapping("/product/{id}")
	private ResponseEntity<Object> updateProduct(@PathVariable int id, @RequestBody product p){
		return pService.updateProduct(id, p);
	}
	
	@DeleteMapping("/product/{id}")
	private ResponseEntity<Object> deleteProductById(@PathVariable int id){
		return pService.deleteProductById(id);
	}
	
	@GetMapping("/product/vendor")
	public ResponseEntity<Object> getSimilarVendor(@RequestParam String value){
		return pService.getSimilarVendor(value);
	}
}














