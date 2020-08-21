package com.imagine.mohamedtaha.store.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "TableJobs")
public class TableJobs {
    @PrimaryKey(autoGenerate = true)
    private int id_jobs;
    private String title_position;
    private String notes;
    private String createdDate;
    private String createdTime;

    public TableJobs(int id_jobs, String title_position, String notes, String createdDate, String createdTime) {
        this.id_jobs = id_jobs;
        this.title_position = title_position;
        this.notes = notes;
        this.createdDate = createdDate;
        this.createdTime = createdTime;
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

    public int getId_jobs() {
        return id_jobs;
    }

    public void setId_jobs(int id_jobs) {
        this.id_jobs = id_jobs;
    }

    public String getTitle_position() {
        return title_position;
    }

    public void setTitle_position(String title_position) {
        this.title_position = title_position;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
