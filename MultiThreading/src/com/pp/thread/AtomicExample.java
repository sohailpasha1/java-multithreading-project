package com.pp.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {
    public static void main(String[] args) {
        TransactionCounter counter = new TransactionCounter();
        // Start threads to increment the transaction count
        for (int i = 0; i < 10; i++) {
            new Thread(counter::incrementTransaction).start();
        }
        // Allow some time for threads to finish
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Total Transactions: " + counter.getTransactionCount());
    }
}

class TransactionCounter {
    private final AtomicInteger transactionCount = new AtomicInteger(0);

    public void incrementTransaction() {
        // Atomically increment the transaction count
        transactionCount.incrementAndGet();
    }

    public int getTransactionCount() {
        // Atomically get the current count
        return transactionCount.get();
    }
}
