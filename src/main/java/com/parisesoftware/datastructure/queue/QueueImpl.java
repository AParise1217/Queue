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

    /**
     * Pops the first element from the queue
     * @return {@code Node} that is first in the queue
     */
    public Node<T> removeElement() {
        if (!isEmpty()) {
            return this.linkedList.deleteHead();
        }
        return null;
    }

    /**
     * Fetch the first element of the queue without removing the element
     * @return {@code Node} that is first in the queue
     */
    public Node<T> viewFirst() {
        return this.linkedList.getHead();
    }

    /**
     * Fetch the last element of the queue without removing the element
     * @return {@code Node} that is the last in the queue
     */
    public Node<T> viewLast() {
        return this.linkedList.getTail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node search(int index) {
        return this.linkedList.search(index);
    }

    /**
     * Check if the queue is empty
     * @return {@code boolean}
     */
    public boolean isEmpty() {
        return this.linkedList.isEmpty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeElement(int index) {
        this.linkedList.removeNode(index);
    }

    /**
     * Fetch the number of elements in the Queue
     * @return {@code int} representation of the size of the queue
     */
    public int getSize() {
        // returns the number of elements in the queue
        return this.linkedList.getNumElements();
    }

    /**
     * Prints the contents of the queue to the console
     */
    public void displayContents() {
        System.out.println("Contents of Queue: ");
        System.out.println(this.linkedList.toString());
    }

}
