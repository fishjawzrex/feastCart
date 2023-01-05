package org.example;

import org.example.model.MenuItem;
import org.example.model.Order;
import org.example.service.MenuItemService;
import org.example.service.OrderService;
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
        List<MenuItem> items= new ArrayList<>();
        items.add(menuServ.getItemByID(27));
        items.add(menuServ.getItemByID(28));
        float totalPrice = 0;
        int totalCalories =0;
        for (MenuItem item:items){
            totalPrice+=item.getPrice();
            totalCalories+=item.getCalories();
        }
        Order order = new Order(LocalDateTime.now(),11,totalPrice,items,totalCalories,false);
        try {
            orderServ.saveOrder(order);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("saved order: "+ order.getOrderID());

    }
}
