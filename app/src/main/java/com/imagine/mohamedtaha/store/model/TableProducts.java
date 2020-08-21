package com.imagine.mohamedtaha.store.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TableProducts {
    @PrimaryKey(autoGenerate = true)
    private int id_product;
    private int id_category;
    private int id_employee;
    private String name_product;
    private String price_product;
    private String price_market;
    private String notes;
    private String createdDate;
    private String createdTime;
    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }

    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public String getPrice_product() {
        return price_product;
    }

    public void setPrice_product(String price_product) {
        this.price_product = price_product;
    }

    public String getPrice_market() {
        return price_market;
    }

    public void setPrice_market(String price_market) {
        this.price_market = price_market;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public TableProducts(int id_product, int id_category, int id_employee, String name_product, String price_product, String price_market, String notes, String createdDate, String createdTime) {
        this.id_product = id_product;
        this.id_category = id_category;
        this.id_employee = id_employee;
        this.name_product = name_product;
        this.price_product = price_product;
        this.price_market = price_market;
        this.notes = notes;
        this.createdDate = createdDate;
        this.createdTime = createdTime;
    }
}
