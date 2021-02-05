package com.mvc.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "orders")
public class Order {
    @Id
    long id;
    String order_id;
    long products_id;
    int qty;
    double price;
    String order_on;
    int status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public long getProducts_id() {
        return products_id;
    }

    public void setProducts_id(long products_id) {
        this.products_id = products_id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOrder_on() {
        return order_on;
    }

    public void setOrder_on(String order_on) {
        this.order_on = order_on;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
