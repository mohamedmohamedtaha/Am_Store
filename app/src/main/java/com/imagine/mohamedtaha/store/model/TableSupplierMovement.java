package com.imagine.mohamedtaha.store.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TableSupplierMovement {
    @PrimaryKey(autoGenerate = true)
    private int id_supplier_movement;
    private int id_employee;
    private int id_supplier;
    private int id_product;
    private int count;
    private int id_color;
    private int total_price;
    private String notes;
    private String createdDate;
    private String createdTime;
    public int getId_supplier_movement() {
        return id_supplier_movement;
    }

    public void setId_supplier_movement(int id_supplier_movement) {
        this.id_supplier_movement = id_supplier_movement;
    }

    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }

    public int getId_supplier() {
        return id_supplier;
    }

    public void setId_supplier(int id_supplier) {
        this.id_supplier = id_supplier;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getId_color() {
        return id_color;
    }

    public void setId_color(int id_color) {
        this.id_color = id_color;
    }

    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
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

    public TableSupplierMovement(int id_supplier_movement, int id_employee, int id_supplier, int id_product, int count, int id_color, int total_price, String notes, String createdDate, String createdTime) {
        this.id_supplier_movement = id_supplier_movement;
        this.id_employee = id_employee;
        this.id_supplier = id_supplier;
        this.id_product = id_product;
        this.count = count;
        this.id_color = id_color;
        this.total_price = total_price;
        this.notes = notes;
        this.createdDate = createdDate;
        this.createdTime = createdTime;
    }
}
