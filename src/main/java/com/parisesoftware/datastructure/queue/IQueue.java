package com.parisesoftware.datastructure.queue;

import com.parisesoftware.model.Node;

/**
 * Queue Abstraction
 *
 * @author <a href="mailto:andrewparise1994@gmail.com">Andrew Parise</a>
 * @version 1.0.1
 * @since 1.0.1
 */
public interface IQueue<T extends Comparable> {

    /**
     * Removes the element at the given index
     *
     * @param index to remove the node at
     */
    void removeElement(int index);

    /**
     * Search for an element in the queue at the given index
     *
     * @param index to search for the {@link Node} at
     * @return {@code Node} at the given index
     */
    Node search(int index);

    /**
     * Inserts the element into the queue
     */
    void insertElement(T info);

}
