package com.parisesoftware.datastructure;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.parisesoftware.datastructure.linkedlist.factory.ILinkedListFactory;
import com.parisesoftware.datastructure.linkedlist.factory.LinkedListFactory;
import com.parisesoftware.datastructure.model.Customer;
import com.parisesoftware.datastructure.queue.factory.IQueueFactory;
import com.parisesoftware.datastructure.queue.factory.QueueFactory;
import com.parisesoftware.model.factory.INodeFactory;
import com.parisesoftware.model.factory.NodeFactory;

/**
 * Guice Dependency Injection Module Configuration
 */
public class CustomerSimulationModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(new TypeLiteral<INodeFactory<Customer>>() {})
                .to(new TypeLiteral<NodeFactory<Customer>>() {});

        bind(new TypeLiteral<ILinkedListFactory<Customer>>() {})
                .to(new TypeLiteral<LinkedListFactory<Customer>>() {});

        bind(new TypeLiteral<IQueueFactory<Customer>>() {})
                .to(new TypeLiteral<QueueFactory<Customer>>() {});

    }

}
