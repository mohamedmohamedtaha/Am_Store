package com.imagine.mohamedtaha.store.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TablePlatformAds {
    @PrimaryKey(autoGenerate = true)
    private int id_platform_ads;
    private int id_employee;
    private String name_platform_ads;
    private String notes;
    private String createdDate;
    private String createdTime;
    public int getId_platform_ads() {
        return id_platform_ads;
    }

    public void setId_platform_ads(int id_platform_ads) {
        this.id_platform_ads = id_platform_ads;
    }

    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }

    public String getName_platform_ads() {
        return name_platform_ads;
    }

    public void setName_platform_ads(String name_platform_ads) {
        this.name_platform_ads = name_platform_ads;
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

    public TablePlatformAds(int id_platform_ads, int id_employee, String name_platform_ads, String notes, String createdDate, String createdTime) {
        this.id_platform_ads = id_platform_ads;
        this.id_employee = id_employee;
        this.name_platform_ads = name_platform_ads;
        this.notes = notes;
        this.createdDate = createdDate;
        this.createdTime = createdTime;
    }
}
