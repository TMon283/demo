package com.example.demo.model;

public class Gadget {
    private Long id;
    private String productName;
    private String brand;
    private int stockQuantity;
    private String productImage;

    public Gadget() {
    }

    public Gadget(Long id, String productName, String brand, int stockQuantity, String productImage) {
        this.id = id;
        this.productName = productName;
        this.brand = brand;
        this.stockQuantity = stockQuantity;
        this.productImage = productImage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }
}
