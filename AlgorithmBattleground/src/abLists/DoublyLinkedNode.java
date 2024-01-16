package abLists;

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
 * Represents a node in a doubly linked list
 *
 * @param <E> the type of the element stored in the node
 */
public class DoublyLinkedNode<E> {
	E item; // the data element stored in the node
	DoublyLinkedNode<E> prev; // reference to the previous node
	DoublyLinkedNode<E> next; // reference to the next node

	/**
	 *
	 * Constructs a new node with the specified data element
	 *
	 * @param item the data element to be stored in the node
	 */
	public DoublyLinkedNode(E item) {
		this.item = item;
		prev = null;
		next = null;
	}

	/**
	 *
	 * Returns the data element stored in the node
	 *
	 * @return the data element stored in the node
	 */
	public E getItem() {
		return item;
	}

	/**
	 *
	 * Sets the data element stored in the node to the specified value
	 *
	 * @param data the new value for the data element
	 */
	public void setItem(E data) {
		this.item = data;
	}

	/**
	 *
	 * Returns a reference to the previous node
	 *
	 * @return a reference to the previous node
	 */
	public DoublyLinkedNode<E> getPrev() {
		return prev;
	}

	/**
	 *
	 * Sets the reference to the previous node to the specified value
	 *
	 * @param prev the new value for the reference to the previous node
	 */
	public void setPrev(DoublyLinkedNode<E> prev) {
		this.prev = prev;
	}

	/**
	 *
	 * Returns a reference to the next node
	 *
	 * @return a reference to the next node
	 */
	public DoublyLinkedNode<E> getNext() {
		return next;
	}

	/**
	 *
	 * Sets the reference to the next node to the specified value
	 *
	 * @param next the new value for the reference to the next node
	 */
	public void setNext(DoublyLinkedNode<E> next) {
		this.next = next;
	}
}