package org.example.service;

import org.example.model.MenuItem;
import org.example.model.Order;
import org.example.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public Optional<Order> getOrderByID(int id){
        Optional<Order> order = orderRepo.findById(id);
        return order;
    }
}
