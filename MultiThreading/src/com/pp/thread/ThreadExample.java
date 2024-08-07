package com.pp.thread;

class ThreadExample {
    public static void main(String[] args) {
        //Instantiate the subclass
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        // Start the first thread
        t1.start();
        // Start the second thread
        t2.start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getId() + " Index: " + i);
        }
    }
}

