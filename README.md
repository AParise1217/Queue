# Queue
JAVA implementation of the stack data structure.

Project completed on Mar 4th 2016

------------------------------------

Assignment Overview:
 "...use the linked list created in Assignment 3.1 to create a queue class 
 and a test program that can handle this new system. The queue class must 
 include a method to insert elements into the queue, remove elements from the queue, 
 look at the first and last element of the queue without removing the elements from 
 the queue, and search for an element in the queue. Use the following algorithm to 
 simulate a simple version of the new system."


# Releasing to Maven Central
## Performing a Release Deployment
*Note: This must occur prior to the Release Deployment!*

Make sure the "release-sign-artifacts" and "ossrh" 
    Maven profiles are active.

1) `mvn clean`
2) `mvn release:prepare -Possrh,release-sign-artifacts`
3) `mvn release:perform -Possrh,release-sign-artifacts`

* await the release process to finish *

4) `git push --tags`
5) `git push origin master`

## Updating the Release Version
1) `mvn versions:set -DnewVersion=1.2.3`