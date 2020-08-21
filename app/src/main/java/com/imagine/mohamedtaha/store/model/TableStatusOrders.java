package com.imagine.mohamedtaha.store.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TableStatusOrders {
    @PrimaryKey(autoGenerate = true)
    private int id_status_order;
    private int id_employee;
    private String name_status;
    private String notes;
    private String createdDate;
    private String createdTime;
    public int getId_status_order() {
        return id_status_order;
    }

    public void setId_status_order(int id_status_order) {
        this.id_status_order = id_status_order;
    }

    public String getName_status() {
        return name_status;
    }

    public void setName_status(String name_status) {
        this.name_status = name_status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
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

    public TableStatusOrders(int id_status_order, int id_employee, String name_status, String notes, String createdDate, String createdTime) {
        this.id_status_order = id_status_order;
        this.id_employee = id_employee;
        this.name_status = name_status;
        this.notes = notes;
        this.createdDate = createdDate;
        this.createdTime = createdTime;
    }
}
