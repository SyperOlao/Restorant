package com.Restorant.Food;

public class Soup extends Food {
    public Soup(String name, int cost, int cookingTime, String ingredients) {
        super(name, cost, cookingTime, ingredients);
        category = "Soup";
    }
}
