package abLists;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import abLists.DoublyLinkedNode;

/**
 *
 * Implementation of a doubly linked list data structure.
 *
 * @author Mustafa Al-Shebeeb
 * @version 1.0
 * @since 2023-03-06
 */
@SuppressWarnings("unused")
public class DoublyLinkedList<E> implements List<E> {
	// head pointer for the list
	private DoublyLinkedNode<E> head;
	// tail pointer for the list
	private DoublyLinkedNode<E> tail;
	// current size of the list
	int size;

	/**
	 * Creates an empty DoublyLinkedList.
	 */
	public DoublyLinkedList() {
		// head pointer initially set to null
		head = null;
		// tail pointer initially set to null
		tail = null;
		// size initially set to zero
		size = 0;
	}
	// List interface methods implementation

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
	@Override
	public int size() {
		// Initialize the counter
		int count = 0;
		// Set the current node to the head of the list.
		DoublyLinkedNode<E> curr = head;
		// Traverse the list, counting each node until the end is reached.
		while (curr != null) {
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
		if (arg0 == null) {
			throw new NullPointerException();
		}
		// Cast the object to the type of items in the list
		DoublyLinkedNode<E> curr = head;
		// Traverse the list to find the element
		while (curr != null) {
			// Check if the current item is equal to the specified element
			if (curr.item.equals(arg0)) {
				return true;
			}
			curr = curr.next;
		}
		// The element is not found in the list
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		return new DoublyItr();
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
		if (arg0 == null) {
			throw new NullPointerException();
		}
		var toAdd = new DoublyLinkedNode<>(arg0);
		// If the list is empty, set the new node as the head
		if (tail == null) {
			head = toAdd;
			tail = toAdd;
		} else {
			// Otherwise, traverse the list until the end
			// and set the new node as the next element
			tail.next = toAdd;
			toAdd.prev = tail;
			tail = toAdd;
		}
		size++;
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
		if (arg0 == null) {
			throw new NullPointerException();
		}
		// Set the current node to the head of the list.
		DoublyLinkedNode<E> curr = head;
		while (curr != null) {
			if (Objects.equals(curr.item, arg0)) {
				if (curr.prev == null) {
					// Removing the head node
					head = curr.next;
					if (head != null) {
						head.prev = null;
					}
				} else if (curr.next == null) {
					// Removing the tail node
					tail = curr.prev;
					tail.next = null;
				} else {
					// Removing a node in the middle
					curr.prev.next = curr.next;
					curr.next.prev = curr.prev;
				} // decrement size
				size--;
				return true;
			}
			curr = curr.next;
		} // return false otherwise
		return false;
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
	public boolean addAll(int index, Collection<? extends E> c) {
		// Throw IndexOutOfBoundsException if the index is out of range
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		// Convert the collection to an array
		Object[] arr = c.toArray();
		int numNewElements = arr.length;

		if (numNewElements == 0) {
			return false;
		}

		// add the new elements to a new linked list
		DoublyLinkedList<E> newList = new DoublyLinkedList<>();
		for (Object element : arr) {
			newList.add((E) element);
		}

		if (index == size) {
			// Adding to the end of the list
			tail.next = newList.head;
			newList.head.prev = tail;
			tail = newList.tail;
		} else if (index == 0) {
			// Adding to the beginning of the list
			head.prev = newList.tail;
			newList.tail.next = head;
			head = newList.head;
		} else {
			// Adding to the middle of the list
			DoublyLinkedNode<E> curr = head;
			for (int i = 0; i < index; i++) {
				curr = curr.next;
			}
			DoublyLinkedNode<E> prev = curr.prev;

			prev.next = newList.head;
			newList.head.prev = prev;

			curr.prev = newList.tail;
			newList.tail.next = curr;
		}

		size += numNewElements;
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
		// setting the head and tail equal to null clears the entire linked list
		head = null;
		tail = null;
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
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		// Traverse the list until reaching the desired index, then return the item at
		// that node.
		DoublyLinkedNode<E> curr = head;
		// If the index is in the first half of the list, start from the head and
		// iterate
		// forwards to find the node.
		if (index < size / 2) {
			for (int i = 0; i < index; i++) {
				curr = curr.next;
			}
		}
		// If the index is in the second half of the list, start from the tail and
		// iterate
		// backwards to find the node.
		else {
			curr = tail;
			for (int i = size - 1; i > index; i--) {
				curr = curr.prev;
			}
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
		// Throw a NullPointerException if the new element is null
		if (element == null) {
			throw new NullPointerException();
		}
		// Throw an IndexOutOfBoundsException if the index is out of bounds.
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		// Traverse the list until reaching the desired index.
		DoublyLinkedNode<E> curr = head;
		for (int i = 0; i < index; i++) {
			curr = curr.next;
		}
		// Replace the item in the current node with the new element.
		curr.item = element;
		// Return the old value of the item.
		return curr.item;
	}

	@Override
	/**
	 * Inserts the specified element at the specified position in this list.
	 *
	 * @param index   the index at which to insert the element
	 *
	 * @param element the element to insert
	 *
	 * @throws IndexOutOfBoundsException if the index is out of range
	 * @throws NullPointerException      if the specified element is null
	 */
	public void add(int index, E element) {
		// Check if the index is out of range
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		// Check if the element is null
		if (element == null) {
			throw new NullPointerException();
		}
		// Create a new DoublyLinkedNode with the specified element
		DoublyLinkedNode<E> newNode = new DoublyLinkedNode<>(element);
		// If the list is empty, set the head and tail to the new node
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		}
		// If the index is 0, insert the new node at the beginning of the list
		else if (index == 0) {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
		// If the index is equal to the size of the list,
		// insert the new node at the end of the list
		else if (index == size) {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		// Otherwise, insert the new node in the middle of the list
		else {
			DoublyLinkedNode<E> curr = head;
			for (int i = 0; i < index; i++) {
				curr = curr.next;
			}

			newNode.prev = curr.prev;
			newNode.next = curr;
			curr.prev.next = newNode;
			curr.prev = newNode;
		}
		// Increase the size of the list
		size++;
	}

	@Override
	/**
	 * Removes the element at the specified position in this list.
	 *
	 * @param index the index of the element to be removed
	 * @return the removed element
	 * @throws IndexOutOfBoundsException if the index is out of range
	 */
	public E remove(int index) {
		// Check if the index is out of range
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		// Traverse the list to find the node to be removed
		DoublyLinkedNode<E> curr = head;
		for (int i = 0; i < index; i++) {
			curr = curr.next;
		}
		// Get the element to be removed
		E removedElement = curr.item;
		// If the node to be removed is the head node
		if (curr.prev == null) {
			// Removing the head node
			head = curr.next;
			// If the list is not empty, set the new head's previous pointer to null
			if (head != null) {
				head.prev = null;
			}
		}
		// If the node to be removed is the tail node
		else if (curr.next == null) {
			// Removing the tail node
			tail = curr.prev;
			tail.next = null;
		}
		// If the node to be removed is in the middle of the list
		else {
			// Removing a node in the middle
			curr.prev.next = curr.next;
			curr.next.prev = curr.prev;
		}
		// Decrease the size of the list
		size--;
		// Return the removed element
		return removedElement;
	}

	@Override
	/**
	 * Returns the index of the first occurrence of the specified element
	 *
	 * in this list, or -1 if this list does not contain the element.
	 *
	 * @param arg0 the element to search for
	 *
	 * @return the index of the first occurrence of the specified element,
	 * @throws NullPointerException if the specified element is null
	 */
	public int indexOf(Object arg0) {
		// Check if the specified element is null
		if (arg0 == null) {
			throw new NullPointerException();
		}
		// Traverse the list to find the element
		int i = 0;
		DoublyLinkedNode<E> curr = head;
		while (curr != null) {
			if (curr.item.equals(arg0)) {
				return i;
			}
			curr = curr.next;
			i++;
		}
		// If the element is not found, return -1
		return -1;
	}

	@Override
	/**
	 *
	 * Returns the index of the last occurrence of the specified element
	 *
	 * in this list, or -1 if this list does not contain the element.
	 *
	 * @param arg0 the element to search for
	 *
	 * @return the index of the last occurrence of the specified element,
	 * @throws NullPointerException if the specified element is null
	 */
	public int lastIndexOf(Object arg0) {
		// Check if the specified element is null
		if (arg0 == null) {
			throw new NullPointerException();
		}
		// Start searching from the tail of the list
		int i = size - 1;
		DoublyLinkedNode<E> curr = tail;
		while (curr != null) {
			if (curr.item.equals(arg0)) {
				// Return the index of the element if it is found
				return i;
			}
			// Move to the previous node and decrement the index for the next iteration
			curr = curr.prev;
			i--;
		}
		// If the element is not found, return -1
		return -1;
	}

	@Override
	public ListIterator<E> listIterator() {
		return new DoublyItr();
	}

	private class DoublyItr implements ListIterator<E> {
		// The current node the iterator is pointing to, initialized to the head
		private DoublyLinkedNode<E> current = head;

		@Override
		// Returns true if the current node is not null, i.e., there is another element
		// in the list
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public E next() {
			// If there are no more elements in the list
			// Throw an exception
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			// The data in the current node is stored in a variable
			E data = current.item;
			// The iterator moves to the next node
			current = current.next;
			// The data in the current node is returned
			return data;
		}

		@Override
		public boolean hasPrevious() {
			return current != null && current.prev != null || current == null && tail != null;
			// Returns true if the current node is not null and its previous node is not
			// null
			// or if the current node is null and the tail node is not null, i.e., there is
			// a previous element in the list
		}

		@Override
		public E previous() {
			// If there are no previous elements in the list
			if (!hasPrevious()) {
				// Throw an exception
				throw new NoSuchElementException();
			}
			// If the iterator is at the end of the list
			if (current == null) {
				// Move the iterator to the tail node
				current = tail;
			} else {
				// Otherwise, move the iterator to the previous node
				current = current.prev;
			}
			// The data in the current node is returned
			return current.item;
		}

		@Override
		public int nextIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int previousIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub

		}

		@Override
		public void set(E e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void add(E e) {
			// TODO Auto-generated method stub

		}
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	/**
	 * Returns a new List that contains the elements from this list between the
	 * specified fromIndex, inclusive, and toIndex, exclusive. If fromIndex and
	 * toIndex are equal, the returned list is empty.
	 *
	 * @param fromIndex the starting index (inclusive) of the subList
	 * @param toIndex   the ending index (exclusive) of the subList
	 * @return a new List that contains the elements from this list between the
	 *         specified
	 * @throws IndexOutOfBoundsException if fromIndex is negative, toIndex is
	 *                                   greater than the size of
	 */
	public List<E> subList(int fromIndex, int toIndex) {

		// Create a new DoublyLinkedList to hold the sublist
		DoublyLinkedList<E> subList = new DoublyLinkedList<>();
		// Traverse the original list and add the elements within the specified range to
		// the sublist
		int i = 0;
		for (E element : this) {
			if (i >= fromIndex && i < toIndex) {
				subList.add(element);
			}
			i++;
		}
		// Return the sublist
		return subList;
	}
}
