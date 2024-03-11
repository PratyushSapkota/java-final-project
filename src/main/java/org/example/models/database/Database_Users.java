package org.example.models.database;

import org.example.models.users.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database_Users extends Database {


    public boolean isUniqueUsername(String username) {
        Connection connection = getConnection();
        boolean unique = true;

        try {
            String query = "SELECT * FROM USERS WHERE uname = '" + username + "'";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                // exists
                unique = false;
            } else {
                unique = true;
            }
            connection.close();
        } catch (Exception e) {
            System.out.println("Cant");
            e.printStackTrace();
        }

        return unique;

    }


    public void registerUser(User user, int accountType) {
        Connection connection = getConnection();
        try {
            String insertQuery = "INSERT INTO USERS(fname, lname, uname, password, houseNumber, isBuyer) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setInt(5, user.getHouseNumber());
            preparedStatement.setBoolean(6, accountType == 1);

            preparedStatement.execute();
            connection.close();

        } catch (Exception e) {

        }
    }

    public int getId(String username){
        Connection connection = getConnection();
        int id = 0;
        try{
            String idQuery = "SELECT * FROM USERS WHERE uname = '"+username+"'";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(idQuery);
            connection.close();
            while(rs.next()){
                id = rs.getInt("userId");
            }
        }catch (Exception e){
            System.out.println("ERROR WHILE GETTING ID");
            e.printStackTrace();
        }

        return id;
    }

    public boolean correctLogin(String username, String password) {
        Connection connection = getConnection();
        boolean login = false;
        try {
            String loginQuery = "SELECT * FROM USERS WHERE uname = '"+username+"' and password = '"+password+"' ";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(loginQuery);
            connection.close();
            if (rs.next()){
                login = true;
            }else{
                login = false;
            }

        }catch (Exception e){
            System.out.println("Error at login check");
        }
        return login;
    }

    public boolean isBuyer(String username){
        Connection connection = getConnection();
        boolean buyer = false;

        try{
            String typeQuery = "SELECT * FROM USERS WHERE uname = '"+username+"'";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(typeQuery);
            statement.close();
            connection.close();
            while (rs.next()){
                buyer = rs.getBoolean("isBuyer");
            }
        }catch (Exception e){
            System.out.println("Error while getting buyer or seller");
        }

        return buyer;

    }

}
