package com.parisesoftware.datastructure.queue.factory;

import com.google.inject.Inject;
import com.parisesoftware.datastructure.linkedlist.factory.ILinkedListFactory;
import com.parisesoftware.datastructure.queue.IQueue;
import com.parisesoftware.datastructure.queue.QueueImpl;

/**
 * Default implementation of {@link IQueueFactory}
 *
 * @author <a href="mailto:andrewparise1994@gmail.com">Andrew Parise</a>
 * @version 1.0.4
 * @since 1.0.4
 */
public class QueueFactory<T extends Comparable<T>> implements IQueueFactory<T> {

    private final ILinkedListFactory<T> linkedListFactory;

    @Inject
    public QueueFactory(ILinkedListFactory<T> linkedListFactory) {
        this.linkedListFactory = linkedListFactory;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IQueue<T> createQueue() {
        return new QueueImpl<>(this.linkedListFactory);
    }

}
