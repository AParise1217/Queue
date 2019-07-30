package com.parisesoftware.model;

/*
 * @author Andrew Parise
 * @since March 10th, 2016
 * @version 29 May 2018
 */
public class Node<T extends Comparable<T>> {

	private Node<T> leftNode;
	private Node<T> rightNode;
	private Node<T> link;
	private T data;

    /**
     * Default Constructor
     */
	public Node(){}

    /**
     * @param data the information to store in the Node
     */
	public Node(T data) {
		this.data = data;
	}

    /**
     * @param link the next Node in the Linked List
     * @param data the information to be stored in the Node
     */
	public Node(Node<T> link, T data) {
		this.data = data;
		this.link = link;
	}

    /**
     * Helper method for deletion
     * @param data
     * @param parent
     * @return
     */
	public boolean removeNode(T data, Node<T> parent){

        //if data comes before getData in alphabetical order
		if(data.compareTo(getData()) < 0) {
			return getLeftNode() != null && getLeftNode().removeNode(data, this);
		}
		else if(data.compareTo(getData()) > 0) {
			return getRightNode() != null && getRightNode().removeNode(data, this);
		}
		else{
			if(getLeftNode() != null && getRightNode() != null){
				setData(getRightNode().getMinimumValue());
				getRightNode().removeNode(data,  this);
			}
			else if(parent.getLeftNode() == this){
				if (getLeftNode() != null) {
					parent.setLeftNode(getLeftNode());
				} else {
					parent.setLeftNode(getRightNode());
				}
			}
			else if(parent.getRightNode() == this){
				if (getLeftNode() != null) {
					parent.setRightNode(getLeftNode());
				} else {
					parent.setRightNode(getRightNode());
				}
			}
			return true;
		}
	}


    /**
     * Helper function, returns farthest left node from given node
     * @return
     */
	public T getMinimumValue() {
		if(getLeftNode() == null){
			return getData();
		}
		else{
			return getLeftNode().getMinimumValue();
		}
	}
	

	//Left Node Get/Set
	public Node<T> getLeftNode(){
		return leftNode;
	}
	public void setLeftNode(Node<T> leftNode){
		this.leftNode = leftNode;
	}
	
	//Right Node Get/Set
	public Node<T> getRightNode(){
		return rightNode;
	}

	public void setRightNode(Node rightNode){
		this.rightNode = rightNode;
	}
	
	//Data Set/Get
	public T getData(){
		return data;
	}

	public void setData(T data){
		this.data = data;
	}
	
	//Link Set/Get - for linked list class
	public Node<T> getLink(){
		return link;
	}

	public void setLink(Node<T> link){
		this.link = link;
	}
	
	public String toString(){
		return "Node's data = " + this.data;
	}

}
