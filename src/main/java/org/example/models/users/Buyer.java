package org.example.models.users;

import org.example.models.item.Order;

import java.util.ArrayList;
import java.util.List;

public class Buyer extends User{
    List<Order> orderList = new ArrayList<>();

    public Buyer(String username, String password, String firstName, String lastName, int houseNumber) {
        super(username, password, firstName, lastName, houseNumber);
    }
}
