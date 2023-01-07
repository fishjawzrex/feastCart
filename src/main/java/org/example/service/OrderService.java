package org.example.service;

import org.example.model.MenuItem;
import org.example.model.Order;
import org.example.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;

    public void saveOrder(Order order){

        try {
            orderRepo.save(order);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public List<Order> getAllOrders(){
        try {
            List<Order> resSet= orderRepo.findAll();
            return resSet;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Order getOrderByID(int id){
        Optional<Order> order = orderRepo.findById(id);
        Order concreteOrder;
        if (order.isPresent()){
            concreteOrder=order.get();
            return concreteOrder;
        }
        System.out.println("order not found...");
        return null;
    }
}
