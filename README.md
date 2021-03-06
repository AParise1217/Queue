# Queue
JAVA implementation of the queue data structure. 
The Queue is implemented using a LinkedList, which 
is also an open source package written by me, and available 
[here](https://github.com/AParise1217/LinkedList).


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