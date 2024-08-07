package com.pp.thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>ExecutorService is a powerful tool in Java for managing and controlling thread execution.
 * It abstracts the complexities of thread creation and management,
 * offering a higher-level API for handling tasks.
 * </p>
 */
public class ExecutionServiceExample {

    public static void main(String[] args) {
        // List of laptops
        List<String> laptops = Arrays.asList("Laptop1", "Laptop2", "Laptop3", "Laptop4", "Laptop5");

        // Create an ExecutorService with a fixed thread pool of 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit tasks to process each laptop
        for (String laptop : laptops) {
            Runnable task = () -> processLaptop(laptop);
            executor.submit(task);
        }

        // Shut down the executor service
        executor.shutdown();
    }

    // processing a laptop
    private static void processLaptop(String laptop) {
        try {
            // Simulate processing time
            Thread.sleep(1000);
            System.out.println(laptop + " processed successfully on " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Processing of " + laptop + " was interrupted.");
        }
    }
}