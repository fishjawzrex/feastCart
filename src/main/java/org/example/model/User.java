package org.example.model;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

//@Entity
public class User {

//    @Id
//    @GeneratedValue(strategy= GenerationType.AUTO)
    private int userID;
    private String userName;
    private  String email;
    private List<Integer> orderIdList;


}
