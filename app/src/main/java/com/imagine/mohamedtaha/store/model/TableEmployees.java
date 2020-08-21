package com.imagine.mohamedtaha.store.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TableEmployees {
    @PrimaryKey(autoGenerate = true)
    private int id_employee;
    private int id_permission;
    private int id_jobs;
    private String name_employee;
    private String phone_employee;
    private String address_employee;
    private String email_employees;
    private String notes;
    private String createdDate;
    private String createdTime;

    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }

    public int getId_permission() {
        return id_permission;
    }

    public void setId_permission(int id_permission) {
        this.id_permission = id_permission;
    }

    public int getId_jobs() {
        return id_jobs;
    }

    public void setId_jobs(int id_jobs) {
        this.id_jobs = id_jobs;
    }

    public String getName_employee() {
        return name_employee;
    }

    public void setName_employee(String name_employee) {
        this.name_employee = name_employee;
    }

    public String getPhone_employee() {
        return phone_employee;
    }

    public void setPhone_employee(String phone_employee) {
        this.phone_employee = phone_employee;
    }

    public String getAddress_employee() {
        return address_employee;
    }

    public void setAddress_employee(String address_employee) {
        this.address_employee = address_employee;
    }

    public String getEmail_employees() {
        return email_employees;
    }

    public void setEmail_employees(String email_employees) {
        this.email_employees = email_employees;
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

    public TableEmployees(int id_employee, int id_permission, int id_jobs, String name_employee, String phone_employee, String address_employee, String email_employees, String notes, String createdDate, String createdTime) {
        this.id_employee = id_employee;
        this.id_permission = id_permission;
        this.id_jobs = id_jobs;
        this.name_employee = name_employee;
        this.phone_employee = phone_employee;
        this.address_employee = address_employee;
        this.email_employees = email_employees;
        this.notes = notes;
        this.createdDate = createdDate;
        this.createdTime = createdTime;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }
}
