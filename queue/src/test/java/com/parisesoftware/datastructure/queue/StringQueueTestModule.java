package com.parisesoftware.datastructure.queue;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.parisesoftware.datastructure.linkedlist.factory.ILinkedListFactory;
import com.parisesoftware.datastructure.linkedlist.factory.LinkedListFactory;
import com.parisesoftware.datastructure.queue.factory.IQueueFactory;
import com.parisesoftware.datastructure.queue.factory.QueueFactory;
import com.parisesoftware.model.factory.INodeFactory;
import com.parisesoftware.model.factory.NodeFactory;

/**
 * Guice Dependency Injection Module Configuration
 */
public class StringQueueTestModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(new TypeLiteral<INodeFactory<String>>() {})
                .to(new TypeLiteral<NodeFactory<String>>() {});

        bind(new TypeLiteral<ILinkedListFactory<String>>() {})
                .to(new TypeLiteral<LinkedListFactory<String>>() {});

        bind(new TypeLiteral<IQueueFactory<String>>() {})
                .to(new TypeLiteral<QueueFactory<String>>() {});

    }

}
