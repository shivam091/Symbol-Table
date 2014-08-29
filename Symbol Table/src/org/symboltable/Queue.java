package org.symboltable;

/**
 * A queue, implemented using a linked list.
 * 
 * @author shivam
 * 
 */
public class Queue {

	/**
	 * Beginning of queue.
	 */
	private Node firstElement;

	/**
	 * End of queue.
	 */
	private Node lastElement;

	/**
	 * Static inner class holding details of the node.
	 * 
	 * @author shivam
	 * 
	 */
	private static class Node {
		Object item;
		Node next;
	}

	/**
	 * Method to check whether queue is empty.
	 * 
	 * @return true, if queue is emptied.
	 */
	public boolean isEmpty() {
		return (firstElement == null);
	}

	/**
	 * Method to add new item to the queue.
	 * 
	 * @param anItem
	 *            An item to be added to the queue.
	 */
	public void enqueue(Object anItem) {
		Node x = new Node();
		x.item = anItem;
		x.next = null;
		if (isEmpty())
			firstElement = x;
		else
			lastElement.next = x;
		lastElement = x;
	}

	/**
	 * Method to remove and return the least recently added item.
	 * 
	 * @return Recently added item from the queue.
	 */
	public Object dequeue() {
		Object val = firstElement.item;
		firstElement = firstElement.next;
		return val;
	}
}