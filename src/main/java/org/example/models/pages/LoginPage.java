package org.example.models.pages;

import org.example.models.database.Database_Users;

import java.util.Scanner;

public class LoginPage {
    Scanner scanner;
    public LoginPage(Scanner scanner){
        this.scanner = scanner;
    }

    BuyerPage buyerPage = new BuyerPage();
    SellerPage sellerPage = new SellerPage();


    Database_Users databaseUsers = new Database_Users();

    public void generateLoginPage(){
        System.out.println("Enter username: ");
        String username = scanner.next();
        System.out.println("Enter password: ");
        String password = scanner.next();
        boolean logged = databaseUsers.correctLogin(username, password);
        if(logged){
            int userId = databaseUsers.getId(username);

            if ( databaseUsers.isBuyer(username) ){
                //buyer
                buyerPage.generateBuyerPage(userId);
            }else{
                //seller
                sellerPage.generateSellerPage(userId);
            }

        }else{

        }

    }
}
