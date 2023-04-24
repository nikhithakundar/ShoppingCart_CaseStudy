package com.eshoppingzone.produt.productservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eshoppingzone.produt.exception.ProductCategoryNotFoundException;
import com.eshoppingzone.produt.exception.ProductNotFoundException;
import com.eshoppingzone.produt.exception.ProductTypeNotExistsException;
import com.eshoppingzone.produt.productservice.entity.Product;

@Service 
public interface ProductService {
	
	public List<Product> getAllProduct()throws ProductNotFoundException;
	
	public Product getProductById(int productId)throws ProductNotFoundException;
	
	public Product addProduct(Product product)throws ProductNotFoundException;
	
	public Product updateProducts(Product product)throws ProductNotFoundException;
	
	public String deleteProductById(int productId)throws ProductNotFoundException;
	
	public List<Product> getProductByName(String productName)throws ProductNotFoundException;
	
	public List<Product>getProductByCategory(String category)throws ProductCategoryNotFoundException;
	
	public List<Product>getProductByType(String productType)throws ProductTypeNotExistsException;
	
	
	
	
	
	
	
	
	
	
	

}
