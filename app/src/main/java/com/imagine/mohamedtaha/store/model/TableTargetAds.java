package com.imagine.mohamedtaha.store.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TableTargetAds {
    @PrimaryKey(autoGenerate = true)
    private int id_target_ads;
    private String name_target_ads;
    private String notes;
    private String createdDate;
    private String createdTime;
    public int getId_target_ads() {
        return id_target_ads;
    }

    public void setId_target_ads(int id_target_ads) {
        this.id_target_ads = id_target_ads;
    }

    public String getName_target_ads() {
        return name_target_ads;
    }

    public void setName_target_ads(String name_target_ads) {
        this.name_target_ads = name_target_ads;
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

    public TableTargetAds(int id_target_ads, String name_target_ads, String notes, String createdDate, String createdTime) {
        this.id_target_ads = id_target_ads;
        this.name_target_ads = name_target_ads;
        this.notes = notes;
        this.createdDate = createdDate;
        this.createdTime = createdTime;
    }
}
