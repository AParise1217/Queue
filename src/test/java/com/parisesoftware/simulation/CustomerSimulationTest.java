package com.parisesoftware.simulation;

/**
 * Andrew Parise
 * <p>
 * Test Class for functionality of CustomerSimulation.java
 * <p>
 * Usage:
 * 1. create instance of CustomerSimulation() object
 * Default Constructor: min of 1, max of 5
 * Else (int param1, int param2): where param1 is the min, param2 is the max
 * <p>
 * 2. call .simulationController() on object
 */
public class CustomerSimulationTest {

    public static void main(String[] args) {

        System.out.println("Testing for a random number between 1 and 5 for the parameters: ");
        CustomerSimulation sim = new CustomerSimulation(); //Test with random number between 1 and 5
        sim.simulationController();
        System.out.println();
        System.out.println("Testing for a random number between 1 and 3 for the parameters: ");
        CustomerSimulation sim2 = new CustomerSimulation(1, 3); //Test with random number between 1 and 5
        sim2.simulationController();
    }

}
