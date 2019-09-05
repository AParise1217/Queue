package com.parisesoftware.model;


/**
 * Model for customer related data
 *
 * @author <a href="mailto:andrewparise1994@gmail.com">Andrew Parise</a>
 * @version 1.0.1
 * @since 1.0.0
 */
public class Customer implements Comparable<Customer> {

    private int timeLeft;
    private boolean canBeServed;

    public Customer(int timeLeft) {
        this.timeLeft = timeLeft;
        this.canBeServed = false;
    }

    public int getTime() {
        return this.timeLeft;
    }

    public void minuteGoesBy() {
        this.timeLeft--;
        if (this.timeLeft <= 0) {
            this.canBeServed = true;
        }
    }

    public boolean getCanBeServed() {
        return this.canBeServed;
    }

    @Override
    public int compareTo(Customer o) {
        return 0;
    }

}
