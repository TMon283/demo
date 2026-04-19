package com.example.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class GadgetDto {
    private Long id;

    @NotBlank(message = "Tên sản phẩm không được để trống")
    @Size(min = 3, max = 100, message = "Tên sản phẩm phải từ 3 đến 100 ký tự")
    private String productName;

    @NotBlank(message = "Hãng sản xuất không được để trống")
    private String brand;

    @Min(value = 0, message = "Số lượng tồn kho phải >= 0")
    private int stockQuantity;

    private String productImage;

    public GadgetDto() {
    }

    public GadgetDto(Long id, String productName, String brand, int stockQuantity, String productImage) {
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
