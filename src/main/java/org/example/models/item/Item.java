package org.example.models.item;

public class Item {
    String itemName;
    double price;
    String sellerName;

    public Item(String itemName, double price, String sellerName) {
        this.itemName = itemName;
        this.price = price;
        this.sellerName = sellerName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }
}
