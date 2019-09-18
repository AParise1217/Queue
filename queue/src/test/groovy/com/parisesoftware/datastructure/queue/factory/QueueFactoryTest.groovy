package com.parisesoftware.datastructure.queue.factory

import com.google.inject.Inject
import com.parisesoftware.datastructure.queue.StringQueueTestModule
import spock.guice.UseModules
import spock.lang.Specification

@UseModules(StringQueueTestModule)
class QueueFactoryTest extends Specification {

    @Inject
    IQueueFactory<String> queueFactory

    def "createQueue(): should return an empty IQueue"() {

        given: 'a QueueFactory instance'
        final IQueueFactory<String> testFactory = this.queueFactory

        when: "a Queue is instantiated, then queried for if it is Empty"
        final boolean resultant = testFactory.createQueue().isEmpty()

        then: "the resultant boolean is true"
        resultant
    }

}
