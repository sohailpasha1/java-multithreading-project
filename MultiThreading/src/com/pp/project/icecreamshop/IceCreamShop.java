package com.pp.project.icecreamshop;

public class IceCreamShop {
    public static void main(String[] args) {
        IceCreamMachine machine = new IceCreamMachine();
        CustomerQueue customerQueue = new CustomerQueue();

        // Create and start multiple customer threads
        for (int i = 0; i < 30; i++) {
            Customer customer = new Customer(machine);
            // adding customer to the queue
            customerQueue.addCustomer(customer);
            //begin the execution to server ice cream
            customer.start();
        }

        // Restock flavors after some time (simulated as needed)
        new Thread(() -> {
            try {
                Thread.sleep(5000);
                machine.restockFlavor("Vanilla", 10);
                machine.restockFlavor("Chocolate", 10);
                machine.restockFlavor("Strawberry", 10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        // Print inventory at intervals
        new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(1000);
                    machine.printInventory();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }
}
