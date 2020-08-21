package com.imagine.mohamedtaha.store.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TableAds {
    @PrimaryKey(autoGenerate = true)
    private int id_ads;
    private int id_employee;
    private int id_target_ads;
    private int id_platform_ads;
    private String name_ads;
    private String total_ads;
    private String total_target;
    private String start_date_ads;
    private String end_date_ads;

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

    private String createdDate;
    private String createdTime;

    public int getId_ads() {
        return id_ads;
    }

    public void setId_ads(int id_ads) {
        this.id_ads = id_ads;
    }

    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }

    public int getId_target_ads() {
        return id_target_ads;
    }

    public void setId_target_ads(int id_target_ads) {
        this.id_target_ads = id_target_ads;
    }

    public int getId_platform_ads() {
        return id_platform_ads;
    }

    public void setId_platform_ads(int id_platform_ads) {
        this.id_platform_ads = id_platform_ads;
    }

    public String getName_ads() {
        return name_ads;
    }

    public void setName_ads(String name_ads) {
        this.name_ads = name_ads;
    }

    public String getTotal_ads() {
        return total_ads;
    }

    public void setTotal_ads(String total_ads) {
        this.total_ads = total_ads;
    }

    public String getTotal_target() {
        return total_target;
    }

    public void setTotal_target(String total_target) {
        this.total_target = total_target;
    }

    public String getStart_date_ads() {
        return start_date_ads;
    }

    public void setStart_date_ads(String start_date_ads) {
        this.start_date_ads = start_date_ads;
    }

    public String getEnd_date_ads() {
        return end_date_ads;
    }

    public void setEnd_date_ads(String end_date_ads) {
        this.end_date_ads = end_date_ads;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }


    private String notes;

    public TableAds(int id_ads, int id_employee, int id_target_ads, int id_platform_ads, String name_ads, String total_ads, String total_target, String start_date_ads, String end_date_ads, String notes,String createdDate, String createdTime) {
        this.id_ads = id_ads;
        this.id_employee = id_employee;
        this.id_target_ads = id_target_ads;
        this.id_platform_ads = id_platform_ads;
        this.name_ads = name_ads;
        this.total_ads = total_ads;
        this.total_target = total_target;
        this.start_date_ads = start_date_ads;
        this.end_date_ads = end_date_ads;
        this.notes = notes;
        this.createdDate = createdDate;
        this.createdTime = createdTime;
    }
}
