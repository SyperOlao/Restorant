package com.Restorant;

import com.Restorant.Food.Food;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String []args){
        Menu menu = new Menu(new File("src/menu2.txt"));
        System.out.println("Menu list:");
        menu.showMenu();
        Customer customer = new Customer(menu);
        updateInformationFromTXT(new File("src/customer.txt"), customer);
        System.out.println("Make an order, if you buy a combo with a soup + salad you will have 10% discount");
        userOrder(customer, menu);
        System.out.println("Your order:");
        showInfoForOrder(customer, menu);
        System.out.println("Your final balance is: " + customer.getAmountOfMoney());
    }

    public static void showInfoForOrder (Customer customer, Menu menu){
        for (int i = 0; i <customer.getOrderSize() ; i++) {
            menu.showInfoForDish(customer.getOrder(i));
        }
    }


    public static Customer userOrder(Customer customer, Menu menu){
        String userChoice = " ";
        if (customer.getAge() < 18){
            System.out.println("We can't sell drinks for you!");
        }
        while (!userChoice.equals("stop")){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Select name of dish:");
            userChoice = scanner.nextLine();
            try {
                customer.makeAnOrder(userChoice);
            } catch (Exception е){
                if (!userChoice.equals("stop")) {
                    System.out.println("You can't buy this");
                }
            }
            System.out.println("Your balance is: " + customer.getAmountOfMoney());
        }
        int spentMoney = 0;
        for (int i = 0; i <customer.getOrderSize(); i++) {
            spentMoney += customer.getOrder(i).getCost();
        }
        if(menu.sales(customer.getOrder(), customer)) customer.setAmountOfMoney(customer.getAmountOfMoney() + spentMoney/10);

        return customer = new Customer(menu);

    }

    public static void updateInformation(Customer customer){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your stay time: ");
        customer.setFreeTime(scanner.nextInt());
        System.out.println("Enter your amount of money: ");
        customer.setAmountOfMoney(scanner.nextInt());
        System.out.println("Enter your age: ");
        customer.setAge(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Enter wishes: ");
        customer.setWishes(scanner.nextLine());
    }
    public  static void updateInformationFromTXT(File file, Customer customer){
        Scanner scanner;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            return;
        }
        customer.setFreeTime(scanner.nextInt());
        customer.setAmountOfMoney(scanner.nextInt());
        customer.setAge(scanner.nextInt());
        scanner.nextLine();
        customer.setWishes(scanner.nextLine());
    }
}
