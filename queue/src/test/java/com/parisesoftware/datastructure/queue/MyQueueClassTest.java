package com.parisesoftware.datastructure.queue;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import com.parisesoftware.datastructure.queue.factory.IQueueFactory;

/**
 * Example Usage of the Queue Data Structure
 */
public class MyQueueClassTest {

    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new StringQueueTestModule());

        IQueueFactory<String> queueFactory = injector.getInstance(Key.get(new TypeLiteral<IQueueFactory<String>>() {}));

        // unbox from abstraction
        QueueImpl<String> q = (QueueImpl<String>) queueFactory.createQueue();

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
        q.viewFirst().ifPresent(stringINode -> System.out.println("The first node is: " + stringINode.getData()));

        //Testing .viewLast()
        q.viewLast().ifPresent(stringINode -> System.out.println("The last node is: " + stringINode.getData()));

        //Testing to make sure it did not remove node
        q.displayContents();

        //More Tests just to be sure
        q.insertElement("Morning");
        q.displayContents();

        q.viewFirst().ifPresent(stringINode -> System.out.println("The first node is: " + stringINode.getData()));

        q.viewLast().ifPresent(stringINode -> System.out.println("The last node is: " + stringINode.getData()));

        q.removeElement();

        q.displayContents();
        q.insertElement("Nothing");

        q.displayContents();
        q.viewFirst().ifPresent(stringINode -> System.out.println("The first node is: " + stringINode.getData()));

        q.viewLast().ifPresent(stringINode -> System.out.println("The last node is: " + stringINode.getData()));

        System.out.println("Thre are currently " + q.getSize() + " elements in the queue");

        //Testing .search()
        q.search(1).ifPresent(stringINode -> System.out.println("The second node is: " + stringINode.getData()));

    }

}
