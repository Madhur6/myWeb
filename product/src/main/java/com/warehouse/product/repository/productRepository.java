package com.warehouse.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.warehouse.product.model.product;

@Repository
public interface productRepository extends JpaRepository<product, Integer> {
		boolean existsBySku(String sku);

		List<product> findByVendor(String value);
}
