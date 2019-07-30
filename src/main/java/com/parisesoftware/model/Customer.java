package com.parisesoftware.model;

/*
 * @author Andrew Parise
 * Mar 4th 2016
 * Assignment 5.1
 * Programming II
 *
 * Customer.java
 *
 * Contains basic information for the customer object to be referenced in CusomerSimulation.java
 */
public class Customer implements Comparable<Customer> {

	public int timeLeft;
	public boolean canBeServed;

	public Customer(int timeLeft){
		this.timeLeft = timeLeft;
		canBeServed = false;
	}

	public int getTime(){
		return timeLeft;
	}

	public void minuteGoesBy(){
		timeLeft--;
		if(timeLeft <= 0){
			setCanBeServed(true);
		}
	}

	public void setCanBeServed(boolean bool){
		this.canBeServed = bool;
	}

	public boolean getCanBeServed(){
		return canBeServed;
	}

	@Override
	public int compareTo(Customer o) {
		return 0;
	}
}
