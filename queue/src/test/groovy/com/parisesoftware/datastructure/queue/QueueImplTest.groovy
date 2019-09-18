package com.parisesoftware.datastructure.queue

import com.google.inject.Inject
import com.parisesoftware.datastructure.queue.factory.IQueueFactory
import com.parisesoftware.model.INode
import spock.guice.UseModules
import spock.lang.Specification

@UseModules(StringQueueTestModule)
class QueueImplTest extends Specification {

    @Inject
    IQueueFactory<String> queueFactory

    QueueImpl getQueue() {
        return this.queueFactory.createQueue() as QueueImpl
    }

    def "isEmpty(): should return true immediately following construction"() {

        when: "the Queue is queried for if it is Empty"
        final boolean resultant = getQueue().isEmpty()

        then: "the resultant boolean is true"
        resultant
    }

    def "removeElement(): should return a not present Optional when the Queue is empty"() {

        given: 'a Queue instance'
        final QueueImpl testQueue = getQueue()

        when: 'the Queue is queried to remove an element'
        final Optional<INode> resultant = testQueue.removeElement()

        then: "Sanity Check: the Queue is verified to be Empty"
        testQueue.isEmpty()

        and: "the resultant Node is not present"
        !resultant.isPresent()
    }

    def "removeElement(): should not throw a NPE when queried with an out of bounds index"() {

        given: 'a Queue instance'
        final QueueImpl testQueue = getQueue()

        and: 'an out of bounds index'
        final int outOfBoundsIndex = 500

        when: 'the Queue is queried to remove an element'
        testQueue.removeElement(outOfBoundsIndex)

        then: "Sanity Check: the Out of Bounds Index is verified to actually be out of bounds"
        testQueue.getSize() < outOfBoundsIndex

        and: "a NPE was not thrown"
        notThrown(NullPointerException)
    }

}
