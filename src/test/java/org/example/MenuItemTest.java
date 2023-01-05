package org.example;

import org.example.model.MenuItem;
import org.example.model.Order;
import org.example.repo.MenuItemRepo;
import org.example.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class MenuItemTest {

    @Autowired
    MenuItemRepo itemRepo;
    @Autowired
    OrderService orderServ;
    @Test
    public void testSaveItem(){
//        Optional<Order> order= orderServ.getOrderByID(10);
//        Order newOrder;
//        if (order.isPresent()){
//            newOrder = order.get();
//        }else{
//            System.out.println("no such order!");
//            return;
//        }
        MenuItem item = new MenuItem("Cheese Burger",false,3500,25,true);
        itemRepo.save(item);
    }
}
