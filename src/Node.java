/*
 * @author Andrew Parise
 * Feb 10th, 2016
 * 
 * Node.java
 * 
 * Object to be used in MyLinkedListClass.java, contains a link and some information
 * 
 * 
 * 
 * 
 */


public class Node {
	private Node link;
	private String info;
	private Customer objInfo;
	
	public Node(){
		//constructor
		link = null;
		info = "";
	}
	public Node(Node link, String info){
		this.link = link;
		this.info = info;
		
	}
	public Node(Node link, Customer obj){ //created to handle objects for Assignment 5.1
		this.link = link;
		this.objInfo = obj;
	}
	public Customer getCustomer(){
		return objInfo;
	}
	public void setObj(Customer obj){
		this.objInfo = obj;
	}
	public Node(String info){
		this.info = info;
		link = null;
	}
	public Node getLink(){
		return link;
	}
	public void setLink(Node link){
		this.link = link;
	}
	public String getInfo(){
		return info;
	}
	public void setInfo(String info){
		this.info = info;
	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
