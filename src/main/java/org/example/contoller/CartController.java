package org.example.contoller;

import org.example.model.MenuItem;
import org.example.model.Order;
import org.example.model.User;
import org.example.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class CartController {
    @Autowired
    OrderRepo orderRepo;

    @GetMapping("/test")
    public String testCartController(){
        return  "CartController test successfull!";
    }

    @PostMapping(value = "/post", consumes = {"application/json"})
    public ResponseEntity orderPostController(
            @RequestBody Order order
            ){
        System.out.println(order);
        System.out.println("orderList: "+order.getOrderList());
        System.out.println("id: "+order.getOrderID());
        System.out.println("usrid: "+order.getUserID());
        System.out.println("orderDate: "+order.getDate());
        System.out.println("calories: "+order.getTotalCalories());
        try {
            List<MenuItem> items = new ArrayList<>();
            order.setOrderList(items);
            orderRepo.save(order);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("successfully saved: "+order.getOrderID());
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
