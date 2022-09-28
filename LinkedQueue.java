package FinalPartOne;

/*
 * Team Name: Bug Busters
 * Team Members: Edward Halim, Jonathan Tejakusuma
 * Queue - Exercise1
 */

public class LinkedQueue<T> implements QueueInterface<T> {
	
	//Declare Variables
	private Node firstNode;
	private Node lastNode;
	
	//Default Constructor
	public LinkedQueue() {
		firstNode =  null;
		lastNode = null;
	}//End of default constructor
	
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
	public void enqueue(T newEntry) {
		Node newNode = new Node(newEntry, null);
		if(isEmpty()) {
			firstNode = newNode;
		}
		else {
			lastNode.setNext(newNode);
		}
		lastNode = newNode;
		
	}//End of enqueue

	@Override
	public T dequeue() {
		T front = getFront();
		assert firstNode != null;
		firstNode.setData(null);
		firstNode = firstNode.getNext();
		
		if(firstNode == null) {
			lastNode = null;
		}
		return front;
		
	}//End of dequeue

	@Override
	public T getFront() {
		if(isEmpty()) {
			throw new EmptyQueueException();
		}
		else {
			return firstNode.getData();
		}
	}//End of getFront

	@Override
	public boolean isEmpty() {
		
		return (firstNode == null)&&(lastNode == null);
	}

	@Override
	public void clear() {
		firstNode = null;
		lastNode = null;
	}//End of isEmpty

}
