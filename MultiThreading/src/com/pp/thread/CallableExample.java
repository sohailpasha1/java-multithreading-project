package com.pp.thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * <p>Callable is more versatile.
 * It allows tasks to return a result and handle exceptions,
 * making it ideal for tasks that perform computations or need to return result.
 * </p>
 */
public class CallableExample {

    public static void main(String[] args) {
        // List of laptops with their base prices
        List<Laptop> laptops = Arrays.asList(
                new Laptop("Laptop1", 1000),
                new Laptop("Laptop2", 1500),
                new Laptop("Laptop3", 2000)
        );

        // Create an ExecutorService with a fixed thread pool of 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Process each laptop and collect futures
        try {
            for (Laptop laptop : laptops) {
                // Create a Callable task to update the laptop's price
                Callable<String> task = () -> {
                    // updating the laptop's price 
                    double newPrice = laptop.getPrice() * 1.10;
                    laptop.setPrice(newPrice);
                    return laptop.getName() + " new price: " + newPrice;
                };

                // Submit the task to the executor
                Future<String> future = executor.submit(task);

                // Retrieve and print the result
                try {
                    String result = future.get();
                    System.out.println(result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } finally {
            // Shut down the executor service
            executor.shutdown();
        }
    }
}

// Class to represent a laptop
class Laptop {
    private String name;
    private double price;

    public Laptop(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}