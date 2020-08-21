package com.imagine.mohamedtaha.store.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TableCustomers {
    @PrimaryKey(autoGenerate = true)
    private int id_customer;
    private int feed_back;
    private int id_employee;
    private String name_customer;
    private String name_page_customer;
    private String phone_customer;
    private String anther_phone;
    private String email_customer;
    private String address_customer;
    private String link_facebook;
    private String createdDate;
    private String createdTime;

    public TableCustomers(int id_customer, int feed_back, int id_employee, String name_customer, String name_page_customer, String phone_customer, String anther_phone, String email_customer, String address_customer, String link_facebook, String createdDate, String createdTime) {
        this.id_customer = id_customer;
        this.feed_back = feed_back;
        this.id_employee = id_employee;
        this.name_customer = name_customer;
        this.name_page_customer = name_page_customer;
        this.phone_customer = phone_customer;
        this.anther_phone = anther_phone;
        this.email_customer = email_customer;
        this.address_customer = address_customer;
        this.link_facebook = link_facebook;
        this.createdDate = createdDate;
        this.createdTime = createdTime;
    }

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public int getFeed_back() {
        return feed_back;
    }

    public void setFeed_back(int feed_back) {
        this.feed_back = feed_back;
    }

    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }

    public String getName_customer() {
        return name_customer;
    }

    public void setName_customer(String name_customer) {
        this.name_customer = name_customer;
    }

    public String getName_page_customer() {
        return name_page_customer;
    }

    public void setName_page_customer(String name_page_customer) {
        this.name_page_customer = name_page_customer;
    }

    public String getPhone_customer() {
        return phone_customer;
    }

    public void setPhone_customer(String phone_customer) {
        this.phone_customer = phone_customer;
    }

    public String getAnther_phone() {
        return anther_phone;
    }

    public void setAnther_phone(String anther_phone) {
        this.anther_phone = anther_phone;
    }

    public String getEmail_customer() {
        return email_customer;
    }

    public void setEmail_customer(String email_customer) {
        this.email_customer = email_customer;
    }

    public String getAddress_customer() {
        return address_customer;
    }

    public void setAddress_customer(String address_customer) {
        this.address_customer = address_customer;
    }

    public String getLink_facebook() {
        return link_facebook;
    }

    public void setLink_facebook(String link_facebook) {
        this.link_facebook = link_facebook;
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
}
