package com.pp.project.icecreamshop;

import java.util.HashMap;
import java.util.Map;

public class IceCreamMachine {
    private final Map<String, Flavor> flavors = new HashMap<>();

    /**
     * Adding Flavors and quantity
     */
    public IceCreamMachine() {
        flavors.put("Vanilla", new Flavor("Vanilla", 10));
        flavors.put("Chocolate", new Flavor("Chocolate", 10));
        flavors.put("Strawberry", new Flavor("Strawberry", 10));
    }

    /**
     * Serving the Ice cream,
     * synchronized the server flavor allowing single thread to access at a time.
     *
     * @param flavorName
     * @return
     */
    public synchronized boolean serveFlavor(String flavorName) {
        Flavor flavor = flavors.get(flavorName);
        if (flavor != null) {
            return flavor.serve();
        }
        return false;
    }

    /**
     * restockFlavors the quantity
     *
     * @param flavorName
     * @param amount
     */
    public synchronized void restockFlavor(String flavorName, int amount) {
        Flavor flavor = flavors.get(flavorName);
        if (flavor != null) {
            flavor.restock(amount);
        }
    }

    /**
     * Displaying the Current Inventory
     */
    public void printInventory() {
        System.out.println("Current Inventory:");
        for (Flavor flavor : flavors.values()) {
            System.out.println(flavor.getName() + ": " + flavor.getQuantity());
        }
    }
}
