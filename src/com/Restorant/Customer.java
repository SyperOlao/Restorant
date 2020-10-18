package com.Restorant;

import com.Restorant.Food.Food;

import java.util.LinkedList;

public class Customer {
    private int stayTime;
    private int amountOfMoney;
    private int age;
    private String wishes;
    private Menu menu;

    private LinkedList<Food> Order = new LinkedList<>();

    public Customer(Menu menu) { this.menu = menu; }


    public void makeAnOrder(String name){
        if (amountOfMoney > menu.getDish(name).getCost() && stayTime > menu.getDish(name).getCookingTime()){
            if(menu.getDish(name).getCategory() == "Drink") {
                if (age < 18) return;
            }
            amountOfMoney = amountOfMoney - menu.getDish(name).getCost();
            Order.add(menu.getDish(name));
        }
    }

    public LinkedList<Food> getOrder() {
        return Order;
    }

    public void RemoveAnOrder(int index){ Order.remove(index); }

    public Food getOrder(int index){ return Order.get(index); }

    public int getStayTime() {
        return stayTime;
    }

    public int getAmountOfMoney() {
        return amountOfMoney;
    }

    public String getWishes() {
        return wishes;
    }

    public int getOrderSize(){
        return Order.size();
    }

    public void setFreeTime(int freeTime) {
        if (freeTime > 0) {
            this.stayTime = freeTime;
        }
    }

    public void setAmountOfMoney(int amountOfMoney) {
        if (amountOfMoney > 0) {
            this.amountOfMoney = amountOfMoney;
        }
    }

    public int getAge() { return age; }

    public void setAge(int age) {
        if (age > 0 && age < 120) {
            this.age = age;
        }
    }

    public void setWishes(String wishes) { this.wishes = wishes; }

}
