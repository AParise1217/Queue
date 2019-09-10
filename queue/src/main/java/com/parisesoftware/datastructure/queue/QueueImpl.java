package com.parisesoftware.datastructure.queue;

import com.parisesoftware.datastructure.linkedlist.ILinkedList;
import com.parisesoftware.datastructure.linkedlist.LinkedListImpl;
import com.parisesoftware.model.INode;

/**
 * Default implementation of {@link IQueue}
 *
 * @author <a href="mailto:andrewparise1994@gmail.com">Andrew Parise</a>
 * @version 1.0.3
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
     * {@inheritDoc}
     */
    @Override
    public INode<T> removeElement() {
        if (isEmpty()) {
            return null;
        }

        return this.linkedList.deleteHead();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public INode<T> viewFirst() {
        return this.linkedList.getHead();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public INode<T> viewLast() {
        return this.linkedList.getTail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public INode<T> search(int index) {
        return this.linkedList.search(index);
    }

    /**
     * {@inheritDoc}
     */
    @Override
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
     * {@inheritDoc}
     */
    @Override
    public int getSize() {
        return this.linkedList.getSize();
    }

    /**
     * Prints the contents of the queue to the console
     */
    public void displayContents() {
        System.out.println("Contents of Queue: ");
        System.out.println(this.linkedList.toString());
    }

}
