package com.pp.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * <p>ExecutorService is a powerful tool in Java for managing and controlling thread execution.
 * It abstracts the complexities of thread creation and management,
 * offering a higher-level API for handling tasks.
 * </p>
 * <p>Callable is more versatile.
 * It allows tasks to return a result and handle exceptions,
 * making it ideal for tasks that perform computations or need to return result.</p>
 */
public class ExecutorServiceAndCallableDemo {
    public static void main(String[] args) {
        // Create an ExecutorService with a fixed thread pool of 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Create a list of Callable tasks
        List<Callable<String>> tasks = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            tasks.add(() -> {
                Thread.sleep(taskId * 1000);
                return "Result from task " + taskId;
            });
        }

        try {
            // Submit all tasks and get a list of Future objects
            List<Future<String>> results = executor.invokeAll(tasks);

            // Print results from each Future
            for (Future<String> future : results) {
                System.out.println(future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // Shut down the executor
        executor.shutdown();
    }
}