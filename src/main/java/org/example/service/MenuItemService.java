package org.example.service;

import org.example.model.MenuItem;
import org.example.repo.MenuItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MenuItemService {

    @Autowired
    MenuItemRepo itemRepo;

    public void addMenuItem(MenuItem item){
        try {
            itemRepo.save(item);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("item "+item.getItemName()+" successfully saved!");
    }

    public MenuItem getItemByName(int id){
        MenuItem concreteItem;
        Optional<MenuItem> optionalItem = itemRepo.findById(id);
        if(optionalItem.isPresent()){
            concreteItem = optionalItem.get();
        }else{
            System.out.println("no such item with given id!");
            return null;
        }
        System.out.println("success!");
        return concreteItem;
    }
}
