package com.parisesoftware.datastructure.queue;

import com.parisesoftware.model.Node;

/**
 * Queue Abstraction
 * <p>
 *     Core abstraction for a Queue Data Structure
 * </p>
 *
 * @version 1.0.1
 * @since 1.0.1
 */
public interface IQueue<T extends Comparable> {

    void removeElement(int index);

    Node search(int index);

    void insertElement(T info);

}
