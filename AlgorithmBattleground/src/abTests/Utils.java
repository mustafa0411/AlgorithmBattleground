package abTests;

import java.util.Collections;
import java.util.List;

import org.junit.Assert;

public class Utils {

	public static <E extends Comparable<E>> void assertListHasBeenSortedAscending(List<E> original,
			List<E> customSort) {
		original.sort(E::compareTo);
		Assert.assertArrayEquals(original.toArray(), customSort.toArray());
	}

	public static <E extends Comparable<E>> void assertListHasBeenSortedDescending(List<E> original,
			List<E> customSort) {
		original.sort(E::compareTo);
		Collections.reverse(original);
		Assert.assertArrayEquals(original.toArray(), customSort.toArray());
	}
}
