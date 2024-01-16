package abAlgorithms;

import java.util.List;

import abDataHandelers.Signal;
import abExceptions.InvalidArgumentException;
import abExceptions.NullArgumentException;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class stores the sort algorithms of each type. bubble, insertion,
 * selection and quick sorting methods. parition method for the quick sort is
 * also included with a swap method as well.
 * 
 * @author Mustafa Al-Shebeeb
 * @version 1.0
 * @since 2023-02-24
 */
public class Sort {
	// helps the methods figure out which order to go through while sorting
	public final static int ASCENDING = 1;
	public final static int DESCENDING = 0;

	/**
	 * Bubble sort is a basic algorithm for arranging a string of numbers or other
	 * elements in the correct order. The method works by examining each set of
	 * adjacent elements in the string, from left to right, switching their
	 * positions if they are out of order.
	 * 
	 * @param input is the list of the elements, sortOrder determines ascending or
	 *              descending order
	 * @return N/A
	 */
	public static <E extends Comparable<E>> void bubbleSort(List<E> input, int sortOrder)
			throws InvalidArgumentException, NullArgumentException {
		// if statements for determing which exception to throw if an error was to occur
		if (input == null)
			throw new NullArgumentException();
		if (sortOrder != ASCENDING && sortOrder != DESCENDING)
			throw new InvalidArgumentException("Invalid Argument recieved " + sortOrder);

		// size of the list of elements
		int listSize = input.size() - 1;

		// nested for loop to search through the list and sor them
		for (int i = 0; i < listSize; i++) {

			for (int j = 0; j < listSize - i; j++) {
				// compares the adjacent values
				int compare = input.get(j + 1).compareTo(input.get(j));

				// determines whether to use ascending or descending
				if (compare < 0 && sortOrder == ASCENDING || compare > 0 && sortOrder == DESCENDING) {
					// calls the swap method
					swap(j, j + 1, input);
				}
			}
		}

	}

	/**
	 * Insertion sort is a sorting algorithm in which the elements are transferred
	 * one at a time to the right position. In other words, an insertion sort helps
	 * in building the final sorted list, one item at a time, with the movement of
	 * higher-ranked elements.
	 * 
	 * @param input is the list of the elements, sortOrder determines ascending or
	 *              descending order
	 * @return N/A
	 */
	public static <E extends Comparable<E>> void insertionSort(List<E> input, int sortOrder)
			throws InvalidArgumentException, NullArgumentException {

		// if statements for determing which exception to throw if an error was to occur
		if (input == null)
			throw new NullArgumentException();
		if (sortOrder != ASCENDING && sortOrder != DESCENDING)
			throw new InvalidArgumentException("Invalid Argument recieved " + sortOrder);

		for (int j = 1; j < input.size(); j++) {
			// element for selecting the elements in the list
			E selection = input.get(j);
			// element before j
			int i = j - 1;
			int compare;

			// while loop for sorting each of the elements in the list in either ascending
			// or descending order
			while ((i > -1) && ((compare = input.get(i).compareTo(selection)) > 0 && sortOrder == ASCENDING
					|| compare < 0 && sortOrder == DESCENDING)) {
				// calls the swap method
				swap(i, i + 1, input);
				i--;

			}

		}

	}

	/**
	 * Selection sort is an effective and efficient sort algorithm based on
	 * comparison operations. It adds one element in each iteration. You need to
	 * select the smallest element in the array and move it to the beginning of the
	 * array by swapping with the front element.
	 * 
	 * @param input is the list of the elements, sortOrder determines ascending or
	 *              descending order
	 * @return N/A
	 */
	public static <E extends Comparable<E>> void selectionSort(List<E> input, int sortOrder)
			throws InvalidArgumentException, NullArgumentException {
		// if statements for determing which exception to throw if an error was to occur
		if (input == null)
			throw new NullArgumentException();
		if (sortOrder != ASCENDING && sortOrder != DESCENDING)
			throw new InvalidArgumentException("Invalid Argument recieved " + sortOrder);
		// nested for loop for looking through the list
		for (int i = 0; i < input.size() - 1; i++) {
			// beggining of the elements
			int minIndex = i;

			for (int j = i + 1; j < input.size(); j++) {
				// compares the minimum index and the value adjacent to it
				int compare = input.get(j).compareTo(input.get(minIndex));
				// if both the the minimum index and value next to it
				if (compare > 0 && sortOrder == DESCENDING || compare < 0 && sortOrder == ASCENDING) {
					minIndex = j;
				}

			}
			// calls the swap method
			swap(minIndex, i, input);
		}

	}

	/**
	 * This method is used for calling the quick sort method below it and also
	 * throws null argument exception if it is required to do so
	 * 
	 * @param input is the list of the elements, sortOrder determines ascending or
	 *              descending order
	 * @return N/A
	 */
	public static <E extends Comparable<E>> void quickSort(List<E> input, int sortOrder)
			throws InvalidArgumentException, NullArgumentException {
		// if statements for determing which exception to throw if an error was to occur
		if (input == null)
			throw new NullArgumentException();
		if (sortOrder != ASCENDING && sortOrder != DESCENDING)
			throw new InvalidArgumentException("Invalid Argument recieved " + sortOrder);
		// calls the quick sort method
		doQuickSort(input, 0, input.size() - 1, sortOrder);

	}

	/**
	 * Quicksort is a popular sorting algorithm that is often faster in practice
	 * compared to other sorting algorithms. It utilizes a divide-and-conquer
	 * strategy to quickly sort data items by dividing a large array into two
	 * smaller arrays.
	 * 
	 * @param input is the list of the elements, sortOrder determines ascending or
	 *              descending order start is the begining of the list and end is
	 *              the end of the list
	 * @return N/A
	 */
	public static <E extends Comparable<E>> void doQuickSort(List<E> input, int start, int end, int sortOrder)
			throws InvalidArgumentException {
		// checks if the list is already sorted and will stop the method
		if (start >= end) {
			return;
		}
		// beginning of the list
		int startIndex = start;
		// gets the pivot value which is at the beginning
		E pivot = input.get(startIndex);
		// for loop that increments the pivote index
		for (int i = start + 1; i <= end; i++) {
			//
			int compare = pivot.compareTo(input.get(i));
			// checks the if the pivote is greater then 0 in either descending or ascending
			// order
			if (compare > 0 && sortOrder == ASCENDING || compare < 0 && sortOrder == DESCENDING) {
				// increments the start index
				startIndex++;
				// calls the swap method
				swap(i, startIndex, input);

			}
		}
		// calls the swap method and quick sort method
		swap(startIndex, start, input);
		doQuickSort(input, start, startIndex - 1, sortOrder);
		doQuickSort(input, startIndex + 1, end, sortOrder);

	}

	/**
	 * swap method that is used to swap the elements in the list so that they can be
	 * sorted
	 * 
	 * @param input is the list of elements a and b are the values that are bieng
	 *              swapped
	 * @return N/A
	 */
	public static <E extends Comparable<E>> void swap(int a, int b, List<E> input) {

		E temp = input.get(a);
		input.set(a, input.get(b));
		input.set(b, temp);

	}


}
