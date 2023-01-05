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

    @PostMapping("/post")
    public ResponseEntity orderPostController(
            @RequestBody Order order
            ){
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
