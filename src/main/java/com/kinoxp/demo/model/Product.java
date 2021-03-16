package com.kinoxp.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productid;

    public Long getId() {
        return productid;
    }
    public void setId(Long id) {
        this.productid = id;
    }

    private String productname;

    private int price;

    private String category;

    private String description;


    public String getProductName() {
        return productname;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public int price() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setProductName(String productname) {
        this.productname = productname;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public void setDescription(String description) {
        this.description = description;
    }


}
