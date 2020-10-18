package com.Restorant.Food;

public abstract class Food implements Dish {
    protected String category;
    protected String name;
    protected int cost;
    protected int cookingTime;
    protected String restrictions;
    protected String ingredients;
    protected static int amountOfFood = 0;

    public Food(String name, int cost, int cookingTime, String ingredients) {
        this.name = name;
        this.cost = cost;
        this.cookingTime = cookingTime;
        this.ingredients = ingredients;
        amountOfFood++;
    }

    public String getIngredients() { return ingredients; }

    public void setIngredients(String ingredients) { ingredients = ingredients; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    public String getCategory() {
        return category;
    }

    public String getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(String restrictions) {
        this.restrictions = restrictions;
    }

}
