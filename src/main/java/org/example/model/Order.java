package org.example.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Entity
@Table(name="Cart")
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int orderID;
    private LocalDateTime date;

    private int userID;
    private float totalPrice;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JsonManagedReference
//    @ElementCollection

//    @Column(columnDefinition="varchar(5000)")

//    @Lob
    @Column(length = 1000)
    private String jsonData;
    private int totalCalories;
    private boolean orderReady;

    public int getKitchenID() {
        return kitchenID;
    }

    public void setKitchenID(int kitchenID) {
        this.kitchenID = kitchenID;
    }

    private int kitchenID;

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getJsonData() {
        return jsonData;
    }

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }

    public void setTotalCalories(int totalCalories) {
        this.totalCalories = totalCalories;
    }

    public void setOrderReady(boolean orderReady) {
        this.orderReady = orderReady;
    }

    public Order(LocalDateTime date, int kitchenID, int userID, float totalPrice, List<MenuItem> orderList, int totalCalories, boolean orderReady) {
        this.date = date;
        this.kitchenID = kitchenID;
        this.userID = userID;
        this.totalPrice = totalPrice;
//        this.orderList = orderList;
        this.totalCalories = totalCalories;
        this.orderReady = orderReady;
    }

    public Order(String jsonData) {
        this.jsonData = jsonData;
    }
//    public List<MenuItem> getOrderList() {
//        return orderList;
//    }
//
//    public void setOrderList(List<MenuItem> orderList) {
//        this.orderList = orderList;
//    }

    public int getOrderID() {
        return orderID;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public int getUserID() {
        return userID;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public int getTotalCalories() {
        return totalCalories;
    }

    public boolean isOrderReady() {
        return orderReady;
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
