package org.example.models.database;

import org.example.models.item.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database_Seller extends Database {

    public void addItem(Item item, int sellerId){
        Connection connection = getConnection();
        try {
            String query = "INSERT INTO ITEMS (itemName, itemPrice, itemSeller) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, item.getItemName());
            preparedStatement.setDouble(2, item.getPrice());
            preparedStatement.setInt(3, sellerId);
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        }catch (SQLException e){
            System.out.println("Error while adding an item");
            e.printStackTrace();
        }

    }

    public String getSellerName(int sellerId){
        Connection connection = getConnection();
        String sellerName = "";
        try {
            String query = "SELECT * FROM USERS WHERE userId = " + sellerId;
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            statement.close();
            while(rs.next()){
                sellerName = rs.getString("fname") + " " + rs.getString("lname");
            }
            statement.close();
            connection.close();
        }catch (Exception e){
            System.out.println("Error while getting seller name");
        }

        return sellerName;
    }

    public List<Item> getListedItem(int userId){
        Connection connection = getConnection();
        List<Item> items = new ArrayList<>();
        try {
            String query = "SELECT * FROM ITEMS where itemSeller = '"+userId+"'";
            connection.close();
        }catch (Exception e){

        }
        return items;
    }


}
