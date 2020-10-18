package com.Restorant.Food;

public class Salad extends Food {
    public Salad(String name, int cost, int cookingTime, String ingredients) {
        super(name, cost, cookingTime, ingredients);
        category = "Salad";
    }
}
