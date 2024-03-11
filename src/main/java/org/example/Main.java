package org.example;

import org.example.models.pages.LoginPage;
import org.example.models.pages.RegisterPage;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LoginPage loginPage = new LoginPage(scanner);
        RegisterPage registerPage = new RegisterPage(scanner);

        boolean redirected  = false;

        while(!redirected){
            System.out.println("Select an action:");
            System.out.println("1. Login");
            System.out.println("2. Register");
            int loginActionSelection = scanner.nextInt();

            if (loginActionSelection == 1) {
                redirected = true;
                loginPage.generateLoginPage();
            } else if (loginActionSelection == 2) {
                registerPage.generateRegisterPage();
            } else {
                System.out.println("Enter a valid option");
            }
        }


    }
}