package com.boot.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.crud.entity.Product;
import com.boot.crud.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	public List<Product> saveProducts(List<Product> products){
		return productRepository.saveAll(products);
	}
	
	public List<Product> getProducts(){
		return productRepository.findAll();
	}
	
	public Product getProductById(int id) {
		return productRepository.findById(id).orElse(null);
	}
	
	public Product getProductByName(String name) {
		return productRepository.findByName(name);
	}
	
	public String deleteProduct(int id) {
		productRepository.deleteById(id);
		return "Product Removed id : "+id;
	}
	
	public Product updateProduct(Product product) {
		Product existing =  productRepository.findById(product.getId()).orElse(null);
		existing.setName(product.getName());
		existing.setPrice(product.getPrice());
		existing.setQuantity(product.getQuantity());
		
		return productRepository.save(existing);
	}

}
