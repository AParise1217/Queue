package com.parisesoftware.model;

import org.jetbrains.annotations.Contract;

/**
 * Customer
 *
 * <p>Mar 4th 2016 Assignment 5.1 Programming II
 *
 * <p>Customer.java
 *
 * <p>Contains basic information for the customer object to be referenced in CustomerSimulation.java
 *
 * @author Andrew Parise
 * @version 1.0.0
 * @since 1.0.0
 */
public class Customer implements Comparable<Customer> {

  private int timeLeft;
  private boolean canBeServed;

  @Contract(pure = true)
  public Customer(int timeLeft) {
    this.timeLeft = timeLeft;
    canBeServed = false;
  }

  public int getTime() {
    return timeLeft;
  }

  public void minuteGoesBy() {
    timeLeft--;
    if (timeLeft <= 0) {
      this.canBeServed = true;
    }
  }

  public boolean getCanBeServed() {
    return canBeServed;
  }

  @Override
  public int compareTo(Customer o) {
    return 0;
  }
}
