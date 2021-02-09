package edu.zinedine.td3_2;

import java.util.ArrayList;

public class PizzaList extends ArrayList<Pizza> {
    public PizzaList(){
        add(new Pizza("Cream & Champi", 5, R.drawable.pizza1));
        add(new Pizza("Spicy Chorizzo", 9, R.drawable.pizza2));
        add(new Pizza("Meat fiesta", 9.5, R.drawable.pizza3));
        add(new Pizza("Calzone", 4.5, R.drawable.pizza4));
        add(new Pizza("Specialita", 9, R.drawable.pizza5));
        add(new Pizza("Soft Lam", 9, R.drawable.pizza6));

    }
}
