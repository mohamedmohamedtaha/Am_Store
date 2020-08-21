package com.imagine.mohamedtaha.store.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TableOrders {
    @PrimaryKey(autoGenerate = true)
    private int id_order;
    private int id_customer;
    private int id_employee;
    private int id_product;
    private int id_color;
    private int id_payment;
    private int id_coupon;
    private int id_status_order;
    private int count_orders;
    private int price_orders;
    private String date_order;
    private String date_deliver;
    private String notes;
    private String createdDate;
    private String createdTime;
    public int getId_order() {
        return id_order;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public int getId_color() {
        return id_color;
    }

    public void setId_color(int id_color) {
        this.id_color = id_color;
    }

    public int getId_payment() {
        return id_payment;
    }

    public void setId_payment(int id_payment) {
        this.id_payment = id_payment;
    }

    public int getId_coupon() {
        return id_coupon;
    }

    public void setId_coupon(int id_coupon) {
        this.id_coupon = id_coupon;
    }

    public int getId_status_order() {
        return id_status_order;
    }

    public void setId_status_order(int id_status_order) {
        this.id_status_order = id_status_order;
    }

    public int getCount_orders() {
        return count_orders;
    }

    public void setCount_orders(int count_orders) {
        this.count_orders = count_orders;
    }

    public int getPrice_orders() {
        return price_orders;
    }

    public void setPrice_orders(int price_orders) {
        this.price_orders = price_orders;
    }

    public String getDate_order() {
        return date_order;
    }

    public void setDate_order(String date_order) {
        this.date_order = date_order;
    }

    public String getDate_deliver() {
        return date_deliver;
    }

    public void setDate_deliver(String date_deliver) {
        this.date_deliver = date_deliver;
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

    public TableOrders(int id_order, int id_customer, int id_employee, int id_product, int id_color, int id_payment, int id_coupon, int id_status_order, int count_orders, int price_orders, String date_order, String date_deliver, String notes, String createdDate, String createdTime) {
        this.id_order = id_order;
        this.id_customer = id_customer;
        this.id_employee = id_employee;
        this.id_product = id_product;
        this.id_color = id_color;
        this.id_payment = id_payment;
        this.id_coupon = id_coupon;
        this.id_status_order = id_status_order;
        this.count_orders = count_orders;
        this.price_orders = price_orders;
        this.date_order = date_order;
        this.date_deliver = date_deliver;
        this.notes = notes;
        this.createdDate = createdDate;
        this.createdTime = createdTime;
    }
}

