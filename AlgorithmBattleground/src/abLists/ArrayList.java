package abLists;

import java.util.List;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * 
 * Implementation of a array list data structure.
 * 
 * @author Mustafa Al-Shebeeb
 * @version 1.0
 * @since 2023-03-06
 */

public class ArrayList<E> implements List<E> {
	// Default capacity of the ArrayList
	private static final int DEFAULT_CAPACITY = 10;
	// The underlying array used to store the elements
	private Object[] elements;
	// The current number of elements in the ArrayList
	private int size;
	// The current capacity of the ArrayList
	private int capacity;

	/**
	 * Constructor for the ArrayList class. Initializes an empty ArrayList object
	 * with an initial capacity of 10.
	 */
	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * Constructor for the ArrayList class. Initializes an empty ArrayList object
	 * with the specified initial capacity.
	 *
	 * @param capacity The initial capacity of the ArrayList.
	 */
	public ArrayList(int capacity) {
		// Allocate the array with the specified capacity
		elements = new Object[capacity];
		// Initialize the size to 0
		size = 0;
	}

	/**
	 * Increases the capacity of the ArrayList to ensure that it can hold at least
	 * the specified number of elements.
	 *
	 * @param capacity The minimum capacity that the ArrayList should have.
	 */
	private void ensureCapacity(int capacity) {
		// Check if the requested capacity is greater than the current capacity
		if (capacity > elements.length) {
			// Calculate the new capacity by doubling the current capacity or using the
			// requested capacity, whichever is greater
			int newCap = Math.max(elements.length * 2, capacity);
			// Create a new array with the new capacity
			E[] newData = (E[]) new Object[newCap];
			// Copy the existing elements into the new array
			System.arraycopy(elements, 0, newData, 0, size);
			// Replace the old array with the new one
			elements = newData;
		}
	}

	@Override
	/**
	 * Returns the number of elements currently stored in the data structure.
	 * 
	 * @return an integer value representing the size of the data structure.
	 */
	public int size() {
		// return the size of the data structure
		return size;
	}

	@Override
	/**
	 * Returns true if the data structure is empty (contains no elements), false
	 * otherwise.
	 * 
	 * @return a boolean value indicating whether the data structure is empty or
	 *         not.
	 */
	public boolean isEmpty() {
		// return true if the size of the data structure is 0, false otherwise
		return size == 0;
	}

	@Override
	/**
	 * Returns true if the data structure contains the specified element, false
	 * otherwise. Throws a NullPointerException if the specified element is null.
	 * 
	 * @param arg0 the element to check for presence in the data structure.
	 * @return a boolean value indicating whether the data structure contains the
	 *         specified element or not.
	 * @throws NullPointerException if the specified element is null.
	 */
	public boolean contains(Object arg0) {
		// Check if the specified element is null.
		// and throw an exception
		if (arg0 == null)
			throw new NullPointerException();
		// Ensure that the capacity of the array is sufficient to hold the new element
		ensureCapacity(size() + 1);
		// Iterate over the elements in the list and check if any of them are equal to
		// the specified element.
		for (var i = 0; i < size(); i++) {
			if (arg0.equals(elements[i])) {
				return true;
			}
		}
		// If the element is not found, return false.
		return false;
	}

	@Override
	/**
	 * Returns an iterator for iterating over the elements in the data structure.
	 *
	 * @return an iterator for the data structure.
	 */
	public Iterator<E> iterator() {
		// Return a new ArrayListIterator object that
		// is initialized with the current instance of the ArrayList.
		return new ArrayListIterator<E>(this);
	}

	/**
	 * Inner class that implements the Iterator interface for iterating over the
	 * elements in the ArrayList.
	 */
	public class ArrayListIterator<E> implements Iterator<E> {
		private int index = 0;
		private ArrayList<E> list;

		/**
		 * Constructor that takes an ArrayList as a parameter and initializes the
		 * iterator with it.
		 * 
		 * @param list the ArrayList to be iterated over.
		 */
		public ArrayListIterator(ArrayList<E> list) {
			this.list = list;
		}

		/**
		 * @return true if there are more elements to be iterated over, false otherwise.
		 */
		public boolean hasNext() {
			return index < list.size();
		}

		/**
		 * Returns the next element in the iteration. Throws a NoSuchElementException if
		 * there are no more elements to be iterated over.
		 * 
		 * @return the next element in the iteration.
		 * @throws NoSuchElementException if there are no more elements to be iterated
		 *                                over.
		 */
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			E element = list.get(index);
			index++;
			return element;
		}

		/**
		 * Removes the current element from the ArrayList. Throws an
		 * UnsupportedOperationException as this method is not supported by this
		 * Iterator.
		 * 
		 * @throws UnsupportedOperationException always.
		 */
		public void remove() {
			throw new UnsupportedOperationException();
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
	 * Adds the specified element to the end of the list. If the list is full, the
	 * capacity is doubled before adding the new element.
	 * 
	 * @param arg1 the element to be added to the list
	 * @return true
	 * @throws NullPointerException if the specified element is null
	 */
	public boolean add(Object arg1) {
		// Check if the specified element is null.
		// and throw an exception
		if (arg1 == null)
			throw new NullPointerException();
		// Ensure that the capacity of the array is sufficient to hold the new element.
		ensureCapacity(size + 1);
		// Add the new element to the end of the array and increment the size of the
		// list.
		elements[size++] = arg1;
		// Return true to indicate that the element was successfully added to the list.
		return true;

	}

	@Override
	/**
	 * Removes the first occurrence of the specified element from this list, if it
	 * is present. Shifts any subsequent elements to the left (subtracts one from
	 * their indices).
	 * 
	 * @param arg0 the element to be removed from this list, if present
	 * @return true if this list contained the specified element, false otherwise
	 * @throws NullPointerException if the specified element is null
	 */
	public boolean remove(Object arg0) {
		// Check if the specified element is null.
		// and throw an exception
		if (arg0 == null)
			throw new NullPointerException();
		// Ensure that the capacity of the array is sufficient to hold the new element.
		ensureCapacity(size);
		// Iterate over the elements in the list and check if any of them are equal to
		// the specified element.
		for (int i = 0; i < size; i++) {
			if (Objects.equals(elements[i], arg0)) {
				// Element found, remove it
				// Shift the elements after the removed element to the left by one position
				for (int j = i; j < size - 1; j++) {
					elements[j] = elements[j + 1];
				}
				// Clear the last element
				elements[size - 1] = null;
				// Decrease the size of the array
				size--;
				// Check if the array needs to be resized
				if (size < elements.length / 2) {
					// Resize the array to half its current capacity
					int newCap = Math.max(DEFAULT_CAPACITY, elements.length / 2);
					elements = Arrays.copyOf(elements, newCap);
				}
				// Return true to indicate that the element was successfully removed.
				return true;
			}
		}
		// Element not found
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	/**
	 * Adds all elements in the specified collection to the end of this list, in the
	 * order that they are returned by the collection's iterator.
	 * 
	 * @param c The collection containing the elements to be added to this list.
	 * @return true if this list changed as a result of the call, false otherwise.
	 * @throws NullPointerException if the specified collection is null, or if it
	 *                              contains a null element.
	 */
	public boolean addAll(Collection<? extends E> c) {
		// Ensure that the collection is not null
		Objects.requireNonNull(c);
		// Get the size of the collection and check if it's empty
		int newElements = c.size();
		if (newElements == 0) {
			return false;
		}
		// Ensure that the capacity of the array is large enough to hold all the new
		// elements
		int minCap = size + newElements;
		ensureCapacity(minCap);
		// Add the new elements to the end of the array
		int i = size;
		for (E e : c) {
			elements[i++] = e;
		}
		// Update the size of the array
		size += newElements;
		// Return true to indicate that the elements were successfully added to the list
		return true;
	}

	@Override
	/**
	 * Inserts all the elements in the specified collection into this list
	 * 
	 * starting at the specified position.
	 * 
	 * @param index The index at which to insert the first element from the
	 *              specified collection.
	 * 
	 * @param c     The collection containing elements to be added to this list.
	 * 
	 * @return True if this list changed as a result of the call.
	 * 
	 * @throws IndexOutOfBoundsException if the index is out of range (index < 0 ||
	 *                                   index > size).
	 */
	public boolean addAll(int index, Collection<? extends E> c) {
		// Check that the index is within the valid range of the list
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException();
		// Convert the collection to an array
		Object[] a = c.toArray();
		// Calculate the number of new elements to add
		int newElements = a.length;
		// Ensure that the list has enough capacity to hold the new elements
		ensureCapacity(size + newElements);
		// Calculate the number of elements that need to be moved
		int numMoved = size - index;
		// If any elements need to be moved, shift them over
		if (numMoved > 0) {
			System.arraycopy(elements, index, elements, index + newElements, numMoved);
		}
		// Copy the new elements into the list at the specified index
		System.arraycopy(a, 0, elements, index, newElements);
		// Update the size of the list
		size += newElements;
		// Return true if any elements were added
		return newElements != 0;
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
	 * Removes all of the elements from this list. The list will be empty after this
	 * call returns.
	 */
	public void clear() {
		// Sets all elements to null in the array to allow for garbage collection
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		// Resets the size of the array to zero
		size = 0;
	}

	@Override
	/**
	 * Returns the element at the specified index in this list.
	 * 
	 * @param index index of the element to return
	 * @return the element at the specified index
	 * @throws IndexOutOfBoundsException if the index is out of range
	 */
	public E get(int index) {
		// Check that the index is within the valid range of the list
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		// Return the element at the specified index, cast to type E
		return (E) elements[index];
	}

	@Override
	/**
	 * Sets the element at the specified index in this list to the specified
	 * element. Throws a NullPointerException if the specified element is null.
	 * 
	 * @param index   the index of the element to replace
	 * @param element the element to be stored at the specified position
	 * @return the element previously at the specified position
	 * @throws IndexOutOfBoundsException if the index is out of range
	 * @throws NullPointerException      if the element is null
	 */
	public E set(int index, E element) {
		// if the element is null then throw an exception
		if (element == null)
			throw new NullPointerException();
		// if the index is out of bounds then throw an exception
		if (index < 0 || index > size())
			throw new IndexOutOfBoundsException();
		// Retrieve the old element at the specified index
		Object oldElement = elements[index];
		// Set the element at the specified index to the new element
		elements[index] = element;
		// Cast the old element to type E and return it
		return (E) oldElement;
	}

	@Override
	/**
	 * Inserts the specified element at the specified position in this list. Shifts
	 * the element currently at that position (if any) and any subsequent elements
	 * to the right (adds one to their indices). If the size of the array is not
	 * enough to accommodate the new element, the array is automatically resized by
	 * doubling its capacity.
	 * 
	 * @param index   the index at which the specified element is to be inserted
	 * @param element the element to be inserted
	 * @throws NullPointerException      if the specified element is null
	 * @throws IndexOutOfBoundsException if the index is out of range
	 */
	public void add(int index, Object element) {
		// Check if element is null, and throw NullPointerException if it is
		if (element == null)
			throw new NullPointerException();
		// Check if the specified index is out of bounds, and throw
		// IndexOutOfBoundsException if it is
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException();
		// Ensure enough capacity in the array to add the new element
		ensureCapacity(size + 1);
		// Move elements after specified index to the right by one position
		System.arraycopy(elements, index, elements, index + 1, size - index);
		// Insert the new element at the specified index
		elements[index] = element;
		// Increment the size of the array
		size++;
	}

	@Override
	/**
	 * Removes the element at the specified index from this ArrayList. Shifts any
	 * subsequent elements to the left (subtracts one from their indices). This
	 * method does not shrink the size of the underlying array.
	 * 
	 * @param index the index of the element to be removed
	 * @return the element previously at the specified index
	 * @throws IndexOutOfBoundsException if the index is out of range
	 */
	public E remove(int index) {
		// Check if the index is out of bounds and
		// throw an indexOutOfBoundsException
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		// initialize the removed element as an object
		Object removedElement = elements[index];
		// create a copy of the array
		System.arraycopy(elements, index + 1, elements, index, size - index - 1);
		// Decrease the size of the array
		elements[--size] = null;
		// Return the removed element
		return (E) removedElement;
	}

	@Override
	/**
	 * Returns the index of the first occurrence of the specified element in this
	 * list,
	 * 
	 * or -1 if this list does not contain the element.
	 * 
	 * @param arg0 The element to search for in this list.
	 * 
	 * @return The index of the first occurrence of the specified element in this
	 *         list,
	 * 
	 *         or -1 if this list does not contain the element.
	 * 
	 * @throws NullPointerException If the specified element is null.
	 */
	public int indexOf(Object arg0) {
		// Check if the specified element is null.
		// and throw an exception
		if (arg0 == null)
			throw new NullPointerException();
		// Iterate through the elements and return the
		// index of the first occurrence of the element.
		for (int i = 0; i < size; i++) {
			if (arg0.equals(elements[i])) {
				return i;
			}
		}
		// If the element is not found, return -1.
		return -1;
	}

	@Override
	/**
	 * Returns the index of the last occurrence of the specified element in this
	 * list, or -1 if this list does not contain the element. The method starts
	 * searching from the end of the list.
	 * 
	 * @param arg0 the element to search for
	 * @return the index of the last occurrence of the specified element in this
	 *         list, or -1 if this list does not contain the element
	 * @throws NullPointerException if the specified element is null
	 */
	public int lastIndexOf(Object arg0) {
		// Check if the specified element is null.
		// and throw an exception
		if (arg0 == null)
			throw new NullPointerException();
		// Iterator through the elements and return the
		// index of the last occurance of the element
		for (int i = size - 1; i >= 0; i--) {
			if (arg0.equals(elements[i])) {
				return i;
			}
		}
		// If the element is not found, return -1
		return -1;
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
	 * 
	 * Returns a new List containing the elements of this List from the specified
	 * fromIndex, inclusive, to the specified
	 * 
	 * toIndex, exclusive.
	 * 
	 * @param fromIndex the index of the first element to be included in the subList
	 * 
	 * @param toIndex   the index of the element immediately after the last element
	 *                  to be included in the subList
	 * 
	 * @return a new List containing the specified elements from this List
	 * 
	 * @throws IndexOutOfBoundsException if fromIndex is negative, toIndex is
	 *                                   greater than the size of this List, or
	 *                                   fromIndex is greater than toIndex
	 */

	public List<E> subList(int fromIndex, int toIndex) {
		// Check if the indices are within bounds and valid
		if (fromIndex < 0 || toIndex > size() || fromIndex > toIndex) {
			throw new IndexOutOfBoundsException();
		}
		// Create a new ArrayList to hold the sublist
		ArrayList<E> sublist = new ArrayList<E>();
		// Iterate over the elements from the starting index to the ending index
		for (int i = fromIndex; i < toIndex; i++) {
			// Add each element to the sublist
			sublist.add(elements[i]);
		}
		// Return the sublist
		return sublist;
	}

}
