package abDrivers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import abDataHandelers.ReadSignals;
import abDataHandelers.Results;
import abDataHandelers.Signal;
import abExceptions.InvalidArgumentException;
import abExceptions.NullArgumentException;

/**
 * This class performs an experiment to compare the performance of different
 * sorting and searching algorithms on different data structures using a set of
 * signals read from a file.
 *
 * @author Mustafa Al-Shebeeb
 *
 * @version 1.0
 * @since 04-14-2023
 *
 */
public class AlgorithmExperiment {
	/**
	 *
	 * This is the main method of the program, responsible for running the
	 * experiments.
	 *
	 * It reads signals from a file, initializes a random number generator, and runs
	 * the sorting and searching experiments
	 *
	 * on the signals using various algorithms and data structures. The average
	 * times taken by each algorithm and data structure
	 *
	 * combination are stored in a map and printed to the console.
	 *
	 * @param args Command line arguments (not used in this program)
	 *
	 * @throws IOException              If there is an error reading the input file
	 *
	 * @throws InvalidArgumentException If there is an invalid argument passed to a
	 *                                  method
	 *
	 * @throws NullArgumentException    If a null argument is passed to a method
	 */

	public static void main(String[] args) throws IOException, InvalidArgumentException, NullArgumentException {
		try {
			// Read signals from file
			// Uses the singal reading file from a different class.
			List<Signal> signals = ReadSignals
					.readSignalsFromFile("C:\\Users\\musta\\Documents\\eclipse-workspace1\\AlgorithmBattleground\\palfa2.txt");
			// Initialize random number generator
			Random rand = new Random();
			// initialize a map for the average times
			Map<String, Double> averageTimes = new HashMap<>();
			// initialize the results hashmap for csv writing method
			Map<String, Map<String, Double>> results = new HashMap<>();
			// Calls the method to write the results to a csv file.
			// Since this project will run twice for ascending and descending, we will need
			// two results files
			Results.resultsToCSV(results, "results.csv");

			// Run sorting experiments and store average times in map
			SortingExperiments.runSortingExperiments(signals, rand, averageTimes);
			// Run searching experiments and store average times in map
			SearchingExperiments.runSearchingExperiments(signals, rand, averageTimes);

		} catch (FileNotFoundException e) {
			System.err.println("Input file not found: " + e.getMessage());
		} catch (IllegalArgumentException e) {
			System.err.println("Invalid input: " + e.getMessage());
		}
	}
}