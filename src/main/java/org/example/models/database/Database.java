package org.example.models.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Database {
    String url = "jdbc:sqlite:database.db";

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url);

            Statement statement = connection.createStatement();
            String userQuery = "CREATE TABLE IF NOT EXISTS USERS ( " +
                    "userId INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "fname varchar(50), " +
                    "lname varchar(50), " +
                    "uname varchar(50), " +
                    "password varchar(50), " +
                    "houseNumber INTEGER, " +
                    "isBuyer BOOL" +
                    ")";
            statement.execute(userQuery);

            String itemQuery = "CREATE TABLE IF NOT EXISTS ITEMS (" +
                    "itemId INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "itemName VARCHAR(50), " +
                    "itemPrice DOUBLE, " +
                    "itemSeller INTEGER" +
                    ")";

            statement.execute(itemQuery);

            String orderQuery = "CREATE TABLE IF NOT EXISTS ORDERS (" +
                    "sellerId INTEGER, " +
                    "totalPrice double, " +
                    "items varchar(100), " +
                    "orderOf varchar(100), " +
                    "shipTo int" +
                    ")";

            statement.execute(orderQuery);
        } catch (Exception e) {
            System.out.println("Error connecting to the database");
        }

        return connection;
    }

}
