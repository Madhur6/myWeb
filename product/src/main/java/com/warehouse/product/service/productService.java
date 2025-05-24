package com.warehouse.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.warehouse.product.model.product;
import com.warehouse.product.repository.productRepository;

@Service
public class productService {
	
	@Autowired
	private productRepository productrepository;
	
	public Object postProduct(product product) {
		if (productrepository.existsBySku(product.getSku())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		try {
			product p = new product(product.getName(), product.getDescription(),
					product.getVendor(), product.getPrice(), product.getStock(), product.getCurrency(), product.getImage_url(), product.getSku());
			productrepository.save(p);
			return ResponseEntity.status(HttpStatus.CREATED).build();
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	
	
	
	public Object getProduct() {
		List<product> products = productrepository.findAll();
		if (products.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.ok(products);
	}
	
	
	public ResponseEntity<Object> getSimilarVendor(String value){
		List<product> similarProducts = productrepository.findByVendor(value);
		
		if (similarProducts.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.ok(similarProducts);
	}
	
	
	
	public ResponseEntity<Object> updateProduct(int id, product p){
		Optional<product> optionalProduct = productrepository.findById(id);
		if(!optionalProduct.isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		try {
			product existProduct = optionalProduct.get();
			existProduct.setPrice(p.getPrice());
			existProduct.setStock(p.getStock());
			product saveProduct = productrepository.save(existProduct);
			
			return ResponseEntity.status(HttpStatus.OK).body(saveProduct);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	
	
	public ResponseEntity<Object> deleteProductById(int id){
		if (!productrepository.existsById(id)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		try {
			productrepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).build();
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}










