package com.parisesoftware.datastructure.queue.factory;

import com.parisesoftware.datastructure.queue.IQueue;

/**
 * Encapsulation of Creational Logic for {@link IQueue} instances
 *
 * @author <a href="mailto:andrewparise1994@gmail.com">Andrew Parise</a>
 * @version 1.0.4
 * @since 1.0.4
 */
public interface IQueueFactory<T extends Comparable<T>> {

    /**
     * Creates a new {@link IQueue} instance
     * @return {@code IQueue} that is empty
     */
    IQueue<T> createQueue();

}
