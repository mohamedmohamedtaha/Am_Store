package com.imagine.mohamedtaha.store.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TableCategories {
    @PrimaryKey(autoGenerate = true)
    private int id_category;
    private String name_category;
    private String notes;
    private String createdDate;
    private String createdTime;

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

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }
    
    public String getName_category() {
        return name_category;
    }

    public void setName_category(String name_category) {
        this.name_category = name_category;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

   public TableCategories(int id_category, String name_category, String notes, String createdDate, String createdTime) {
       this.id_category = id_category;
       this.name_category = name_category;
       this.notes = notes;
       this.createdDate = createdDate;
       this.createdTime = createdTime;

}
}
