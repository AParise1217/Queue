package com.parisesoftware.datastructure.queue;

import com.parisesoftware.datastructure.linkedlist.ILinkedList;
import com.parisesoftware.datastructure.linkedlist.LinkedListImpl;
import com.parisesoftware.model.Node;

/**
 * Default implementation of {@link IQueue}
 *
 * @author <a href="mailto:andrewparise1994@gmail.com">Andrew Parise</a>
 * @version 1.0.1
 * @since 1.0.0
 */
public class QueueImpl<T extends Comparable<T>> implements IQueue<T> {

    private ILinkedList<T> linkedList;

    public QueueImpl() {
        // default constructor
        this.linkedList = new LinkedListImpl<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void insertElement(T info) {
        this.linkedList.insertEnd(info);
    }

    public Node<T> removeElement() { // "remove elements from the queue"
        if (!isEmpty()) { // if queue is not empty
            return this.linkedList.deleteHead(); // removes first node and returns it
        }
        return null;
    }

    public Node<T> viewFirst() { // "look at the first element of the queue without removing the element"
        // peek first element
        return this.linkedList.getHead();
    }

    public Node<T> viewLast() { // "look at the last element of the queue without removing the element"
        // peek last element
        return this.linkedList.getTail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node search(int index) { // "search for an element in the queue"
        return this.linkedList.search(index);
    }

    public boolean isEmpty() { // checks if queue is empty
        return this.linkedList.isEmpty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeElement(int index) {
        this.linkedList.removeNode(index);
    }

    public int getSize() {
        // returns the number of elements in the queue
        return this.linkedList.getNumElements();
    }

    public void displayContents() { // prints contents to console
        System.out.println("Contents of Queue: ");
        System.out.println(this.linkedList.toString());
    }
}
