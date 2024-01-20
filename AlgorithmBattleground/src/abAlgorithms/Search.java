package abAlgorithms;

import java.util.List;

import abExceptions.NullArgumentException;

/**
 * This class stores the search algorithms of each type. Linear, recursive and
 * iterative binary search.
 * Project Finished
 *
 * @author Mustafa Al-Shebeeb
 * @version 1.0
 * @since 2023-02-24
 */

public class Search {

	/**
	 * Generic Linear Search algorithm, simplest method of searching a data set
	 * Starting at the beginning of the data set, each item of data is examined
	 * until a match is made. Once the item is found, the search ends. If there is
	 * no match, the algorithm must deal with this.
	 *
	 * @param target paramter is the target value bieng searched for input is the
	 *               list being searched through
	 * @return i is the index that returns the position
	 */
	public static <T extends Comparable<T>> int linearSearch1(T target, List<T> input) throws NullArgumentException {
		// throws nullarg exception
		if (target == null || input == null) {
			throw new NullArgumentException();
		}
		// for loop that searches through list one by one
		for (int i = 0; i < input.size(); i++) {
			if (input.get(i).compareTo(target) == 0) {
				// returns index
				return i;
			}
		}
		return -1;


	}

	/**
	 * Binary search begins by comparing the middle element of the array to the
	 * target value. If the target value is equal to the middle element, its
	 * position in the array is returned. This is an iterative version of the binary
	 * search so the space complexity is O(1)
	 *
	 * @param target paramter is the target value bieng searched for input is the
	 *               list being searched through
	 * @return middle is the middle of the list bieng searched
	 */
	public static <E extends Comparable<E>> int iterativeBinarySearch1(E target, List<E> input)
			throws NullArgumentException {

		if (target == null || input == null) {
			throw new NullArgumentException();
		}
		// end and start variable for higher and lower bounds
		int start = 0;
		int end = input.size() - 1;
		// while loop that iterates when the condition is met
		while (start <= end) {
			int middle = (start + end) / 2;
			System.out.println(input + " " + start + " " + end + " " + middle);
			// if the middle is less than the target then it will move up
			if (input.get(middle).compareTo(target) < 0) {
				start = middle + 1;
			}
			// if the middle is greater than the target then it will move down
			if (input.get(middle).compareTo(target) > 0) {
				end = middle - 1;
			}
			// if the target and middle are the same then it will return middle
			if (input.get(middle).compareTo(target) == 0) {
				return middle;
			}
		}
		return -1;

	}

	/**
	 * This method is used for calling the recursive binary search below it and also
	 * throws null argument exception if it is required to do so
	 *
	 * @param target paramter is the target value bieng searched for input is the
	 *               list being searched through
	 * @return returns a call to the recursive binary search method
	 */
	public static <E extends Comparable<E>> int recursiveBinarySearch1(E target, List<E> input)
			throws NullArgumentException {
		// throws null argument exception
		if (target == null || input == null) {
			throw new NullArgumentException();
		}
		// returns a method call
		return doRecursiveBinarySearch1(target, input, 0, input.size() - 1);

	}

	/**
	 * Binary search begins by comparing the middle element of the array to the
	 * target value. If the target value is equal to the middle element, its
	 * position in the array is returned. This is an recursive version of the binary
	 * search so the space complexity is O(log N)
	 *
	 * @param target paramter is the target value bieng searched for input is the
	 *               list being searched through. low is the lower bound of the list
	 *               high is the higher bound of the list
	 * @return Return value with description
	 */
	public static <E extends Comparable<E>> int doRecursiveBinarySearch1(E target, List<E> input, int low, int high) {

		// base case
		if (high < low) {
			return -1;
		}

		int middle = (low + high) / 2;

		// if the target and middle are the same then middle is returned
		if (input.get(middle).compareTo(target) == 0) {
			return middle;
		}
		// if the middle is less than the target then it will go to the higher bound
		// and return the method call
		if (input.get(middle).compareTo(target) < 0) {
			return doRecursiveBinarySearch1(target, input, middle + 1, high);
		}
		// if the middle is greater than the target then it will go the lower
		// bound and return the method call
		return doRecursiveBinarySearch1(target, input, low, middle - 1);

	}


	/**
	 * Generic linear search algorithm that searches for a target key in the given list.
	 * Starting at the beginning of the list, each element is examined until a match is found.
	 * If a match is found, the index of the element is returned. If no match is found, -1 is returned.
	 *
	 * @param key The target key being searched for.
	 * @param list The list being searched through.
	 * @return The index of the target key if found, otherwise -1.
	 * @throws NullArgumentException If the target key or the list is null.
	 */
	public static <T extends Comparable<T>> int linearSearch(T key, List<T> list) throws NullArgumentException {
		// TODO Auto-generated method stub
		if (key == null || list == null) {
			throw new NullArgumentException();
		}
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(key)) {
				return i;
			}
		}
		return -1;

	}


	/**
	 * Iterative binary search algorithm that searches for a target key in the given sorted list.
	 * It compares the middle element of the list to the target value, updating the search bounds accordingly.
	 * If the target key is found, the index is returned. If not found, -1 is returned.
	 *
	 * @param key The target key being searched for.
	 * @param list The sorted list being searched through.
	 * @return The index of the target key if found, otherwise -1.
	 * @throws NullArgumentException If the target key or the list is null.
	 */
	public static <E extends Comparable<E>> int iterativeBinarySearch(E key, List<E> list) throws NullArgumentException {
		// TODO Auto-generated method stub
		if (key == null || list == null) {
			throw new NullArgumentException();
		}
		int low = 0;
		int high = list.size() - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (list.get(mid).compareTo(key) < 0) {
				low = mid + 1;
			} else if (list.get(mid).compareTo(key) > 0) {
				high = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;

	}


	/**
	 * Recursive binary search algorithm that searches for a target key in the given sorted list.
	 * It uses recursion to divide the list into halves until the target key is found or the search bounds are exhausted.
	 *
	 * @param searchSignal The target key being searched for.
	 * @param list The sorted list being searched through.
	 * @return The index of the target key if found, otherwise -1.
	 * @throws NullArgumentException If the target key or the list is null.
	 */
	public static <E extends Comparable<E>> int recursiveBinarySearch(E searchSignal, List<E> list) throws NullArgumentException {
		if (searchSignal == null || list == null) {
			throw new NullArgumentException();
		}
		return recursiveBinarySearch(searchSignal,list, 0, list.size() - 1);
	}

	/**
	 * Recursive helper method for the binary search algorithm.
	 * It searches for the target key in the specified range of the given sorted list using recursion.
	 *
	 * @param searchSignal The target key being searched for.
	 * @param list The sorted list being searched through.
	 * @param left The left bound of the current search range.
	 * @param right The right bound of the current search range.
	 * @return The index of the target key if found, otherwise -1.
	 */
	private static <E extends Comparable<E>> int recursiveBinarySearch(E searchSignal, List<E> list, int left, int right) {
		if (left > right) {
			return -1; // element not found
		}

		int mid = left + (right - left) / 2;
		E midSignal = list.get(mid);

		if (midSignal.equals(searchSignal)) {
			return mid; // element found
		} else if (midSignal.compareTo(searchSignal) > 0) {
			return recursiveBinarySearch(searchSignal, list, left, mid - 1); // search left half
		} else {
			return recursiveBinarySearch(searchSignal, list, mid + 1, right); // search right half
		}
	}
}
