package org.example.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Cart")
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int orderID;
    private LocalDateTime date;

    private int userID;
    private float totalPrice;
    @OneToMany
    @JsonManagedReference
    private List<MenuItem> orderList;
    private int totalCalories;
    private boolean orderReady;

    public Order(LocalDateTime date, int userID, float totalPrice, List<MenuItem> orderList, int totalCalories, boolean orderReady) {
        this.date = date;
        this.userID = userID;
        this.totalPrice = totalPrice;
        this.orderList = orderList;
        this.totalCalories = totalCalories;
        this.orderReady = orderReady;
    }


    public List<MenuItem> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<MenuItem> orderList) {
        this.orderList = orderList;
    }

    public int getOrderID() {
        return orderID;
    }
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    public Order() {
    }
    public Order(int id) {
        this.userID = id;
        this.date = LocalDateTime.now();
    }


}
