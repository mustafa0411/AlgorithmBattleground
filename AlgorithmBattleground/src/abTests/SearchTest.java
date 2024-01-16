package abTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import abAlgorithms.Search;
import abExceptions.NullArgumentException;

class SearchTest {

	private static Stream<Arguments> provideSequentialSearchArrays() {
		return Stream.of(Arguments.of(1, 0, List.of(1, 2, 3)), Arguments.of(4, -1, List.of(1, 2, 3)),
				Arguments.of(42, 0, List.of(42)), Arguments.of(-20, 4, List.of(55, 24, 62, 0, -20)),
				Arguments.of(3, 2, List.of(1, 2, 3)), Arguments.of(1000, 0, List.of(1000)));
	}

	private static Stream<Arguments> provideBinarySearchArrays() {
		return Stream.of(Arguments.of(1, 0, List.of(1, 2, 3)), Arguments.of(4, -1, List.of(1, 2, 3)),
				Arguments.of(-42, 0, List.of(-42, 22, 0, 55)), Arguments.of(1, 0, List.of(1)),
				Arguments.of(11, 7, List.of(1, 1, 1, 1, 1, 1, 1, 11)));
	}

	private static Stream<Arguments> provideStringArrays() {
		return Stream.of(Arguments.of("cat", 0, List.of("cat", "dog")),
				Arguments.of("Karen", 2, List.of("Bob", "Jill", "Karen", "Tom")),
				Arguments.of("Ruby", 4, List.of("C", "Haskell", "Java", "Javascript", "Ruby")),
				Arguments.of("Scala", -1, List.of("C", "Haskell", "Java", "Javascript", "Ruby")));

	}

	private static Stream<Arguments> provideDogArrays() {
		return Stream.of(Arguments.of(new Dog(1), 0, List.of(new Dog(1), new Dog(2), new Dog(3))),
				Arguments.of(new Dog(5), 3, List.of(new Dog(1), new Dog(2), new Dog(3), new Dog(5))),
				Arguments.of(new Dog(9), 1, List.of(new Dog(1), new Dog(9), new Dog(9), new Dog(9))),
				Arguments.of(new Dog(21), 2, List.of(new Dog(1), new Dog(2), new Dog(21), new Dog(50))),
				Arguments.of(new Dog(-40), 0, List.of(new Dog(-40), new Dog(-25), new Dog(-20), new Dog(5))),
				Arguments.of(new Dog(99), -1, List.of(new Dog(-40), new Dog(-25), new Dog(-20), new Dog(5))));
	}

	@ParameterizedTest
	@MethodSource("provideDogArrays")
	void sequentialSearch_null1arg_throwsexception(Dog searchFor, int expectedIndex, List<Dog> arr) {
		Assert.assertThrows(abExceptions.NullArgumentException.class, () -> {
			Search.linearSearch(null, arr);
		});
	}

	@ParameterizedTest
	@MethodSource("provideDogArrays")
	void sequentialSearch_null2arg_throwsexception(Dog searchFor, int expectedIndex, List<Dog> arr) {
		Assert.assertThrows(abExceptions.NullArgumentException.class, () -> {
			Search.linearSearch(searchFor, null);
		});
	}

	@ParameterizedTest
	@MethodSource("provideSequentialSearchArrays")
	public void sequentialSearch_ints_ShouldReturnExpected(int searchFor, int expectedIndex, List<Integer> arr) {
		try {
			assertEquals(Search.linearSearch(searchFor, arr), expectedIndex);
		} catch (NullArgumentException e) {
			e.printStackTrace();
		}
	}

	@ParameterizedTest
	@MethodSource("provideStringArrays")
	public void sequentialSearch__strings_ShouldReturnExpected(String searchFor, int expectedIndex, List<String> arr) {
		try {
			assertEquals(Search.linearSearch(searchFor, arr), expectedIndex);
		} catch (NullArgumentException e) {
			e.printStackTrace();
		}
	}

	@ParameterizedTest
	@MethodSource("provideDogArrays")
	public void sequentialSearch__dogs_ShouldReturnExpected(Dog searchFor, int expectedIndex, List<Dog> arr) {
		try {
			assertEquals(Search.linearSearch(searchFor, arr), expectedIndex);
		} catch (NullArgumentException e) {
			e.printStackTrace();
		}
	}

	@ParameterizedTest
	@MethodSource("provideDogArrays")
	void iBinarySearch_null1arg_throwsexception(Dog searchFor, int expectedIndex, List<Dog> arr) {
		Assert.assertThrows(abExceptions.NullArgumentException.class, () -> {
			Search.iterativeBinarySearch(null, arr);
		});
	}

	@ParameterizedTest
	@MethodSource("provideDogArrays")
	void iBinarySearch_null2arg_throwsexception(Dog searchFor, int expectedIndex, List<Dog> arr) {
		Assert.assertThrows(abExceptions.NullArgumentException.class, () -> {
			Search.iterativeBinarySearch(searchFor, null);
		});
	}

	@ParameterizedTest
	@MethodSource("provideBinarySearchArrays")
	public void iBinarySearch_ShouldReturnExpected(int searchFor, int expectedIndex, List<Integer> arr) {
		try {
			assertEquals(expectedIndex, Search.iterativeBinarySearch(searchFor, arr));
		} catch (NullArgumentException e) {
			e.printStackTrace();
		}
	}

	@ParameterizedTest
	@MethodSource("provideStringArrays")
	public void iBinarySearch__strings_ShouldReturnExpected(String searchFor, int expectedIndex, List<String> arr) {
		try {
			assertEquals(Search.iterativeBinarySearch(searchFor, arr), expectedIndex);
		} catch (NullArgumentException e) {
			e.printStackTrace();
		}
	}

	@ParameterizedTest
	@MethodSource("provideDogArrays")
	public void iBinarySearch__dogs_ShouldReturnExpected(Dog searchFor, int expectedIndex, List<Dog> arr) {
		try {
			assertEquals(Search.iterativeBinarySearch(searchFor, arr), expectedIndex);
		} catch (NullArgumentException e) {
			e.printStackTrace();
		}
	}

	@ParameterizedTest
	@MethodSource("provideDogArrays")
	void rBinarySearch_null1arg_throwsexception(Dog searchFor, int expectedIndex, List<Dog> arr) {
		Assert.assertThrows(abExceptions.NullArgumentException.class, () -> {
			Search.recursiveBinarySearch(null, arr);
		});
	}

	@ParameterizedTest
	@MethodSource("provideDogArrays")
	void rBinarySearch_null2arg_throwsexception(Dog searchFor, int expectedIndex, List<Dog> arr) {
		Assert.assertThrows(abExceptions.NullArgumentException.class, () -> {
			Search.recursiveBinarySearch(searchFor, null);
		});
	}

	@ParameterizedTest
	@MethodSource("provideBinarySearchArrays")
	public void rBinarySearch_ShouldReturnExpected(int searchFor, int expectedIndex, List<Integer> arr) {
		try {
			assertEquals(expectedIndex, Search.recursiveBinarySearch(searchFor, arr));
		} catch (NullArgumentException e) {
			e.printStackTrace();
		}
	}

	@ParameterizedTest
	@MethodSource("provideStringArrays")
	public void rBinarySearch__strings_ShouldReturnExpected(String searchFor, int expectedIndex, List<String> arr) {
		try {
			assertEquals(Search.recursiveBinarySearch(searchFor, arr), expectedIndex);
		} catch (NullArgumentException e) {
			e.printStackTrace();
		}
	}

	@ParameterizedTest
	@MethodSource("provideDogArrays")
	public void rBinarySearch_dogs_ShouldReturnExpected(Dog searchFor, int expectedIndex, List<Dog> arr) {
		try {
			assertEquals(Search.recursiveBinarySearch(searchFor, arr), expectedIndex);
		} catch (NullArgumentException e) {
			e.printStackTrace();
		}
	}
}
