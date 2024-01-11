package com.example.project_application.model;


public class Products {


    private Long productID;

    private String name;

    private String description;

    private Double price;

    private String img;

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Products{" +
                "productId =" + productID +
                ", name =" + name + '\'' +
                ", description =" + description + '\'' +
                ", price =" + price + '\'' +
                ", img = " + img + '\'' +
                '}';
    }

}
