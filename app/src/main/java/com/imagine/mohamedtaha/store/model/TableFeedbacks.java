package com.imagine.mohamedtaha.store.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TableFeedbacks {
    @PrimaryKey(autoGenerate = true)
    private int id_feedback;
    private int id_customer;
    private String createdDate;
    private String createdTime;

    public TableFeedbacks(int id_feedback, int id_customer, String createdDate, String createdTime, int id_employee, String feedback, String notes) {
        this.id_feedback = id_feedback;
        this.id_customer = id_customer;
        this.createdDate = createdDate;
        this.createdTime = createdTime;
        this.id_employee = id_employee;
        this.feedback = feedback;
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

    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }

    private int id_employee;
    private String feedback;
    private String notes;

    public int getId_feedback() {
        return id_feedback;
    }

    public void setId_feedback(int id_feedback) {
        this.id_feedback = id_feedback;
    }

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
