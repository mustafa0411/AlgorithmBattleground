package abLists;

import abLists.Node;

/**
 * Represents a node in a linked list
 * 
 * 
 * @author Mustafa Al-Shebeeb
 *
 * @param <E> Type variable
 */

/**
 * 
 * Represents a node in a singly linked list
 * 
 * The node stores an element of type E and a reference to the next node in the
 * list
 * 
 * @param <E> The type of element stored in the node
 */
public class Node<E> {
	E item; // The element stored in the node
	Node<E> next; // A reference to the next node in the list

	/**
	 * 
	 * Creates a new node containing the specified element
	 * 
	 * @param i The element to store in the node
	 */
	public Node(E i) {
		this.item = i;
		next = null;
	}

	/**
	 * 
	 * Creates a new node containing the specified element and a reference to the
	 * next node
	 * 
	 * @param i    The element to store in the node
	 * @param next The next node in the list
	 */
	public Node(E i, Node<E> next) {
		this.item = i;
		this.next = next;
	}

	/**
	 * 
	 * Creates a new node containing the specified element
	 * 
	 * @param i The element to store in the node
	 * @return A new node containing the specified element
	 */
	public static <I> Node<I> createNode(I i) {
		return new Node<I>(i);
	}

	/**
	 * 
	 * Creates a new node containing the specified element and a reference to the
	 * next node
	 * 
	 * @param i    The element to store in the node
	 * @param next The next node in the list
	 * @return A new node containing the specified element and a reference to the
	 *         next node
	 */
	public static <I> Node<I> createNode(I i, Node<I> next) {
		return new Node<I>(i, next);
	}

	/**
	 * 
	 * Returns the element stored in the node
	 * 
	 * @return The element stored in the node
	 */
	public E getItem() {
		return item;
	}

	/**
	 * 
	 * Returns a reference to the next node in the list
	 * 
	 * @return A reference to the next node in the list, or null if there is no next
	 *         node
	 */
	public Node<E> getNext() {
		return this.next;
	}

	/**
	 * 
	 * Sets the next node in the list
	 * 
	 * @param next A reference to the next node in the list
	 */
	public void setNext(Node<E> next) {
		this.next = next;
	}

	/**
	 * 
	 * Returns true if there is a next node in the list
	 * 
	 * @return True if there is a next node in the list, false otherwise
	 */
	public Boolean hasNext() {
		return this.getNext() != null;
	}
}