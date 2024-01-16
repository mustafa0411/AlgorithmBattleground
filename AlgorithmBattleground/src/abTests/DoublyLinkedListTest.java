package abTests;

import static org.junit.Assert.assertFalse;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import abLists.DoublyLinkedList;

class DoublyLinkedListTest {
	@Test
	void contains_nullarg_throwsexception() {
		Assert.assertThrows(NullPointerException.class, () -> {
			var list = new DoublyLinkedList<Integer>();
			list.contains(null);
		});
	}

	@Test
	void add_nullarg_throwsexception() {
		Assert.assertThrows(NullPointerException.class, () -> {
			var list = new DoublyLinkedList<Integer>();
			list.add(null);
		});
	}

	@Test
	void remove_nullarg_throwsexception() {
		Assert.assertThrows(NullPointerException.class, () -> {
			var list = new DoublyLinkedList<Integer>();
			list.remove(null);
		});
	}

	@Test
	void remove_atIndex_nullarg_throwsexception() {
		Assert.assertThrows(IndexOutOfBoundsException.class, () -> {
			var list = new DoublyLinkedList<Integer>();
			list.remove(1);
		});
	}

	@Test
	void addAll_nullarg_throwsexception() {
		Assert.assertThrows(NullPointerException.class, () -> {
			var list = new DoublyLinkedList<Integer>();
			list.addAll(null);
		});
	}

	@Test
	void add_atIndex_nullarg_throwsexception() {
		Assert.assertThrows(NullPointerException.class, () -> {
			var list = new DoublyLinkedList<Integer>();
			list.add(0, null);
		});
	}

	@Test
	void addAll_atIndex_nullarg_throwsexception() {
		Assert.assertThrows(NullPointerException.class, () -> {
			var list = new DoublyLinkedList<Integer>();
			list.addAll(0, null);
		});
	}

	@Test
	void add_atIndex_badindex_throwsexception() {
		Assert.assertThrows(IndexOutOfBoundsException.class, () -> {
			var list = new DoublyLinkedList<Integer>();
			list.add(10, 5);
		});
	}

	@Test
	void addAll_atIndex_badindex_throwsexception() {
		Assert.assertThrows(IndexOutOfBoundsException.class, () -> {
			var list = new DoublyLinkedList<Integer>();
			list.addAll(-1, List.of(5, 1, 3));
		});
	}

	@Test
	void get_badindex_throwsexception() {
		Assert.assertThrows(IndexOutOfBoundsException.class, () -> {
			var list = new DoublyLinkedList<Integer>();
			list.get(4);
		});
	}

	@Test
	void set_badindex_throwsexception() {
		Assert.assertThrows(IndexOutOfBoundsException.class, () -> {
			var list = new DoublyLinkedList<Integer>();
			list.set(4, 4);
		});
	}

	@Test
	void set_nullarg_throwsexception() {
		Assert.assertThrows(NullPointerException.class, () -> {
			var list = new DoublyLinkedList<Integer>();
			list.set(0, null);
		});
	}

	@Test
	void indexOf_nullarg_throwsexception() {
		Assert.assertThrows(NullPointerException.class, () -> {
			var list = new DoublyLinkedList<Integer>();
			list.indexOf(null);
		});
	}

	@Test
	void lastIndexOf_nullarg_throwsexception() {
		Assert.assertThrows(NullPointerException.class, () -> {
			var list = new DoublyLinkedList<Integer>();
			list.lastIndexOf(null);
		});
	}

	@Test
	void add_ExpectListSizeToIncreaseBy1() {
		var list = new DoublyLinkedList<Integer>();
		var expectedSize = 1;

		list.add(5);

		assertEquals(expectedSize, list.size());
	}

	@Test
	void add_addTwo_ExpectListSizeToIncreaseBy2() {
		var list = new DoublyLinkedList<Integer>();
		var expectedSize = 2;

		list.add(5);
		list.add(10);

		assertEquals(expectedSize, list.size());
	}

	@Test
	void add_addThree_ExpectThemAddedToEnd() {
		var list = new DoublyLinkedList<Integer>();
		var expectedOrder = List.of(5, 10, 15);

		list.add(5);
		list.add(10);
		list.add(15);

		assertEquals(expectedOrder, list);
	}

	@Test
	void add_atSpecificIndex_ExpectIndexToContainValue() {
		var list = new DoublyLinkedList<String>();
		var expectedSize = 3;

		list.add("Hello");
		list.add("World");
		list.add(1, ", ");

		assertEquals(expectedSize, list.size());
		assertEquals(", ", list.get(1));

	}

	@Test
	void add_atIndex0_ExpectListInReverseOrder() {
		var list = new DoublyLinkedList<String>();
		var expectedOrder = List.of("Geralt", "of", "Rivia");

		list.add(0, "Rivia");
		list.add(0, "of");
		list.add(0, "Geralt");

		assertEquals(expectedOrder, list);
	}

	@Test
	void add_atEnd_CheckTail() {
		var list = new DoublyLinkedList<String>();

		list.add("Hello");
		list.add("World");
		list.add(2, "!");
		list.add("?");
		assertEquals("!", list.get(2));
	}

	@Test
	void addAll_atEnd_CheckTail() {
		var list = new DoublyLinkedList<String>();
		var toAdd = List.of(",", "World");
		list.add("Hello");
		list.add("?");
		list.addAll(2, toAdd);
		list.add("!");
		assertEquals("!", list.get(4));
	}

	@Test
	void addAll_ShouldAddAllItemsToEnd() {
		var list = new DoublyLinkedList<Integer>();
		var toAdd = List.of(3, 4, 5, 6);
		var expectedSize = 6;

		list.add(1);
		list.add(2);
		list.addAll(toAdd);

		assertEquals(expectedSize, list.size());
		var added = list.subList(2, 6);

		assertEquals(toAdd, added);
	}

	@Test
	void addAll_AtSpecificIndex_ShouldAddAllItemsAtIndex() {
		var list = new DoublyLinkedList<Integer>();
		var toAdd = List.of(3, 4, 5, 6);
		var expectedSize = 6;

		list.add(1);
		list.add(2);
		list.addAll(1, toAdd);

		assertEquals(expectedSize, list.size());
		var added = list.subList(1, 5);
		assertEquals(toAdd, added);
	}

	@Test
	void clear_ShouldMakeListSizeZero() {
		var list = new DoublyLinkedList<Integer>();
		var expectedSize = 0;

		list.add(1);
		list.add(2);
		list.clear();

		assertEquals(expectedSize, list.size());
	}

	@Test
	void contains_ItemIsInList_ShouldReturnTrue() {
		var list = new DoublyLinkedList<String>();
		var item = "42";

		list.add(String.valueOf(item));
		list.add("Hello World");

		assertTrue(list.contains(item));
	}

	@Test
	void contains_ItemIsNotInList_ShouldReturnFalse() {
		var list = new DoublyLinkedList<String>();
		var item = "42";

		list.add("39");
		list.add("Hello World");

		assertFalse(list.contains(item));
	}

	@Test
	void indexOf_ItemIsInList_ShouldReturnIndex() {
		var list = new DoublyLinkedList<Integer>();
		var expectedIndex = 4;
		var value = 42;
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(value);
		list.add(5);

		assertEquals(expectedIndex, list.indexOf(value));
	}

	@Test
	void indexOf_ItemIsNotInList_ShouldReturnNegative1() {
		var list = new DoublyLinkedList<Integer>();
		var expectedIndex = -1;
		var value = 39;
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		assertEquals(expectedIndex, list.indexOf(value));
	}

	@Test
	void isEmpty_EmptyList_ShouldReturnTrue() {
		var list = new DoublyLinkedList<String>();

		assertTrue(list.isEmpty());
	}

	@Test
	void isEmpty_ListHasItems_ShouldReturnFalse() {
		var list = new DoublyLinkedList<String>();
		list.add("hello");
		list.add("world");

		assertFalse(list.isEmpty());
	}

	@Test
	void lastIndexOf_ItemAppearsMultipleTimes_ShouldReturnIndex() {
		var list = new DoublyLinkedList<Integer>();
		var expectedIndex = 5;
		var value = 42;
		var toAdd = List.of(0, 1, value, value, 4, value, 6, 7, 8, 9, 10);

		list.addAll(toAdd);

		assertEquals(expectedIndex, list.lastIndexOf(value));
	}

	@Test
	void lastIndexOf_ItemDoesNotAppear_ShouldReturnIndex() {
		var list = new DoublyLinkedList<Integer>();
		var expectedIndex = -1;
		var value = 42;
		var toAdd = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		list.addAll(toAdd);

		assertEquals(expectedIndex, list.lastIndexOf(value));
	}

	@Test
	void remove_Index_ShouldRemoveItemAtIndex() {
		var list = new DoublyLinkedList<String>();
		var removeAt = 0;
		var value = "hello";
		var toAdd = List.of(value, "world", "I'm", "java");
		list.addAll(toAdd);
		var sizeBeforeRemove = list.size();

		var valueBeforeRemove = list.get(removeAt);
		var removed = list.remove(removeAt);
		var valueAfterRemove = list.get(removeAt);

		assertEquals(value, removed);
		assertNotEquals(valueBeforeRemove, valueAfterRemove);
		assertEquals(sizeBeforeRemove - 1, list.size());
	}

	@Test
	void remove_ObjectParam_ShouldReturnTrue() {
		var list = new DoublyLinkedList<String>();
		var removeAt = 0;
		var value = "hello";
		var toAdd = List.of(value, "world", "I'm", "java");
		list.addAll(toAdd);
		var sizeBeforeRemove = list.size();

		var valueBeforeRemove = list.get(removeAt);
		assertTrue(list.remove(value));
		var valueAfterRemove = list.get(removeAt);

		assertNotEquals(valueBeforeRemove, valueAfterRemove);
		assertEquals(sizeBeforeRemove - 1, list.size());
	}

	@Test
	void iterator_EmptyListHasNext_ShouldReturnFalse() {
		var list = new DoublyLinkedList<String>();
		Iterator<String> itr = list.iterator();
		assertFalse(itr.hasNext());
	}

	@Test
	void iterator_FullListHasNext_ShouldReturnTrue() {
		var list = new DoublyLinkedList<String>();
		var toAdd = List.of("Sterling", "Goodfellow", "Iacas", "Tonwen");
		list.addAll(toAdd);
		Iterator<String> itr = list.iterator();
		assertTrue(itr.hasNext());
	}

	@Test
	void iterator_FullListNext_ShouldGetItem() {
		var list = new DoublyLinkedList<String>();
		var toAdd = List.of("Sterling", "Goodfellow", "Iacas", "Tonwen");
		list.addAll(toAdd);
		Iterator<String> itrToAdd = toAdd.iterator();
		for (String element : list)
			assertEquals(element, itrToAdd.next());
	}

	@Test
	void iterator_FullListHasPrev_ShouldReturnFalse() {
		var list = new DoublyLinkedList<String>();
		var toAdd = List.of("Sterling", "Goodfellow", "Iacas", "Tonwen");
		list.addAll(toAdd);
		ListIterator<String> itr = list.listIterator();
		assertFalse(itr.hasPrevious());
	}

	@Test
	void iterator_FullListHasPrev_ShouldReturnTrue() {
		var list = new DoublyLinkedList<String>();
		var toAdd = List.of("Sterling", "Goodfellow", "Iacas", "Tonwen");
		list.addAll(toAdd);
		ListIterator<String> itr = list.listIterator();
		itr.next();
		assertTrue(itr.hasPrevious());
	}

	@Test
	void iterator_FullListWithAddAllPrev_ShouldGetItem() {
		var list = new DoublyLinkedList<String>();
		var toAdd = List.of("Sterling", "Goodfellow", "Iacas", "Tonwen");
		list.addAll(toAdd);
		ListIterator<String> itr = list.listIterator();
		itr.next();
		itr.next();
		itr.next();
		itr.next();
		assertFalse(itr.hasNext());
		assertEquals(itr.previous(), "Tonwen");
		assertEquals(itr.previous(), "Iacas");
		assertEquals(itr.previous(), "Goodfellow");
		assertEquals(itr.previous(), "Sterling");
		assertFalse(itr.hasPrevious());
	}

	@Test
	void iterator_FullListWithAddIndexPrev_ShouldGetItem() {
		var list = new DoublyLinkedList<String>();
		list.add(0, "Sterling");
		list.add(0, "Goodfellow");
		list.add(0, "Iacas");
		list.add(0, "Tonwen");
		ListIterator<String> itr = list.listIterator();
		itr.next();
		itr.next();
		itr.next();
		itr.next();
		assertFalse(itr.hasNext());
		assertEquals(itr.previous(), "Sterling");
		assertEquals(itr.previous(), "Goodfellow");
		assertEquals(itr.previous(), "Iacas");
		assertEquals(itr.previous(), "Tonwen");
		assertFalse(itr.hasPrevious());
	}

	@Test
	void iterator_FullListWithAddAllIndexPrev_ShouldGetItem() {
		var list = new DoublyLinkedList<String>();
		list.add(0, "Tonwen");
		var toAdd = List.of("Sterling", "Goodfellow", "Iacas");
		list.addAll(0, toAdd);
		ListIterator<String> itr = list.listIterator();
		itr.next();
		itr.next();
		itr.next();
		itr.next();
		assertFalse(itr.hasNext());
		assertEquals(itr.previous(), "Tonwen");
		assertEquals(itr.previous(), "Iacas");
		assertEquals(itr.previous(), "Goodfellow");
		assertEquals(itr.previous(), "Sterling");
		assertFalse(itr.hasPrevious());
	}

	@Test
	void iterator_FullListWithRemoveIndexHeadPrev_ShouldGetItem() {
		var list = new DoublyLinkedList<String>();
		var toAdd = List.of("Sterling", "Goodfellow", "Iacas", "Tonwen");
		list.addAll(toAdd);
		list.remove(0);
		ListIterator<String> itr = list.listIterator();
		itr.next();
		itr.next();
		itr.next();
		assertFalse(itr.hasNext());
		assertEquals(itr.previous(), "Tonwen");
		assertEquals(itr.previous(), "Iacas");
		assertEquals(itr.previous(), "Goodfellow");
		assertFalse(itr.hasPrevious());
	}

	@Test
	void iterator_FullListWithRemoveIndexPrev_ShouldGetItem() {
		var list = new DoublyLinkedList<String>();
		var toAdd = List.of("Sterling", "Goodfellow", "Iacas", "Tonwen");
		list.addAll(toAdd);
		list.remove(1);
		ListIterator<String> itr = list.listIterator();
		itr.next();
		itr.next();
		itr.next();
		assertFalse(itr.hasNext());
		assertEquals(itr.previous(), "Tonwen");
		assertEquals(itr.previous(), "Iacas");
		assertEquals(itr.previous(), "Sterling");
		assertFalse(itr.hasPrevious());
	}

	@Test
	void iterator_FullListWithRemoveHeadPrev_ShouldGetItem() {
		var list = new DoublyLinkedList<String>();
		var toAdd = List.of("Sterling", "Goodfellow", "Iacas", "Tonwen");
		list.addAll(toAdd);
		list.remove("Sterling");
		ListIterator<String> itr = list.listIterator();
		itr.next();
		itr.next();
		itr.next();
		assertFalse(itr.hasNext());
		assertEquals(itr.previous(), "Tonwen");
		assertEquals(itr.previous(), "Iacas");
		assertEquals(itr.previous(), "Goodfellow");
		assertFalse(itr.hasPrevious());
	}

	@Test
	void iterator_FullListWithRemoveTailPrev_ShouldGetItem() {
		var list = new DoublyLinkedList<String>();
		var toAdd = List.of("Sterling", "Goodfellow", "Iacas", "Tonwen");
		list.addAll(toAdd);
		list.remove("Tonwen");
		ListIterator<String> itr = list.listIterator();
		itr.next();
		itr.next();
		itr.next();
		assertFalse(itr.hasNext());
		assertEquals(itr.previous(), "Iacas");
		assertEquals(itr.previous(), "Goodfellow");
		assertEquals(itr.previous(), "Sterling");
		assertFalse(itr.hasPrevious());
	}
}
