package com.imagine.mohamedtaha.store.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TablePayments {
    @PrimaryKey(autoGenerate = true)
    private int id_payment;
    private String way_payment;
    private String notes;
    private String createdDate;
    private String createdTime;
    public int getId_payment() {
        return id_payment;
    }

    public void setId_payment(int id_payment) {
        this.id_payment = id_payment;
    }
    public String getWay_payment() {
        return way_payment;
    }

    public void setWay_payment(String way_payment) {
        this.way_payment = way_payment;
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

    public TablePayments(int id_payment, String way_payment, String notes, String createdDate, String createdTime) {
        this.id_payment = id_payment;
        this.way_payment = way_payment;
        this.notes = notes;
        this.createdDate = createdDate;
        this.createdTime = createdTime;
    }
}
