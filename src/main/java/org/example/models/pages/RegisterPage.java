package org.example.models.pages;

import org.example.models.database.Database_Users;
import org.example.models.users.User;

import java.util.Scanner;

public class RegisterPage {
    Scanner scanner;

    public RegisterPage(Scanner scanner) {
        this.scanner = scanner;
    }

    public void generateRegisterPage() {
        Database_Users databaseUsers = new Database_Users();

        System.out.println("Register Page");
        System.out.println("Enter first name: ");
        String fname = this.scanner.next();
        System.out.println("Enter last name: ");
        String lname = this.scanner.next();

        boolean usernameSelected = false;
        String uname = "";
        while (!usernameSelected) {
            System.out.println("Enter username : ");
            uname = this.scanner.next();

            boolean isUnique = databaseUsers.isUniqueUsername(uname); //add
            if (!isUnique) {
                System.out.println("This username is already taken, please select another one");
            } else {
                usernameSelected = true;
            }
        }

        System.out.println("Enter password: ");
        String password = scanner.next();

        System.out.println("Enter your house number: ");
        int houseNumber = scanner.nextInt();

        boolean accountTypeSelected = false;
        System.out.println("Enter your account type: ");
        int accountType = 0;

        while (!accountTypeSelected) {
            System.out.println("1. Buyer");
            System.out.println("2. Seller");
            accountType = scanner.nextInt();

            if (accountType == 1 || accountType == 2) {
                accountTypeSelected = true;
            }
        }

        User user = new User(uname, password, fname, lname, houseNumber);

        databaseUsers.registerUser(user, accountType);

        System.out.println("You are registered Successfully");

    }

}
