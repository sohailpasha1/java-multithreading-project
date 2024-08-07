package com.pp.thread;


public class VolatileExample {
    public static void main(String[] args) {
        AccountLockExample accountLock = new AccountLockExample();
        // Start a thread to acquire the lock
        new Thread(() -> {
            accountLock.acquireLock();
            System.out.println("Lock acquired.");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            accountLock.releaseLock();
            System.out.println("Lock released.");
        }).start();

        // Check the lock status from the main thread
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Lock status: " + (accountLock.isLocked() ? "Locked" : "Unlocked"));
    }
}

class AccountLockExample {
    private volatile boolean lock = false;

    public void acquireLock() {
        lock = true;
    }

    public void releaseLock() {
        lock = false;
    }

    public boolean isLocked() {
        return lock;
    }

}