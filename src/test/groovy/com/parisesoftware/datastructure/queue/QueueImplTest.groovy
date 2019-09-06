package com.parisesoftware.datastructure.queue

import spock.lang.Specification

class QueueImplTest extends Specification {

    def "isEmpty(): should return true immediately following construction"() {

        given: 'a Queue instance'
        final QueueImpl testQueue = new QueueImpl()

        when: "the Queue is queried for if it is Empty"
        final boolean resultant = testQueue.isEmpty()

        then: "the resultant boolean is true"
        resultant
    }

}
