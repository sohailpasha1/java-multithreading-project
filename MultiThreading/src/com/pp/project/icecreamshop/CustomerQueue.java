package com.pp.project.icecreamshop;

import java.util.LinkedList;
import java.util.Queue;

public class CustomerQueue {
    private Queue<Customer> queue = new LinkedList<>();

    public synchronized void addCustomer(Customer customer) {
        queue.add(customer);
        notify();
    }

    public synchronized Customer getNextCustomer() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        return queue.poll();
    }
}
