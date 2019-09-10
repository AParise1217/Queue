package com.parisesoftware.datastructure.simulation;

import com.parisesoftware.datastructure.model.Customer;
import com.parisesoftware.datastructure.queue.IQueue;
import com.parisesoftware.datastructure.queue.QueueImpl;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Customer Simulation
 *
 * <p>Class Overview: Use the following algorithm to simulate a simple version of the new
 * system:
 * <p>1. Choose a random integer between 1 and 5 to determine the minutes at which a customer
 * arrives.
 * <p>2. When a customer arrives, choose a random integer between 1 and 5 to determine the
 * number of minutes that the customer must remain in the checkout line.
 * <p>3. Repeat the two steps for a 12 hour (720 minute) simulation.
 * <p>4. Run the simulation again with a random integer of 1 and 3 to compare the number of
 * customers in the checkout line against the original 12 hour simulation.
 *
 * @author <a href="mailto:andrewparise1994@gmail.com">Andrew Parise</a>
 * @version 1.0.1
 * @since 1.0.0
 */
public class CustomerSimulation {

    private IQueue<Customer> line;

    private int numMinsRemaining;

    private int minsUntilNextCustomer;

    private int lineLength;

    // Set the Vars for how long until customer arrives/gets served
    private int minInt;

    private int maxInt;

    public CustomerSimulation() { // default constructor
        this.line = new QueueImpl<>(); // creates the queue
        this.numMinsRemaining = 720; // 12 hours
        this.minsUntilNextCustomer = 0;
        this.lineLength = 0;
        this.minInt = 1;
        this.maxInt = 5;
    }

    public CustomerSimulation(int min, int max) {
        this.line = new QueueImpl<>(); // creates the queue
        this.numMinsRemaining = 720; // 12 hours
        this.minsUntilNextCustomer = 0;
        this.lineLength = 0;
        this.minInt = min;
        this.maxInt = max;
    }

    public int randNum(int min, int max) {
        // returns a random number between min and max
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public void addCustomer() {
        Customer customer = createCustomerWithRandomTimeLeft();
        this.minsUntilNextCustomer = randNum(minInt, maxInt); // new time until next customer arrives
        this.line.insertElement(customer); // adds new customer to line queue
        this.lineLength++;
    }

    /**
     * Factory Method to handle instantiating a new {@link Customer} with a random time left
     *
     * @return {@code Customer} with a random time left
     */
    private Customer createCustomerWithRandomTimeLeft() {
        return new Customer(randNum(this.minInt, this.maxInt));
    }

    public int getLineLength() {
        return this.lineLength;
    }

    /**
     * Check if a New Customer has arrived
     *
     * @return {@code boolean} true if so, false if not
     */
    private boolean hasNewCustomerArrived() {
        return this.minsUntilNextCustomer <= 0;
    }

    /**
     * Check if a new Customer has arrived; if so, adds them to the line
     */
    private void addCustomerIfNewCustomerHasArrived() {
        if (hasNewCustomerArrived()) {
            addCustomer();
        }
    }

    public void increment() {
        this.numMinsRemaining--; // decrease minutes by one
        this.minsUntilNextCustomer--; // decrease time until next customer arrives by one

        addCustomerIfNewCustomerHasArrived();

        // Age customers by a minute
        for (int i = 0; i < getLineLength() - 1; i++) {
            if (line.search(i) != null) {
                Customer curCustomer = line.search(i).getData();
                curCustomer.minuteGoesBy();
            }
        }

        // check customers and serve closest to front of queue who has waited long enough to be served
        for (int i = 0; i < getLineLength() - 1; i++) {
            if (this.line.search(i) != null) {
                Customer curCustomer = this.line.search(i).getData();

                if (curCustomer.getCanBeServed()) {
                    // Customer is ready to be served
                    this.line.removeElement(i); // removes from queue
                    this.lineLength--;
                    break; // can only serve at most one customer per minute
                }
            }
        }
    }

    public void simulationController() {
        // controls the flow of simulation
        while (this.numMinsRemaining >= 0) {
            increment();
        }
        System.out.println(
                "At the end of the 720 minute period, there are "
                        + this.lineLength
                        + " customers waiting in the line.");
    }
}
