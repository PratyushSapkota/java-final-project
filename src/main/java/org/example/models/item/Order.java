package org.example.models.item;

import java.util.ArrayList;
import java.util.List;

public class Order {
    String buyerName;
    List<Item> itemList = new ArrayList<>();
    double totalPrice = 0;

    public Order(List<Item> itemList, String buyerName){
        this.buyerName = buyerName;
        this.itemList = itemList;
    }

    public double getTotalPrice(){
        for(Item item : itemList){
            totalPrice += item.getPrice();
        }
        return this.totalPrice;
    }

}
