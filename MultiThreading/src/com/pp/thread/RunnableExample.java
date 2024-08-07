package com.pp.thread;

/**
 * <p>A thread is a lightweight unit of execution within a process.
 * Multiple threads can run concurrently, sharing the same memory space,
 * which enables them to perform tasks simultaneously and efficiently.</p>
 */
public class RunnableExample {
    public static void main(String[] args) {
        Runnable runnable1 = new MyRunnable();
        Runnable runnable2 = new MyRunnable();
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        // Start the first thread
        thread1.start();
        // Start the second thread
        thread2.start();
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getId() + " Index: " + i);
        }
    }
}