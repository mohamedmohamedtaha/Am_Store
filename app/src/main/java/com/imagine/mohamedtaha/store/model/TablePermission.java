package com.imagine.mohamedtaha.store.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TablePermission {
    @PrimaryKey(autoGenerate = true)
    private int id_permission;
    private String name_permission;
    private String notes;
    private String createdDate;
    private String createdTime;
    public int getId_permission() {
        return id_permission;
    }

    public void setId_permission(int id_permission) {
        this.id_permission = id_permission;
    }

    public String getName_permission() {
        return name_permission;
    }

    public void setName_permission(String name_permission) {
        this.name_permission = name_permission;
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

    public TablePermission(int id_permission, String name_permission, String notes, String createdDate, String createdTime) {
        this.id_permission = id_permission;
        this.name_permission = name_permission;
        this.notes = notes;
        this.createdDate = createdDate;
        this.createdTime = createdTime;
    }
}
