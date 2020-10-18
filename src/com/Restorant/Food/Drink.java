package com.Restorant.Food;

public class Drink extends Food {
    public Drink(String name, int cost, int cookingTime, String ingredients) {
        super(name, cost, cookingTime, ingredients);
        category = "Drink";
        restrictions = "Only for 18+ persons";
    }
}
