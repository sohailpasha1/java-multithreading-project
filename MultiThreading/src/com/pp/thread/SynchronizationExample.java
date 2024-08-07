package com.pp.thread;

/**
 * <p>synchronized keyword is used to create a critical section that allows
 * only one thread to execute a block of code at a time.
 * This prevents data corruption and inconsistent results when multiple threads
 * are trying to read or write shared data and Keeping Things in Order
 * </p>
 */
public class SynchronizationExample {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        // Create threads to deposit and withdraw money
        new Thread(() -> account.deposit(100)).start();
        new Thread(() -> account.withdraw(50)).start();
        new Thread(() -> account.deposit(200)).start();

        // Allow some time for threads to finish
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Balance: " + account.getBalance());
    }
}

class BankAccount {
    private int balance = 0;

    public synchronized void deposit(int amount) {
        System.out.println("Deposit Amount: " + amount);
        balance += amount;
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            System.out.println("Withdraw Amount: " + amount);
            balance -= amount;
        } else {
            System.out.println("Insufficient Amount...");
        }
    }

    public synchronized int getBalance() {
        return balance;
    }
}
