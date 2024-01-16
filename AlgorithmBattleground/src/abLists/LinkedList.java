package abLists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.lang.model.element.UnknownElementException;
import abLists.Node;

/**
 * 
 * Implementation of a linked list data structure.
 * 
 * @author Mustafa Al-Shebeeb
 * @version 1.0
 * @since 2023-03-06
 */

public class LinkedList<E> implements List<E> {
	// set the head and tail nodes
	private Node<E> head;
	private Node<E> tail;
	// public size value for methods
	int size;

	/**
	 * Constructor for the LinkedList class. Initializes an empty LinkedList object
	 * with both head and tail nodes set to null.
	 */

	public LinkedList() {
		// set both head and tail nodes to null
		head = tail = null;
	}

	@Override
	/**
	 * This is a method that calculates and returns the size of the linked list,
	 * which represents the number of nodes in the list. The method does so by
	 * initializing a counter variable, setting the current node to the head of the
	 * list, and then traversing the list, incrementing the counter for each node
	 * until the end of the list is reached.
	 * 
	 * @param N/A
	 * @return count returns the size of the list
	 * @throws N/A
	 */
	public int size() {
		// Initialize the counter
		int count;
		// Set the current node to the head of the list.
		Node<E> curr = head;
		// error checking method that makes sure the curr variable is greater than or
		// equal to 0
		if (curr != null) {
			count = 1;
		} else {
			count = 0;
		}
		// Traverse the list, counting each node until the end is reached.
		while (curr != null && curr.hasNext()) {
			count++;
			curr = curr.next;
		}
		// Return the count.
		return count;
	}

	@Override
	/**
	 * This is a method that returns a boolean value indicating whether or not the
	 * linked list is empty. It does so by checking if the head node of the linked
	 * list is null.
	 * 
	 * @param N/A
	 * @return Returns true if the linked list is empty, false otherwise
	 * @throws N/A
	 */
	public boolean isEmpty() {
		// Check if the head node of the linked list is null
		return head == null;
	}

	@Override
	/**
	 * This is a method that determines whether or not the linked list contains a
	 * specified element.Then, it checks if the list is empty and if so, itreturns
	 * the result of calling the indexOf() method with the specified element.
	 * Otherwise, it casts the specified element to the type of items in the list
	 * and sets the current node to the head of the list. It then traverses the list
	 * until it finds the specified element, returning true if it is found and false
	 * otherwise.
	 * 
	 * @param arg0 is the object bieng searched through
	 * @return Returns false if the element is not found on the list
	 * @throws checks if the specificed element is null and throws
	 *                NullPointerException
	 */
	public boolean contains(Object arg0) {
		// Check if the specified element is null and throw
		// a NullPointerException if it is.
		if (arg0 == null)
			throw new NullPointerException();
		// Check if the list is empty and if so, call the
		// indexOf() method with the specified element.
		if (this.size() == 0)
			return indexOf(arg0) != -1;
		// Cast the object to the type of items in the list
		var curr = head;
		// Traverse the list to find the element
		while (curr.hasNext()) {
			// Check if the current item is equal to the specified element
			if (curr.getItem().equals(arg0)) {
				return true;
			}
			curr = curr.getNext();
		}
		// return false otherwise
		// The element is not found in the list
		return false;

	}

	@Override
	/**
	 * This code shows the implementation of an iterator for a linked list. The
	 * iterator allows users to traverse the linked list and remove elements from
	 * it. The iterator is implemented using a private inner class, Itr, which
	 * implements the Iterator interface.
	 * 
	 * @param N/A
	 * @return returns the last returned node
	 * @throws IllegalStateException if the last returned node is null
	 */
	public Iterator<E> iterator() {
		return new Itr();
	}

	// Inner class that implements the Iterator interface
	private class Itr implements Iterator<E> {
		// Variables to keep track of the current position and size of the linked list
		int size;
		int index;
		Node<E> current;

		/**
		 * Constructor that initializes the iterator with the size, index, and current
		 * node set to the beginning of the linked list.
		 */

		Itr() {
			// Assign the size of the linked list to the size variable
			size = size();
			// Set the index to 0, since we start at the beginning of the linked list
			index = 0;
			// Set the current node to the head of the linked list
			current = head;
		}

		@Override
		// Returns true if the iterator has more elements,
		// false otherwise
		public boolean hasNext() {
			return index != size;
		}

		// Returns the next element in the iteration
		@Override
		public E next() {
			// assign current node to temporary variable
			E value = current.item;
			// move the current node to the next
			current = current.next;
			// increment index of the iterator
			index++;
			// return the temporary variable
			return value;
		}

	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	/**
	 * Appends the specified element to the end of this list.
	 * 
	 * @param arg0 the element to be added to the list
	 * @return true if the element was added successfully
	 * @throws NullPointerException if the specified element is null
	 */
	public boolean add(E arg0) {
		// This method Appends the specified element to the end of this list
		// Create a new node to hold the element to be added
		if (arg0 == null)
			throw new NullPointerException();
		var toAdd = Node.createNode(arg0);
		// If the list is empty, set the new node as the head
		if (head == null) {
			head = toAdd;
			tail = toAdd;
		} else {
			// Otherwise, traverse the list until the end and set the new node as the next
			// element
			var curr = head;
			while (curr.hasNext()) {
				curr = curr.getNext();
			}
			curr.setNext(toAdd);
			tail = toAdd;
		}
		// The element has been successfully added, return true
		return true;
	}

	@Override
	/**
	 * Removes the first occurrence of the specified element from this list if it is
	 * present.
	 * 
	 * @param arg0 the element to be removed from the list
	 * @return true if the element was removed, false otherwise
	 * @throws NullPointerException if the specified element is null
	 */
	public boolean remove(Object arg0) {
		if (arg0 == null)
			throw new NullPointerException();
		// Set the current node to the head of the list.
		Node<E> curr = head;
		// Initialize a variable to keep track of the previous node.
		Node<E> prev = null;
		// Traverse the list until the end is reached or the specified element is found.
		while (curr != null && !curr.item.equals(arg0)) {
			prev = curr;
			curr = curr.next;
		}
		// If the end of the list was reached without finding the element, return false.
		if (curr == null) {
			return false;
		}
		// If the current node is the head node, update the head pointer to skip over
		// it.
		else if (prev == null) {
			head = curr.next;
		}
		// Remove the current node by updating the previous node's next pointer.
		else {
			prev.next = curr.next;
		}
		// Decrement the size of the list and return true to indicate that
		// the element was successfully removed.
		size--;
		return true;

	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	/**
	 * Appends all of the elements in the specified collection to the end of this
	 * list, in the order that they are returned by the specified collection's
	 * iterator.
	 * 
	 * @param arg0 the collection containing elements to be added to this list.
	 * @return true if this list changed as a result of the call.
	 * @throws NullPointerException if the specified collection is null or contains
	 *                              null elements.
	 */
	public boolean addAll(Collection<? extends E> arg0) {
		// Iterate over the elements in the
		// specified collection and add them to the end of this list.
		for (E element : arg0) {
			add(element);
		}
		return true;
	}

	@Override
	/**
	 * Inserts all of the elements in the specified collection into this list
	 * starting at the specified position.
	 * 
	 * @param indexToAddAt The index at which the elements should be inserted.
	 * @param arg1         The collection of elements to insert.
	 * @return True if all elements were successfully inserted.
	 * @throws IndexOutOfBoundsException if the index is out of range.
	 * @throws NullPointerException      if the argument is null.
	 * 
	 */
	public boolean addAll(int indexToAddAt, Collection<? extends E> arg1) {
		// Throw IndexOutOfBoundsException if the index is out of range
		if (indexToAddAt < 0 || indexToAddAt > size()) {
			throw new IndexOutOfBoundsException();
		}

		// Throw NullPointerException if the object is null
		if (arg1 == null) {
			throw new NullPointerException();
		}

		// Create a new linked list to hold the elements to be added
		LinkedList<E> toAdd = new LinkedList<>();
		toAdd.addAll(arg1);

		// If the list is empty, set the new nodes as the head and tail
		if (head == null) {
			head = toAdd.head;
			tail = toAdd.tail;
		} else {
			// Otherwise, insert the new nodes into the list
			Node<E> curr = head;
			Node<E> prev = null;
			int currIndex = 0;
			while (currIndex < indexToAddAt && curr != null) {
				prev = curr;
				curr = curr.getNext();
				currIndex++;
			}

			// Insert the new nodes after the previous node
			if (prev != null) {
				prev.setNext(toAdd.head);
			} else {
				head = toAdd.head;
			}

			// Set the tail to the last node in the list
			if (toAdd.tail != null) {
				toAdd.tail.setNext(curr);
				if (curr == null) {
					tail = toAdd.tail;
				}
			}
		}

		// The elements have been successfully added, return true
		return true;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	/**
	 * This method clears the entire linked list by setting the head of the list to
	 * null The size variable is also set to 0 because the list is cleared and there
	 * are no elements remaining.
	 */
	public void clear() {
		// setting the head equal to null clears the entire linked list
		head = null;
		// size becomes zero because the list is cleared(no elements)
		size = 0;

	}

	@Override
	/**
	 * Returns the element at the specified position in this list.
	 * 
	 * @param index the index of the element to return
	 * @return the element at the specified position in this list
	 * @throws IndexOutOfBoundsException if the index is out of range
	 */
	public E get(int index) {
		// Check if the index is out of bounds, and throw an exception if it is.
		if (index < 0 || index >= this.size())
			throw new IndexOutOfBoundsException();
		// Traverse the list until reaching the desired index, then return the item at
		// that node.
		Node<E> curr = head;
		for (int i = 0; i < index; i++) {
			curr = curr.next;
		}
		// returns the current element
		return curr.item;

	}

	@Override
	/**
	 * Sets the element at the specified index to the given element.
	 *
	 * @param index   the index of the element to be set.
	 * @param element the new element to be set.
	 * @return the previous element at the specified index.
	 * @throws NullPointerException      if the element is null.
	 * @throws IndexOutOfBoundsException if the index is out of range.
	 */
	public E set(int index, E element) {
		if (element == null)
			throw new NullPointerException();
		if (index < 0 || index >= this.size())
			throw new IndexOutOfBoundsException();
		// Traverse the list until reaching the desired index,
		// then set the item of that node to the new element.
		Node<E> curr = head;
		for (int i = 0; i < index; i++) {
			curr = curr.next;
		}
		curr.item = element;
		// Return the previous element at the specified index.
		return curr.item;
	}

	@Override
	public void add(int indexToAddAt, E arg1) {
		// Check if the index is out of range
		if (arg1 == null)
			throw new NullPointerException();
		// Check if the element is null
		if (indexToAddAt < 0 || indexToAddAt > this.size())
			throw new IndexOutOfBoundsException();
		// Create a new DoublyLinkedNode with the specified element
		Node<E> newNode = new Node<>(arg1);
		// If the list is empty, set the head and tail to the new node
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		}
		// If the index is 0, insert the new node at the beginning of the list
		else if (indexToAddAt == 0) {
			newNode.next = head;
			head = newNode;
		} else {
			var curr = head;
			Node<E> prev = null;
			var index = 0;
			// Traverse the list to find the node at the specified index
			while (index < indexToAddAt) {
				prev = curr;
				curr = curr.getNext();
				index++;
			}
			// Insert in the middle or at the end of the list
			prev.setNext(newNode);
			newNode.setNext(curr);
			// Increment the size of the list
			size++;

			// Update the tail pointer if the new node was added at the end of the list
			if (newNode.next == null) {
				tail = newNode;

			}
		}
	}

	@Override
	/**
	 * Removes the element at the specified position in this list
	 * 
	 * @param indexToRemoveAt the index of the element to be removed
	 * @return the removed element
	 * @throws IndexOutOfBoundsException if the index is out of range
	 */
	public E remove(int indexToRemoveAt) {
		// check if the index is out of bounds
		if (indexToRemoveAt < 0 || indexToRemoveAt >= this.size())
			throw new IndexOutOfBoundsException();
		// Initialize variables to keep track of the current and previous nodes.
		Node<E> prev = null;
		var curr = head;
		// error checking method that checks if the index is empty and if it
		// is less than 0 and return null if conditions are met
		if (isEmpty() || indexToRemoveAt >= this.size() || indexToRemoveAt < 0) {
			return null;
		}
		if (indexToRemoveAt == 0) {
			head = curr.getNext();
			return curr.getItem();
		}
		// Traverse the list to the specified index.
		for (int i = 0; indexToRemoveAt != i && curr.hasNext(); i++) {
			prev = curr;
			curr = curr.getNext();
		}
		// Remove the current node by updating the previous node's next pointer.
		prev.setNext(curr.getNext());
		// Return the removed element.
		return curr.item;
	}

	@Override
	/**
	 * Returns the index of the first occurrence of the specified element in this
	 * list, or -1 if this list does not contain the element.
	 * 
	 * @param arg0 the element whose index is to be returned
	 * @return the index of the first occurrence of the element, or -1 if not found
	 * @throws NullPointerException if the argument is null
	 */
	public int indexOf(Object arg0) {
		// Check for null argument.
		if (arg0 == null)
			throw new NullPointerException();
		// Traverse the list, returning the index of the first occurrence of the
		// element.
		int i = 0;
		Node<E> curr = head;
		while (curr != null) {
			if (curr.item.equals(arg0))
				return i;
			curr = curr.next;
			i++;
		}
		// If the element is not found, return -1.
		return -1;
	}

	@Override
	/**
	 * Returns the index of the last occurrence of the specified element in this
	 * list, or -1 if this list does not contain the element.
	 * 
	 * @param arg0 the element to search for in this list
	 * @return the index of the last occurrence of the specified element in this
	 *         list,
	 * @throws NullPointerException if the specified element is null
	 */
	public int lastIndexOf(Object arg0) {
		// Check if the specified element is null and throw a NullPointerException if it
		// is.
		if (arg0 == null)
			throw new NullPointerException();
		// Initialize variables to keep track of the last index and the current index.
		int lastInd = -1;
		int currInd = 0;
		// Set the current node to the head of the list.
		Node<E> curr = head;
		// Traverse the list, updating the last index each time the specified element is
		// found.
		while (curr != null) {
			if (curr.item.equals(arg0)) {
				lastInd = currInd;
			}
			curr = curr.next;
			currInd++;
		}
		// Return the last index of the element, or -1 if the element is not found.
		return lastInd;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	/**
	 * Returns a new List containing the elements of this list from the specified
	 * start index, inclusive, to the specified end index, exclusive.
	 * 
	 * @param start the index of the first element to include in the sublist.
	 * @param end   the index after the last element to include in the sublist.
	 * @return a new List containing the elements of this list from the specified
	 *         start
	 * @throws N/A
	 */
	public List<E> subList(int start, int end) {

		// Create a new ArrayList to store the sublist.
		List<E> list = new ArrayList<E>();
		// Set the current node to the head of the list.
		var curr = head;
		// Set the index to 0.
		var index = 0;
		// Traverse the list until the current index is equal to the starting index.
		while (index < start) {
			curr = curr.next;
			index++;
		}
		// Traverse the list from the starting index until the ending index or the end
		// of the list is reached.
		while (index < end && curr != null) {
			// Add the current item to the sublist.
			list.add(curr.item);
			// Move to the next node.
			curr = curr.next;
			// Increment the index
			index++;
		}

		// This will return list
		return list;
	}

}
