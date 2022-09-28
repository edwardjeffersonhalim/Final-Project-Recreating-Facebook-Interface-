package FinalPartOne;

/*
 * Group Name: Bug Busters
 * Members	: Edward Halim, Jonathan Tejakusuma
 * Stacks - Exercise 1
 */

public class LinkedStack<T> implements StackInterface<T>{
	private Node topNode;
	private int size;
	
	public LinkedStack() {
		topNode = null;
		size = -1;
	}
	
	private class Node {
		//Declare Variables
		private T data;
		private Node next;
		
		//Default Constructor
		private Node(T dataPortion) {
			this(dataPortion, null);
		}//end constructor
		
		//Alternate Constructor
		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		}//end of alternate constructor
		
		//Getter for data
		public T getData() {
		    return data;
		}//End of getter

		//Setter for data
		public void setData(T data) {
		    this.data = data;
		}//End of setter

		//Getter for next value
		public Node getNext() {
		    return next;
		}//End of getNext

		//Setter for next value
		public void setNext(Node next) {
		    this.next = next;
		}//End of setNext
		
	}
	@Override
	public void push(T newEntry) {
		//Create new node
		Node newNode = new Node(newEntry, topNode);
		//Last in
		topNode = newNode;
		size ++;
	}

	@Override
	public T pop() {
		// If list is empty, throw an exception
		if(topNode == null) {
			throw new EmptyStackException("Stack is empty.");
		}
		//Find the top value
		T top = peek();
		//Delete the top value
		assert topNode != null;
		topNode = topNode.getNext();
		size--;
		
		return top;
	}

	@Override
	
	public T peek() {
		// If list is empty, throw an exception
		if(topNode == null) {
			throw new EmptyStackException("Stack is empty.");
		}
		return topNode.data;
	}

	@Override
	public boolean isEmpty() {
		return(topNode == null);
	}

	@Override
	public void clear() {
		topNode = null;
		size = 0;
	}
	
}
