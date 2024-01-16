package abDrivers;

import java.util.List;
import java.util.Map;
import java.util.Random;
import abDataHandelers.Signal;
import abAlgorithms.Sort;
import abExceptions.InvalidArgumentException;
import abExceptions.NullArgumentException;
import abLists.ArrayList;
import abLists.DoublyLinkedList;
import abLists.LinkedList;

/**
 * This class performs an experiment to compare the performance of different
 * sorting on different data structures using a set of signals read from a file.
 * 
 * @author Mustafa Al-Shebeeb
 * 
 * @version 1.0
 * @since 04-14-2023
 * 
 */
public class SortingExperiments {
	// The names of the sorting algorithms to be tested
	private static final String[] SORT_ALGORITHMS = { "Bubble Sort", "Insertion Sort", "Selection Sort", "Quick Sort" };

	// The names of the list implementations to be tested
	private static final String[] LIST_IMPLEMENTATIONS = { "Array List", "Singly Linked List", "Doubly Linked List" };

	// The number of iterations to run for each algorithm
	private static final int NUM_ITERATIONS = 10;

	/**
	 * 
	 * Runs sorting experiments on a list of Signal objects using various sorting
	 * algorithms and list implementations.
	 * 
	 * Calculates the average running time of each combination of sorting algorithm
	 * and list implementation and stores
	 * 
	 * the results in a Map object.
	 * 
	 * @param signals      the list of Signal objects to be sorted
	 * 
	 * @param rand         a Random object used to generate random numbers
	 * 
	 * @param averageTimes a Map object to store the average running times of each
	 *                     combination of sorting algorithm and list implementation
	 * 
	 * @throws InvalidArgumentException if an invalid argument is passed to the
	 *                                  method
	 * 
	 * @throws NullArgumentException    if a null argument is passed to the method
	 */

	public static void runSortingExperiments(List<Signal> signals, Random rand, Map<String, Double> averageTimes)
			throws InvalidArgumentException, NullArgumentException {
		// Iterate through each sorting algorithm and list implementation
		for (String sortAlg : SORT_ALGORITHMS) {
			for (String listImpl : LIST_IMPLEMENTATIONS) {
				// Create list object based on list implementation
				List<Signal> signalList;
				switch (listImpl) {
				case "Array List":
					signalList = new ArrayList<>();
					for (Signal signal : signals) {
						signalList.add(signal);
					}
					break;
				case "Singly Linked List":
					signalList = new LinkedList<>();
					for (Signal signal : signals) {
						signalList.add(signal);
					}
					break;
				case "Doubly Linked List":
					signalList = new DoublyLinkedList<>();
					for (Signal signal : signals) {
						signalList.add(signal);
					}
					break;
				default:
					throw new IllegalArgumentException("Invalid list implementation: " + listImpl);
				}

				// Add signals to list
				signalList.addAll(signals);

				long sortTime = 0;
				// Perform sorting and measure the time taken
				for (int i = 0; i < NUM_ITERATIONS; i++) {
					long startTime = System.nanoTime();
					switch (sortAlg) {
					// The second paramter is the order in which the list will be sorted
					// 1 for ascending, 0 for descending
					case "Bubble Sort":
						Sort.bubbleSort(signalList, 1);
						break;
					case "Insertion Sort":
						Sort.insertionSort(signalList, 1);
						break;
					case "Selection Sort":
						Sort.selectionSort(signalList, 1);
						break;
					case "Quick Sort":
						Sort.quickSort(signalList, 1);
						break;
					default:
						// Throws exception for invalid algorithm
						throw new IllegalArgumentException("Invalid sorting algorithm: " + sortAlg);
					}
					long endTime = System.nanoTime();
					sortTime += (endTime - startTime);
				}
				// Calculate the average time taken and store it in the map
				double meanTimeMillis = sortTime / (1_000_000.0 * NUM_ITERATIONS);
				String key = sortAlg + "," + listImpl;
				averageTimes.put(key, meanTimeMillis);
				System.out.printf("%s, %s, %.2f ms\n", sortAlg, listImpl, meanTimeMillis);
			}
		}
	}

}
