package abTests;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import abLists.Node;

class NodeTest {

	@Test
	void constructor_WorksAsExpected() {
		var x = 5;
		var node = new Node<Integer>(x);
		assertEquals(x, node.getItem().intValue());
	}

	@Test
	void createNode_WorksAsExpected() {
		var x = 5;
		var node = Node.createNode(x);
		assertEquals(x, node.getItem().intValue());
	}

	@Test
	void constructor_WithNext_WorksAsExpected() {
		var n2 = Node.createNode(5);
		var n1 = new Node<Integer>(10, n2);

		var next = n1.getNext();

		assertEquals(n2, next);
	}

	@Test
	void createNode_WithNext_WorksAsExpected() {
		var n2 = Node.createNode(5);
		var n1 = Node.createNode(10, n2);

		var next = n1.getNext();

		assertEquals(n2, next);
	}

	@Test
	void setNext_WorksAsExpected() {
		var n1 = Node.createNode(5);
		var n2 = Node.createNode(10);

		n1.setNext(n2);

		var next = n1.getNext();

		assertEquals(n2, next);
	}

	@Test
	void hasNext_NoNextSet_ShouldReturnFalse() {
		var n1 = Node.createNode(5);

		assertFalse(n1.hasNext());
	}

	@Test
	void hasNext_NextIsSet_ShouldReturnFalse() {
		var n1 = Node.createNode(5, Node.createNode(10));

		assertTrue(n1.hasNext());
	}
}
