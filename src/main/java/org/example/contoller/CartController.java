package org.example.contoller;

import org.example.model.MenuItem;
import org.example.model.Order;
import org.example.model.User;
import org.example.repo.OrderRepo;
import org.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/orders")
public class CartController {
    @Autowired
    OrderRepo orderRepo;

    @Autowired
    OrderService orderServ;

    @GetMapping("/test")
    public String testCartController(){
        return  "CartController test successfull!";
    }

    @GetMapping("all")
    public List<Order> getAllOrders(){
        try {
            List<Order> orderSet = orderServ.getAllOrders();
            return orderSet;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/{orderID}")
    public Order getOrderByID(@PathVariable int orderID){

            Order order = orderServ.getOrderByID(orderID);
            if (order==null){
                Order orderError = new Order("order not found@");
                return orderError;
            }
            return order;

    }
    @PutMapping("/update/{orderID}")
    public ResponseEntity updateOrder(@PathVariable int orderID,@RequestBody Order order){
        try {
            Order tempOrder = orderServ.getOrderByID(orderID);
            tempOrder.setOrderReady(order.isOrderReady());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping(value = "/post", consumes = {"application/json"})
    public ResponseEntity orderPostController(
            @RequestBody Order order
            ){
        System.out.println(order);
//        System.out.println("orderList: "+order.getOrderList());
        System.out.println("id: "+order.getOrderID());
        System.out.println("usrid: "+order.getUserID());
        System.out.println("orderDate: "+order.getDate());
        System.out.println("calories: "+order.getTotalCalories());
        try {
            List<MenuItem> items = new ArrayList<>();
//            order.setOrderList(items);
            orderRepo.save(order);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("successfully saved: "+order.getOrderID());
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
