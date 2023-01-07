package org.example;

import org.example.model.MenuItem;
import org.example.model.Order;
import org.example.service.MenuItemService;
import org.example.service.OrderService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CartTest {
    @Autowired
    MenuItemService menuServ;
    @Autowired
    OrderService orderServ;
    @Test
    public void testOrderInsert(){
        int userID = 13;
        JSONObject jso = new JSONObject();
        JSONArray jsa = new JSONArray();
        MenuItem one = menuServ.getItemByID(2);
        MenuItem two = menuServ.getItemByID(3);
        MenuItem three = menuServ.getItemByID(4);
        MenuItem four = menuServ.getItemByID(5);
        MenuItem five = menuServ.getItemByID(6);
        MenuItem six = menuServ.getItemByID(6);
        List<MenuItem> items = new ArrayList<>();
//        items.add(one);
        items.add(two);
        items.add(three);
//        items.add(four);
        items.add(five);
        items.add(six);
        float totalPrice = 0;
        int totalCalories =0;

        Order order = new Order();
        try {
            for (MenuItem item:items){
                totalPrice+=item.getPrice();
                totalCalories+=item.getCalories();
                JSONObject temp = new JSONObject();
                temp.put("itemName", item.getItemName());
                temp.put("veg",item.isVeg());
                temp.put("calories",item.getCalories());
                temp.put("price",item.getPrice());
                temp.put("isAvailable",item.isAvailable());
                temp.put("itemID",item.getItemID());
                temp.put("kitchenID",item.getKitchenID());
                jsa.put(temp);
            }
            System.out.println("jsa: "+jsa.getJSONObject(0).get("kitchenID"));
            try {
                int kid = (int) jsa.getJSONObject(2).get("kitchenID");
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
            jso.put("orderList",jsa);
            String res = jso.toString();
            order.setDate(LocalDateTime.now());
            order.setOrderReady(false);
            order.setKitchenID(one.getKitchenID());
            order.setTotalCalories(totalCalories);
            order.setTotalPrice(totalPrice);
            order.setJsonData(res);
            order.setUserID(userID);
            System.out.println("res: "+res);
            System.out.println(order.toString());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }


        System.out.println("******* "+order.getOrderID());
        try {
            orderServ.saveOrder(order);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("saved order: "+ order.getOrderID());

    }
}
