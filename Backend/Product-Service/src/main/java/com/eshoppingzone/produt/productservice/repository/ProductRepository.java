package com.eshoppingzone.produt.productservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.eshoppingzone.produt.productservice.entity.Product;

@Repository 
public interface ProductRepository extends MongoRepository<Product, Integer> {

	List<Product> findByProductName(String productName);

	List<Product> findByCategory(String category);

	List<Product> findByProductType(String productType);

	
}
