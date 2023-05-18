package com.eshop.ThymeleafEshop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "PartNumber is mandatory attribute!")
    private int partNumber;
    @NotEmpty(message = "Name is mandatory attribute!")
    private String name;
    @NotEmpty(message = "Description is mandatory attribute!")
    private String description;
    @NotEmpty(message = "IsForSale is mandatory attribute!")
    private boolean isForSale;

    @Column(columnDefinition = "TINYINT(1)")
    public int booleanToInt (boolean isForSale){
        return (isForSale) ? 1 : 0;
    }
    @NotNull(message = "Price is mandatory attribute!")
    private Double price;

    public Product() {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(int partNumber) {
        this.partNumber = partNumber;
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

    public boolean isForSale() {
        return isForSale;
    }

    public void setForSale(boolean forSale) {
        isForSale = forSale;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }



}
