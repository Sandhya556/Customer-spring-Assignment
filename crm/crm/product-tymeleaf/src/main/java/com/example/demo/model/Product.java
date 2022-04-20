package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "product_table")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_id")
    private int productId;

    @Column(name = "p_name")
    private String productName;

    @Column(name = "price")
    private double price;

    @Column(name = "availability")
    private boolean isAvailable;

    public Product() {
    }

    public Product(String productName, double price, boolean isAvailable) {
        this.productName = productName;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public Product(int productId, String productName, double price, boolean isAvailable) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Product[" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", isAvailable=" + isAvailable +
                ']';
    }
}
