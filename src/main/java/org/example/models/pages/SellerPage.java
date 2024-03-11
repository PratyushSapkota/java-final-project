package org.example.models.pages;

import org.example.models.database.Database_Seller;
import org.example.models.item.Item;

import java.util.Scanner;

public class SellerPage {

    Scanner scanner = new Scanner(System.in);

    Database_Seller databaseSeller = new Database_Seller();

    public void generateSellerPage(int userId) {
        System.out.println("Seller Page");

        while (true) {
            System.out.println("1. List a new item");
            System.out.println("2. See listed items");
            System.out.println("3. See sold items");
            System.out.println("4. Logout");

            int selection = scanner.nextInt();

            if (selection == 1) {
                // list
                System.out.println("Enter the product name: ");
                String name = scanner.next();
                System.out.println("Enter the product price: ");
                double price = scanner.nextDouble();
                String sellerName = databaseSeller.getSellerName(userId);
                Item item = new Item(name, price, sellerName);

                databaseSeller.addItem(item, userId);

            } else if (selection == 2) {
                // view listed

            } else if (selection == 3) {
                // view sold items

            } else if (selection == 4) {
                //logout
                break;

            } else {
                System.out.println("Enter a valid option");
            }
        }
    }

}
