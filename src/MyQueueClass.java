/*
 * @author Andrew Parise
 * Mar 4th 2016
 * Assignment 5.1
 * Programming II
 * 
 * Assignment Overview:
 * "...use the linked list created in Assignment 3.1 to create a queue class 
 * and a test program that can handle this new system. The queue class must 
 * include a method to insert elements into the queue, remove elements from the queue, 
 * look at the first and last element of the queue without removing the elements from 
 * the queue, and search for an element in the queue. Use the following algorithm to 
 * simulate a simple version of the new system."
 * 
 * 
 * 
 */
public class MyQueueClass {
	MyLinkedListClass linkedList;
	public MyQueueClass(){
		//default constructor
		linkedList = new MyLinkedListClass();
		
	}
	public void insertElement(String info){ //"method to insert elements into the queue"
		linkedList.insertEnd(info); //inserts node at end of linked list
	}
	public void insertElement(Customer customer){ //adds a customer object to queue
		linkedList.insertEnd(customer);
	}
	public Node removeElement(){ //"remove elements from the queue"
		if(!isEmpty()){ //if queue is not empty
			return linkedList.deleteHead();//removes first node and returns it
		}
		return null;
	}
	public Node viewFirst(){ //"look at the first element of the queue without removing the element"
		//peek first element
		return linkedList.getHead();
	}
	public Node viewLast(){ //"look at the last element of the queue without removing the element"
		//peek last element
		return linkedList.getTail();
	}
	public Node search(int index){ //"search for an element in the queue"
		return linkedList.search(index);
	}
	public boolean isEmpty(){ //checks if queue is empty
		return linkedList.isEmpty();
	}
	public void removeElement(int index){
		linkedList.removeNode(index);
	}
	public int getSize(){
		//returns the number of elements in the queue
		return linkedList.getNumElements();
	}
	public void displayContents(){ //prints contents to console
		System.out.println("Contents of Queue: ");
		System.out.println(linkedList.toString());
	}
}
