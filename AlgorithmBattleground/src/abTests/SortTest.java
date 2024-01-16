package abTests;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import abAlgorithms.Sort;

class SortTest {

	private static Stream<List<? extends Comparable<?>>> provideDogArrays() {
		return Stream.of(Arrays.asList(new Dog(1), new Dog(2), new Dog(3)),
				Arrays.asList(new Dog(5), new Dog(3), new Dog(2), new Dog(1)),
				Arrays.asList(new Dog(9), new Dog(9), new Dog(9), new Dog(1)),
				Arrays.asList(new Dog(50), new Dog(1), new Dog(2), new Dog(21)),
				Arrays.asList(new Dog(5), new Dog(3), new Dog(2), new Dog(99), new Dog(1)), Arrays.asList(1),
				Arrays.asList(new Dog(-20), new Dog(-40), new Dog(5), new Dog(-25)));
	}

	private static Stream<List<Integer>> provideIntArrays() {
		return Stream.of(Arrays.asList(1, 2, 3), Arrays.asList(5, 3, 2, 1), Arrays.asList(9, 9, 9, 1),
				Arrays.asList(50, 1, 2, 21), Arrays.asList(5, 3, 2, 99, 1), Arrays.asList(1),
				Arrays.asList(-20, -40, 5, -25));
	}

	private static Stream<List<String>> provideStringArrays() {
		return Stream.of(Arrays.asList("cat", "dog"), Arrays.asList("Bob", "Tom", "Karen", "Jill"),
				Arrays.asList("Java", "Javascript", "Haskell", "C#", "C", "C++", "Ruby"));

	}

	@ParameterizedTest
	@MethodSource("provideIntArrays")
	void bubbleSort_null1arg_throwsexception(List<Integer> input) {
		Assert.assertThrows(abExceptions.NullArgumentException.class, () -> {
			Sort.bubbleSort(null, Sort.ASCENDING);
		});
	}

	@ParameterizedTest
	@MethodSource("provideIntArrays")
	void bubbleSort_null2arg_throwsexception(List<Integer> input) {
		Assert.assertThrows(abExceptions.InvalidArgumentException.class, () -> {
			Sort.bubbleSort(input, Integer.MAX_VALUE);
		});
	}

	@ParameterizedTest
	@MethodSource("provideIntArrays")
	void bubbleSort_SortsIntegersAsExpectedAscending(List<Integer> input) {
		try {
			List<Integer> output = input.stream().collect(Collectors.toList());
			Sort.bubbleSort(output, Sort.ASCENDING);
			Utils.assertListHasBeenSortedAscending(input, output);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@ParameterizedTest
	@MethodSource("provideStringArrays")
	void bubbleSort_SortsStringsAsExpectedAscending(List<String> input) {
		try {
			List<String> output = input.stream().collect(Collectors.toList());
			Sort.bubbleSort(output, Sort.ASCENDING);
			Utils.assertListHasBeenSortedAscending(input, output);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@ParameterizedTest
	@MethodSource("provideDogArrays")
	void bubbleSort_SortsDogsAsExpectedAscending(List<Dog> input) {
		try {
			List<Dog> output = input.stream().collect(Collectors.toList());
			Sort.bubbleSort(output, Sort.ASCENDING);
			Utils.assertListHasBeenSortedAscending(input, output);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@ParameterizedTest
	@MethodSource("provideIntArrays")
	void bubbleSort_SortsIntegersAsExpectedDescending(List<Integer> input) {
		try {
			List<Integer> output = input.stream().collect(Collectors.toList());
			Sort.bubbleSort(output, Sort.DESCENDING);
			Utils.assertListHasBeenSortedDescending(input, output);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@ParameterizedTest
	@MethodSource("provideStringArrays")
	void bubbleSort_SortsStringsAsExpectedDescending(List<String> input) {
		try {
			List<String> output = input.stream().collect(Collectors.toList());
			Sort.bubbleSort(output, Sort.DESCENDING);
			Utils.assertListHasBeenSortedDescending(input, output);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@ParameterizedTest
	@MethodSource("provideDogArrays")
	void bubbleSort_SortsDogsAsExpectedDescending(List<Dog> input) {
		try {
			List<Dog> output = input.stream().collect(Collectors.toList());
			Sort.bubbleSort(output, Sort.DESCENDING);
			Utils.assertListHasBeenSortedDescending(input, output);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@ParameterizedTest
	@MethodSource("provideIntArrays")
	void selectionSort_null1arg_throwsexception(List<Integer> input) {
		Assert.assertThrows(abExceptions.NullArgumentException.class, () -> {
			Sort.selectionSort(null, Sort.ASCENDING);
		});
	}

	@ParameterizedTest
	@MethodSource("provideIntArrays")
	void selectionSort_null2arg_throwsexception(List<Integer> input) {
		Assert.assertThrows(abExceptions.InvalidArgumentException.class, () -> {
			Sort.selectionSort(input, Integer.MAX_VALUE);
		});
	}

	@ParameterizedTest
	@MethodSource("provideIntArrays")
	void selectionSort_SortsIntegersAsExpectedAscending(List<Integer> input) {
		try {
			List<Integer> output = input.stream().collect(Collectors.toList());
			Sort.selectionSort(output, Sort.ASCENDING);
			Utils.assertListHasBeenSortedAscending(input, output);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@ParameterizedTest
	@MethodSource("provideStringArrays")
	void selectionSort_SortsStringAsExpectedAscending(List<String> input) {
		try {
			List<String> output = input.stream().collect(Collectors.toList());
			Sort.selectionSort(output, Sort.ASCENDING);
			Utils.assertListHasBeenSortedAscending(input, output);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@ParameterizedTest
	@MethodSource("provideDogArrays")
	void selectionSort_SortsDogsAsExpectedAscending(List<Dog> input) {
		try {
			List<Dog> output = input.stream().collect(Collectors.toList());
			Sort.selectionSort(output, Sort.ASCENDING);
			Utils.assertListHasBeenSortedAscending(input, output);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@ParameterizedTest
	@MethodSource("provideIntArrays")
	void selectionSort_SortsIntegersAsExpectedDescending(List<Integer> input) {
		try {
			List<Integer> output = input.stream().collect(Collectors.toList());
			Sort.selectionSort(output, Sort.DESCENDING);
			Utils.assertListHasBeenSortedDescending(input, output);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@ParameterizedTest
	@MethodSource("provideStringArrays")
	void selectionSort_SortsStringAsExpectedDescending(List<String> input) {
		try {
			List<String> output = input.stream().collect(Collectors.toList());
			Sort.selectionSort(output, Sort.DESCENDING);
			Utils.assertListHasBeenSortedDescending(input, output);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@ParameterizedTest
	@MethodSource("provideDogArrays")
	void selectionSort_SortsDogsAsExpectedDescending(List<Dog> input) {
		try {
			List<Dog> output = input.stream().collect(Collectors.toList());
			Sort.selectionSort(output, Sort.DESCENDING);
			Utils.assertListHasBeenSortedDescending(input, output);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@ParameterizedTest
	@MethodSource("provideIntArrays")
	void insertionSort_null1arg_throwsexception(List<Integer> input) {
		Assert.assertThrows(abExceptions.NullArgumentException.class, () -> {
			Sort.insertionSort(null, Sort.ASCENDING);
		});
	}

	@ParameterizedTest
	@MethodSource("provideIntArrays")
	void insertionSort_null2arg_throwsexception(List<Integer> input) {
		Assert.assertThrows(abExceptions.InvalidArgumentException.class, () -> {
			Sort.insertionSort(input, Integer.MAX_VALUE);
		});
	}

	@ParameterizedTest
	@MethodSource("provideIntArrays")
	void insertionSort_SortsArrayAsExpectedAscending(List<Integer> input) {
		try {
			List<Integer> output = input.stream().collect(Collectors.toList());
			Sort.insertionSort(output, Sort.ASCENDING);
			Utils.assertListHasBeenSortedAscending(input, output);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@ParameterizedTest
	@MethodSource("provideStringArrays")
	void insertionSort_SortsStringAsExpectedAscending(List<String> input) {
		try {
			List<String> output = input.stream().collect(Collectors.toList());
			Sort.insertionSort(output, Sort.ASCENDING);
			Utils.assertListHasBeenSortedAscending(input, output);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@ParameterizedTest
	@MethodSource("provideDogArrays")
	void insertionSort_SortsDogsAsExpectedAscending(List<Dog> input) {
		try {
			List<Dog> output = input.stream().collect(Collectors.toList());
			Sort.insertionSort(output, Sort.ASCENDING);
			Utils.assertListHasBeenSortedAscending(input, output);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@ParameterizedTest
	@MethodSource("provideIntArrays")
	void insertionSort_SortsArrayAsExpectedDescending(List<Integer> input) {
		try {
			List<Integer> output = input.stream().collect(Collectors.toList());
			Sort.insertionSort(output, Sort.DESCENDING);
			Utils.assertListHasBeenSortedDescending(input, output);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@ParameterizedTest
	@MethodSource("provideStringArrays")
	void insertionSort_SortsStringAsExpectedDescending(List<String> input) {
		try {
			List<String> output = input.stream().collect(Collectors.toList());
			Sort.insertionSort(output, Sort.DESCENDING);
			Utils.assertListHasBeenSortedDescending(input, output);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@ParameterizedTest
	@MethodSource("provideDogArrays")
	void insertionSort_SortsDogsAsExpectedDescending(List<Dog> input) {
		try {
			List<Dog> output = input.stream().collect(Collectors.toList());
			Sort.insertionSort(output, Sort.DESCENDING);
			Utils.assertListHasBeenSortedDescending(input, output);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@ParameterizedTest
	@MethodSource("provideIntArrays")
	void quickSort_null1arg_throwsexception(List<Integer> input) {
		Assert.assertThrows(abExceptions.NullArgumentException.class, () -> {
			Sort.quickSort(null, Sort.ASCENDING);
		});
	}

	@ParameterizedTest
	@MethodSource("provideIntArrays")
	void quickSort_null2arg_throwsexception(List<Integer> input) {
		Assert.assertThrows(abExceptions.InvalidArgumentException.class, () -> {
			Sort.quickSort(input, Integer.MAX_VALUE);
		});
	}

	@ParameterizedTest
	@MethodSource("provideIntArrays")
	void quickSort_SortsArrayAsExpectedAscending(List<Integer> input) {
		try {
			List<Integer> output = input.stream().collect(Collectors.toList());
			Sort.quickSort(output, Sort.ASCENDING);
			Utils.assertListHasBeenSortedAscending(input, output);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@ParameterizedTest
	@MethodSource("provideStringArrays")
	void quickSort_SortsStringAsExpectedAscending(List<String> input) {
		try {
			List<String> output = input.stream().collect(Collectors.toList());
			Sort.quickSort(output, Sort.ASCENDING);
			Utils.assertListHasBeenSortedAscending(input, output);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@ParameterizedTest
	@MethodSource("provideDogArrays")
	void quickSort_SortsDogsAsExpectedAscending(List<Dog> input) {
		try {
			List<Dog> output = input.stream().collect(Collectors.toList());
			Sort.quickSort(output, Sort.ASCENDING);
			Utils.assertListHasBeenSortedAscending(input, output);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@ParameterizedTest
	@MethodSource("provideIntArrays")
	void quickSort_SortsArrayAsExpectedDescending(List<Integer> input) {
		try {
			List<Integer> output = input.stream().collect(Collectors.toList());
			Sort.quickSort(output, Sort.DESCENDING);
			Utils.assertListHasBeenSortedDescending(input, output);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@ParameterizedTest
	@MethodSource("provideStringArrays")
	void quickSort_SortsStringAsExpectedDescending(List<String> input) {
		try {
			List<String> output = input.stream().collect(Collectors.toList());
			Sort.quickSort(output, Sort.DESCENDING);
			Utils.assertListHasBeenSortedDescending(input, output);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@ParameterizedTest
	@MethodSource("provideDogArrays")
	void quickSort_SortsDogsAsExpectedDescending(List<Dog> input) {
		try {
			List<Dog> output = input.stream().collect(Collectors.toList());
			Sort.quickSort(output, Sort.DESCENDING);
			Utils.assertListHasBeenSortedDescending(input, output);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
