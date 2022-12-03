package com.read.excle.propertiesfile.readfile.model;

public class Product {

    private String id;
    private String ProductName;
    private String price;
    private String Category;

    public Product() {
    }

    public Product(String id, String productName, String price, String category) {
        this.id = id;
        ProductName = productName;
        this.price = price;
        Category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }
}
