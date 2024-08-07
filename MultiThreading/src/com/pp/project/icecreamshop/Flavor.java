package com.pp.project.icecreamshop;

public class Flavor {
    private String name;
    private int quantity;

    public Flavor(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    /**
     * serving the ice cream
     *
     * @return if serve true
     */
    public synchronized boolean serve() {
        if (quantity > 0) {
            quantity--;
            return true;
        }
        return false;
    }

    /**
     * restocking the quantity
     *
     * @param amount
     */
    public synchronized void restock(int amount) {
        quantity += amount;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
