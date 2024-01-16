package abDataHandelers;

import abDrivers.AlgorithmExperiment;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * This class contains the method that writes the results of the experiments to
 * the CSV file
 *
 * @author Mustafa Al-Shebeeb
 * @version 1.0
 * @since 04-24-2023
 */

public class Results {
	// The names of the sorting algorithms to be tested
	private static final String[] SORT_ALGORITHMS = { "Bubble Sort", "Insertion Sort", "Selection Sort", "Quick Sort" };

	// The names of the searching algorithms to be tested
	private static final String[] SEARCH_ALGORITHMS = { "Linear Search", "Iterative Binary Search",
			"Recursive Binary Search" };

	// The names of the list implementations to be tested
	private static final String[] LIST_IMPLEMENTATIONS = { "Array List", "Singly Linked List", "Doubly Linked List" };

	// The number of iterations to run for each algorithm

	/**
	 * 
	 * Writes the results of sorting algorithms on different data structures to a
	 * CSV file.
	 * 
	 * @param results    a Map of Maps containing the mean running time (in
	 *                   milliseconds) of each sorting algorithm on each data
	 *                   structure
	 * @param outputFile the name of the output CSV file
	 * @throws IOException if an I/O error occurs while writing to the CSV file
	 */

	public static void resultsToCSV(Map<String, Map<String, Double>> results, String outputFile) throws IOException {
		// Create a FileWriter object to write output to the CSV file
		FileWriter fw = new FileWriter(outputFile);
		BufferedWriter bw = new BufferedWriter(fw);

		// Write header row
		bw.write("Algorithm, DataStructure, MeanRunningTime(ms)\n");

		// Write data rows
		for (String sortAlg : SORT_ALGORITHMS) {
			for (String listImpl : LIST_IMPLEMENTATIONS) {
				// Get the mean running time for the current sorting algorithm and data structure
				double meanTimeMillis = results.get(sortAlg).get(listImpl);
				// Write the algorithm, data structure, and mean running time to the CSV file
				bw.write(sortAlg + ", " + listImpl + ", " + meanTimeMillis + "\n");
			}
		}
		for (String searchAlg : SEARCH_ALGORITHMS) {
			for (String listImpl : LIST_IMPLEMENTATIONS) {
				// Get the mean running time for the current searching algorithm and data structure
				double meanTimeMillis = results.get(searchAlg).get(listImpl);
				// Write the algorithm, data structure, and mean running time to the CSV file
				bw.write(searchAlg + ", " + listImpl + ", " + meanTimeMillis + "\n");
			}
		}
		// Close the BufferedWriter and FileWriter
		bw.close();
		fw.close();
	}
}
