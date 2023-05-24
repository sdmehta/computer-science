package com.demo.semesterIII.assignment3.resources.src;

import java.util.Arrays;
import java.util.LinkedList;

public class MyPizza implements  Pizza{
    LinkedList<String> toppings;

    public MyPizza() {
        this.toppings = new LinkedList<>();
    }

    public MyPizza(String[] toppingsArray) {
        for (String topping : toppingsArray) {
            if (topping == null || "".equals(topping)) {
                throw new MyPizzaException("Topping must not be empty.");
            }

            if (!this.toppings.contains(topping)) {
                this.toppings.add(topping);
            }
        }
    }

    // this - pepperoni, ham,
    // other - ham, cherries, bacon
    @Override
    public Pizza combine(Pizza other) {
        // get other toppings
        LinkedList<String> otherToppings = new LinkedList<>(Arrays.asList(other.getAllToppings()));

        // combine this.toppings and otherToppings into single collection(LinkedList or Array)

        return new MyPizza();
    }

    @Override
    public Pizza consolidate(Pizza other) {
        return null;
    }

    @Override
    public Pizza exclude(Pizza other) {
        return null;
    }

    @Override
    public boolean covers(Pizza other) {
        return false;
    }

    @Override
    public boolean isCovered(Pizza other) {
        return false;
    }

    @Override
    public boolean equals(Pizza other) {
        return false;
    }

    @Override
    public void add(String topping) {

    }

    @Override
    public void remove(String topping) {

    }

    @Override
    public boolean contains(String topping) {
        return false;
    }

    @Override
    public String[] getAllToppings() {
        return (String[])toppings.toArray();
    }
}
