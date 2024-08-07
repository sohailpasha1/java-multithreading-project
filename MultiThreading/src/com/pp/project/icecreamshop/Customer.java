package com.pp.project.icecreamshop;

import java.util.Random;

public class Customer extends Thread {
    private IceCreamMachine machine;
    private String preferredFlavor;
    private static final String[] FLAVORS = {"Vanilla", "Chocolate", "Strawberry"};

    /**
     * Instantiating Customer with random ice cream selection
     * @param machine
     */
    public Customer(IceCreamMachine machine) {
        this.machine = machine;
        this.preferredFlavor = FLAVORS[new Random().nextInt(FLAVORS.length)];
    }

    @Override
    public void run() {
        // Serving the Ice cream while making sure serve access by single thread at a time.
        while (!machine.serveFlavor(preferredFlavor)) {
            try {
                // Wait and retry if the desired flavor is out of stock
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Customer interrupted.");
            }
        }
        System.out.println("Customer served flavor: " + preferredFlavor);
    }
}
