package com.parisesoftware.datastructure.queue;

import com.parisesoftware.model.INode;

import java.util.Optional;

/**
 * Queue Abstraction
 *
 * @author <a href="mailto:andrewparise1994@gmail.com">Andrew Parise</a>
 * @version 1.0.4
 * @since 1.0.1
 */
public interface IQueue<T extends Comparable<T>> {

    /**
     * Search for an element in the queue at the given index
     *
     * @param index to search for the {@link INode} at
     * @return {@code Optional} {@link INode} at the given index
     */
    Optional<INode<T>> search(int index);

    /**
     * Inserts the element into the queue
     *
     * @param info {@code T} the data to be inserted
     */
    void insertElement(T info);

    /**
     * Pops the first element from the queue. Returns {@code null} if the Queue is empty
     *
     * @return {@code Optional} {@link INode} that is first in the queue
     */
    Optional<INode<T>> removeElement();

    /**
     * Removes the element at the given index
     *
     * @param index to remove the node at
     */
    void removeElement(int index);

    /**
     * Fetch the first element of the queue without removing the element
     *
     * @return {@code Optional} {@link INode} that is first in the queue
     */
    Optional<INode<T>> viewFirst();

    /**
     * Fetch the last element of the queue without removing the element
     *
     * @return {@code Optional} {@link INode} that is the last in the queue
     */
    Optional<INode<T>> viewLast();

    /**
     * Check if the queue is empty
     *
     * @return {@code boolean}
     */
    boolean isEmpty();

    /**
     * Fetch the number of elements in the Queue
     *
     * @return {@code int} representation of the size of the queue
     */
    int getSize();

}
