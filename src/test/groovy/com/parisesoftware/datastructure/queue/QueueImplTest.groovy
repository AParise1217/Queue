package com.parisesoftware.datastructure.queue

import spock.lang.Specification
import com.parisesoftware.model.Node;

class QueueImplTest extends Specification {

    def "isEmpty(): should return true immediately following construction"() {

        given: 'a Queue instance'
        final QueueImpl testQueue = new QueueImpl()

        when: "the Queue is queried for if it is Empty"
        final boolean resultant = testQueue.isEmpty()

        then: "the resultant boolean is true"
        resultant
    }

    def "removeElement(): should return null when the Queue is empty"() {

        given: 'a Queue instance'
        final QueueImpl testQueue = new QueueImpl()

        when: 'the Queue is queried to remove an element'
        final Node resultant = testQueue.removeElement()

        then: "Sanity Check: the Queue is verified to be Empty"
        testQueue.isEmpty()

        and: "the resultant Node is null"
        resultant == null
    }

    def "removeElement(): should not throw a NPE when queried with an out of bounds index"() {

        given: 'a Queue instance'
        final QueueImpl testQueue = new QueueImpl()

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
