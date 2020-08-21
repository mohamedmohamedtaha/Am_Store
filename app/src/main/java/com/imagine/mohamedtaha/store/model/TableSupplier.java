package com.imagine.mohamedtaha.store.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TableSupplier {
    @PrimaryKey(autoGenerate = true)
    private int id_supplier;
    private int id_employee;
    private String name_supplier;
    private String phone_supplier;
    private String email_supplier;
    private String address_supplier;
    private String phone_home;
    private String notes;
    private String createdDate;
    private String createdTime;
    public int getId_supplier() {
        return id_supplier;
    }

    public void setId_supplier(int id_supplier) {
        this.id_supplier = id_supplier;
    }

    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }

    public String getName_supplier() {
        return name_supplier;
    }

    public void setName_supplier(String name_supplier) {
        this.name_supplier = name_supplier;
    }

    public String getPhone_supplier() {
        return phone_supplier;
    }

    public void setPhone_supplier(String phone_supplier) {
        this.phone_supplier = phone_supplier;
    }

    public String getEmail_supplier() {
        return email_supplier;
    }

    public void setEmail_supplier(String email_supplier) {
        this.email_supplier = email_supplier;
    }

    public String getAddress_supplier() {
        return address_supplier;
    }

    public void setAddress_supplier(String address_supplier) {
        this.address_supplier = address_supplier;
    }

    public String getPhone_home() {
        return phone_home;
    }

    public void setPhone_home(String phone_home) {
        this.phone_home = phone_home;
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

    public TableSupplier(int id_supplier, int id_employee, String name_supplier, String phone_supplier, String email_supplier, String address_supplier, String phone_home, String notes, String createdDate, String createdTime) {
        this.id_supplier = id_supplier;
        this.id_employee = id_employee;
        this.name_supplier = name_supplier;
        this.phone_supplier = phone_supplier;
        this.email_supplier = email_supplier;
        this.address_supplier = address_supplier;
        this.phone_home = phone_home;
        this.notes = notes;
        this.createdDate = createdDate;
        this.createdTime = createdTime;
    }
}
