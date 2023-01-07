package org.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name="MenuItem")
public class MenuItem {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    int itemID;
    String itemName;
    boolean veg;
    int calories;
    float price;
    int kitchenID;
    private boolean isAvailable;

//    @ManyToOne
//    @JoinColumn(name = "order_order_id")
//    private Order order;

//    public Order getOrder() {
//        return order;
//    }
//
//    public void setOrder(Order order) {
//        this.order = order;
//    }

    public int getItemID() {
        return itemID;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public boolean isVeg() {
        return veg;
    }

    public MenuItem() {
    }

    public MenuItem(String itemName, boolean veg, int calories, float price, boolean isAvailable) {
        this.itemName = itemName;
        this.veg = veg;
//        this.order = order;
        this.calories = calories;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public MenuItem(String name) {
        this.itemName = name;
    }
    public int getCalories() {
        return calories;
    }
    public void setCalories(int calories) {
        this.calories = calories;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public String getItemName() {
        return itemName;
    }

    public int getKitchenID() {
        return kitchenID;
    }

    public void setKitchenID(int kitchenID) {
        this.kitchenID = kitchenID;
    }
}
