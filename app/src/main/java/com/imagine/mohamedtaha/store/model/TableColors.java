package com.imagine.mohamedtaha.store.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class TableColors implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private int id_color;
    private String name_color;
    private String createdDate;
    private String createdTime;

    public TableColors(int id_color, String name_color, String createdDate, String createdTime, String notes) {
        this.id_color = id_color;
        this.name_color = name_color;
        this.createdDate = createdDate;
        this.createdTime = createdTime;
        this.notes = notes;
    }

    public static final Creator<TableColors> CREATOR = new Creator<TableColors>() {
        @Override
        public TableColors createFromParcel(Parcel in) {
            return new TableColors(in);
        }

        @Override
        public TableColors[] newArray(int size) {
            return new TableColors[size];
        }
    };

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

    private String notes;

    protected TableColors(Parcel in) {
        id_color = in.readInt();
        name_color = in.readString();
        notes = in.readString();
    }


    public int getId_color() {
        return id_color;
    }

    public void setId_color(int id_color) {
        this.id_color = id_color;
    }


    public String getName_color() {
        return name_color;
    }

    public void setName_color(String name_color) {
        this.name_color = name_color;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Ignore
    public TableColors() {
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id_color);
        dest.writeString(name_color);
        dest.writeString(createdDate);
        dest.writeString(createdTime);
        dest.writeString(notes);
    }
}
