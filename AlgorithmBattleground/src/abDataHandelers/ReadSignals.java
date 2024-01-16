package abDataHandelers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import abLists.ArrayList;
import abDataHandelers.Signal;

/**
 * This class is used to read the signals from the palfa corrupted file.
 *
 * @author Mustafa Al-Shebeeb
 * @version 1.0
 * @since 04-14-2023
 */

@SuppressWarnings("unused")
public class ReadSignals {

	/**
	 * Reads the signals from the specified file and returns them as a list. Skips
	 * malformed signal data.
	 * 
	 * @param filename The name of the file to read from.
	 * @return The list of signals read from the file.
	 * @throws FileNotFoundException If the specified file cannot be found.
	 */
	public static List<Signal> readSignalsFromFile(String filename) throws FileNotFoundException {
		List<Signal> signals = new ArrayList<>();
		// Use a try-catch block to ensure the Scanner is closed after use
		try (Scanner scanner = new Scanner(new File(filename))) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] fields = line.split(" ");
				// Skip any malformed signal data that does not have exactly 5 fields of data
				if (fields.length != 5) {
					continue;
				}
				// Attempt to create a new Signal object using the data fields
				try {
					Signal signal = new Signal();
					signals.add(signal);
				} catch (NumberFormatException e) {
					// Skip any malformed signal data that cannot be parsed as a Signal object
				}
			}
		}
		// If no valid Signal objects were read from the file, throw an exception
		if (signals.isEmpty()) {
			throw new IllegalArgumentException("The input file is empty or contains only malformed signal data.");
		}
		return signals;
	}
}
