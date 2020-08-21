package com.imagine.mohamedtaha.store.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TableCoupons {
    @PrimaryKey(autoGenerate = true)
    private int id_coupon;
    private int id_employee;
    private String name_coupon;
    private String notes;
    private String createdDate;
    private String createdTime;
    public int getId_coupon() {
        return id_coupon;
    }

    public void setId_coupon(int id_coupon) {
        this.id_coupon = id_coupon;
    }

    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }

    public String getName_coupon() {
        return name_coupon;
    }

    public void setName_coupon(String name_coupon) {
        this.name_coupon = name_coupon;
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

    public TableCoupons(int id_coupon, int id_employee, String name_coupon, String notes, String createdDate, String createdTime) {
        this.id_coupon = id_coupon;
        this.id_employee = id_employee;
        this.name_coupon = name_coupon;
        this.notes = notes;
        this.createdDate = createdDate;
        this.createdTime = createdTime;
    }
}
