//imports
import java.util.concurrent.ThreadLocalRandom;

/*
 * @author Andrew Parise
 * Mar 4th 2016
 * Assignment 5.1
 * Programming II
 * 
 * CustomerSumulation.java
 * 
 * Class Overview:
 * Use the following algorithm to simulate a simple version of the new system:
 * 
	1. Choose a random integer between 1 and 5 to determine 
			the minutes at which a customer arrives.
			
	2. When a customer arrives, choose a random integer 
			between 1 and 5 to determine the number of 
			minutes that the customer must remain in the checkout line.
			
	3. Repeat the two steps for a 12 hour (720 minute) simulation.
	
	4. Run the simulation again with a random integer of 1 and 3 
			to compare the number of customers in the checkout line 
			against the original 12 hour simulation.
 * 
 */
public class CustomerSimulation {
	//init global vars
	public MyQueueClass line;
	public int numMinsRemaining;
	public int minsUntilNextCustomer;
	public int lineLength;
	
	//Set the Vars for how long until customer arrives/gets served
	public int minInt;
	public int maxInt;
	
	public CustomerSimulation(){ //default constructor
		line = new MyQueueClass(); //creates the queue
		numMinsRemaining = 720; //12 hours
		minsUntilNextCustomer = 0;
		lineLength = 0;
		minInt = 1;
		maxInt = 5;
	}
	public CustomerSimulation(int min, int max){
		line = new MyQueueClass(); //creates the queue
		numMinsRemaining = 720; //12 hours
		minsUntilNextCustomer = 0;
		lineLength = 0;
		this.minInt = min;
		this.maxInt = max;
	}
	
	
	public int randNum(int min, int max){
		//returns a random number between min and max
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}
	public void addCustomer(){
		Customer customer = new Customer(randNum(minInt,maxInt)); //create customer with random time left
		minsUntilNextCustomer = randNum(minInt, maxInt); //new time until next customer arrives
		line.insertElement(customer); //adds new customer to line queue
		lineLength++;
	}
	public int getLineLength(){
		return lineLength;
	}
	
	public void increment(){
		numMinsRemaining--; //decrease minutes by one
		minsUntilNextCustomer--; //decrease time until next customer arrives by one
		
		if(minsUntilNextCustomer <= 0){ //new customer has arrived
			addCustomer();
		}
		
		//Age customers by a minute
		for(int i = 0; i < getLineLength() - 1; i++){
			if(line.search(i) != null){
				Customer curCustomer = line.search(i).getCustomer();
				curCustomer.minuteGoesBy();	
			}
		}
		
		//check customers and serve closest to front of queue who has waited long enough to be served
		for(int i = 0; i < getLineLength() - 1; i++){
			if(line.search(i) != null){
				Customer curCustomer = line.search(i).getCustomer();
					
				if(curCustomer.getCanBeServed()){
					//Customer is ready to be served
					line.removeElement(i); //removes from queue
					lineLength--;
					break; //can only serve at most one customer per minute
				}
			}	
		}
		
		
	}
	public void simulationController(){
		//controls the flow of simulation
		while(numMinsRemaining >= 0){
			increment();
		}
		System.out.println("At the end of the 720 minute period, there are " + lineLength + " customers waiting in the line.");
		
	}
	
	
}
