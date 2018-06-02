/*
 * Andrew Parise
 * 
 * Mar 4th 2016
 * 
 * Test class to make sure that MyQueueClass.java 's functionality is working
 * 
 */
public class MyQueueClassTest {

	public static void main(String[] args) {
		MyQueueClass q = new MyQueueClass();
		
		//Testing .isEmpty()
		if(q.isEmpty()){
			System.out.println("The Queue is currently empty");
		}
		
		//Testing .insertElement()
		q.insertElement("Jimmy");
		if(!q.isEmpty()){
			System.out.println("The Queue is currently not empty");
		}
		q.displayContents();
		
		q.insertElement("Empty");
		q.insertElement("Rain");
		q.insertElement("Blue");
		
		q.displayContents();
		
		//Testing .removeElement()
		q.removeElement();
		q.displayContents();
		
		//Testing .getSize()
		System.out.println("Thre are currently " + q.getSize() + " elements in the queue");
		
		//Testing .viewFirst()
		Node firstNode = q.viewFirst();
		System.out.println("The first node is: " + firstNode.getInfo());
		
		//Testing .viewLast()
		Node lastNode = q.viewLast();
		System.out.println("The last node is: " + lastNode.getInfo());
		
		//Testing to make sure it did not remove node
		q.displayContents();
		
		
		//More Tests just to be sure
		q.insertElement("Morning");
		q.displayContents();
		firstNode = q.viewFirst();
		System.out.println("The first node is: " + firstNode.getInfo());
		lastNode = q.viewLast();
		System.out.println("The last node is: " + lastNode.getInfo());
		q.removeElement();
		q.displayContents();
		q.insertElement("Nothing");
		q.displayContents();
		firstNode = q.viewFirst();
		System.out.println("The first node is: " + firstNode.getInfo());
		lastNode = q.viewLast();
		System.out.println("The last node is: " + lastNode.getInfo());
		System.out.println("Thre are currently " + q.getSize() + " elements in the queue");
		
		//Testing .search()
		System.out.println("The second node is: " + q.search(1).getInfo());

	}

}
