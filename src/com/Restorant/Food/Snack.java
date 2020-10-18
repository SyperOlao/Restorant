package com.Restorant.Food;

public class Snack extends Food {
    public Snack(String name, int cost, int cookingTime, String ingredients) {
        super(name, cost, cookingTime, ingredients);
        category = "Snack";
    }
}

