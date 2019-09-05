package com.parisesoftware.datastructure.queue;

import com.parisesoftware.model.Node;

/**
 * Andrew Parise
 * <p>
 * Mar 4th 2016
 * <p>
 * Test class to make sure that {@link QueueImpl} functionality is working
 */
public class MyQueueClassTest {

    public static void main(String[] args) {
        QueueImpl q = new QueueImpl();

        //Testing .isEmpty()
        if (q.isEmpty()) {
            System.out.println("The Queue is currently empty");
        }

        //Testing .insertElement()
        q.insertElement("Jimmy");
        if (!q.isEmpty()) {
            System.out.println("The Queue is currently not empty");
        }
        q.displayContents();

        q.insertElement("Empty");
        q.insertElement("Rain");
        q.insertElement("Blue");

        q.displayContents();

        //Testing .removeElement()
        q.removeElement();
        q.displayContents();

        //Testing .getSize()
        System.out.println("There are currently " + q.getSize() + " elements in the queue");

        //Testing .viewFirst()
        Node firstNode = q.viewFirst();
        System.out.println("The first node is: " + firstNode.getData());

        //Testing .viewLast()
        Node lastNode = q.viewLast();
        System.out.println("The last node is: " + lastNode.getData());

        //Testing to make sure it did not remove node
        q.displayContents();


        //More Tests just to be sure
        q.insertElement("Morning");
        q.displayContents();
        firstNode = q.viewFirst();
        System.out.println("The first node is: " + firstNode.getData());
        lastNode = q.viewLast();
        System.out.println("The last node is: " + lastNode.getData());
        q.removeElement();
        q.displayContents();
        q.insertElement("Nothing");
        q.displayContents();
        firstNode = q.viewFirst();
        System.out.println("The first node is: " + firstNode.getData());
        lastNode = q.viewLast();
        System.out.println("The last node is: " + lastNode.getData());
        System.out.println("Thre are currently " + q.getSize() + " elements in the queue");

        //Testing .search()
        System.out.println("The second node is: " + q.search(1).getData());

    }

}
