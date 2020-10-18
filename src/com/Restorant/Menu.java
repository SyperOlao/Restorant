package com.Restorant;

import com.Restorant.Food.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Menu{
    private Map<String,Food> foodList = new TreeMap<>();

    public Menu(File file) {
        readMenu(file);
    }

    public void addFood(Food food){
        foodList.put(food.getName(),food);
    }
    public void removeFood(String name){
        foodList.remove(name);
    }

    public void showInfoForDish(Food food){
        System.out.println("Category of food: " + food.getCategory());
        System.out.println(food.getCategory() + " name: " + food.getName());
        System.out.println("Price for " + food.getName() + " is " + food.getCost() + " rub");
        System.out.println("Time for cooking: " + food.getCookingTime() + " min");
        System.out.println("Food's ingredients: " + food.getIngredients()+"\n");
    }

    public void showMenu(){
        for (int i = 0; i < foodList.size(); i++) {
            Object foodKey = foodList.keySet().toArray()[i];
            showInfoForDish(foodList.get(foodKey));
        }
    }

    public Food getDish(String name){
        return foodList.get(name);
    }

    private void readMenu(File file){
        Scanner scanner;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            return;
        }
        while (scanner.hasNext()){
            String type = scanner.nextLine();
            switch (type){
                case "Soup": addFood(new Soup(scanner.nextLine(),scanner.nextInt(),scanner.nextInt(),scanner.nextLine())); break;
                case "Salad": addFood(new Salad(scanner.nextLine(),scanner.nextInt(),scanner.nextInt(),scanner.nextLine())); break;
                case "Drink": addFood(new Drink(scanner.nextLine(),scanner.nextInt(),scanner.nextInt(),scanner.nextLine())); break;
                case "Snack": addFood(new Snack(scanner.nextLine(),scanner.nextInt(),scanner.nextInt(),scanner.nextLine())); break;
            }
        }
    }

    public boolean sales(LinkedList<Food> Order, Customer customer){
        boolean soup = false;
        boolean salad = false;
        for (int i = 0; i < Order.size(); i++) {
            if (Order.get(i).getCategory().equals("Soup")) soup = true;
            if (Order.get(i).getCategory().equals("Salad")) salad = true;
        }
        return  soup && salad;
    }
}
