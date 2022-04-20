package com.example.demo.service;

import com.example.demo.model.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getAllProducts();

    public Product createProduct(Product product);

    public void deleteProduct(int id);

    public Product getProduct(int id);
}
