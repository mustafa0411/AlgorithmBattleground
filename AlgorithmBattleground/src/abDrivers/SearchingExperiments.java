package abDrivers;
import java.util.List;
import java.util.Map;
import java.util.Random;

import abDataHandelers.Signal;
import abAlgorithms.Search;
import abAlgorithms.Sort;
import abExceptions.InvalidArgumentException;
import abExceptions.NullArgumentException;
import abLists.ArrayList;
import abLists.DoublyLinkedList;
import abLists.LinkedList;

/**
 * This class performs an experiment to compare the performance of different
 * Searching on different data structures using a set of signals read from a
 * file.
 *
 * @author Mustafa Al-Shebeeb
 *
 * @version 1.0
 * @since 04-14-2023
 *
 */

public class SearchingExperiments {

	// The names of the searching algorithms to be tested
	private static final String[] SEARCH_ALGORITHMS = { "Linear Search", "Iterative Binary Search",
	"Recursive Binary Search" };

	// The names of the list implementations to be tested
	private static final String[] LIST_IMPLEMENTATIONS = { "Array List", "Singly Linked List", "Doubly Linked List" };

	// The number of iterations to run for each algorithm
	private static final int NUM_ITERATIONS = 10;

	/**
	 *
	 * Runs a series of searching experiments using the specified list of Signal
	 * objects and the given random number generator.
	 *
	 * Calculates the average running time for each searching algorithm and list
	 * implementation combination and stores the
	 *
	 * results in the provided map.
	 *
	 * @param signals      the list of Signal objects to search through
	 *
	 * @param rand         the random number generator to use for selecting signals
	 *                     to search for
	 *
	 * @param averageTimes a map to store the average running time for each
	 *                     searching algorithm and list implementation
	 * @throws NullArgumentException
	 * @throws InvalidArgumentException
	 *
	 * @throws IllegalArgumentException if an invalid searching algorithm or list
	 *                                  implementation is provided
	 */
	public static void runSearchingExperiments(List<Signal> signals, Random rand, Map<String, Double> averageTimes)
			throws InvalidArgumentException, NullArgumentException {
		// Perform searching
		for (String searchAlg : SEARCH_ALGORITHMS) {
			// Iterate through each list implementation
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
				// Add all signals to list
				signalList.addAll(signals);
				long searchTime = 0;
				// Perform searching for multiple iterations
				for (int i = 0; i < NUM_ITERATIONS; i++) {
					// Time the search algorithm
					long startTime = System.nanoTime();

					switch (searchAlg) {
					case "Linear Search":
						Search.linearSearch(signals.get(rand.nextInt(signals.size())), signalList);
						break;
						// Binary search needs a sorted list, so we use quick sort on the signal list
						// since it is the most efficient
					case "Iterative Binary Search":
						Sort.quickSort(signalList, 1);
						Search.iterativeBinarySearch(signals.get(rand.nextInt(signals.size())), signalList);
						break;
					case "Recursive Binary Search":
						Sort.quickSort(signalList, 1);
						Search.recursiveBinarySearch(signals.get(rand.nextInt(signals.size())), signalList);
						break;
					default:
						throw new IllegalArgumentException("Invalid searching algorithm: " + searchAlg);
					}
					long endTime = System.nanoTime();
					searchTime += (endTime - startTime);
				}
				// Calculate the average search time and add to the map
				double meanTimeMillis = searchTime / 1_000_000.0;
				String key = searchAlg + "," + listImpl;
				averageTimes.put(key, meanTimeMillis);
				System.out.printf("%s, %s, %.2f ms\n", searchAlg, listImpl, meanTimeMillis);
			}
		}
	}

}
