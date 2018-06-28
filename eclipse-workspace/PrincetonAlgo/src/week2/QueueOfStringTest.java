package week2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class QueueOfStringTest {
	public ArrayQueue q;
	
	@BeforeEach
	void prepare() {
		q = new ArrayQueue();		
	}
	
	@Test
	@DisplayName("isEmpty should return null when empty")
	void test_isEmpty() {
		assertEquals(q.isEmpty(),true);
		q.enqueue("hello");
		assertEquals(q.isEmpty(),false);
	}
	
	@Test
	@DisplayName("size of list should increase as elements are queued")
	void test_size_increase() {
		assertEquals(q.size(),0);
		q.enqueue("Hello");
		assertEquals(q.size(),1);
		q.enqueue("World");
		assertEquals(q.size(),2);
	}
	
	@Test
	@DisplayName("size of list should decrease as elements are dequeued")
	void test_size_derease() {
		q.enqueue("Hello");
		q.enqueue("Hello");
		q.enqueue("Hello");
		q.enqueue("Hello");
		assertEquals(q.size(),4);
		q.dequeue();
		q.dequeue();
		assertEquals(q.size(),2);
	}
	
	@Test
	@DisplayName("dequeue should return items in the order they were queued")
	void test_dequeue() {
		q.enqueue("1");
		q.enqueue("2");
		q.enqueue("3");
		q.enqueue("4");
		assertEquals(q.dequeue(),"1");
		assertEquals(q.dequeue(),"2");
		assertEquals(q.dequeue(),"3");
		assertEquals(q.dequeue(),"4");
	}
	
	@Test
	@DisplayName("dequeue should return 'null' if the queue is empty")
	void test_dequeue_whenEmpty() {
		assertEquals(q.dequeue(),null);
	}
	
	@Test
	@DisplayName("checking for edge case: dequeue all and requeue")
	void test_edge_case() {
		q.enqueue("1");
		q.enqueue("1");
		q.enqueue("1");
		q.enqueue("1");
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.enqueue("1");
		q.enqueue("1");
		q.enqueue("1");
		q.enqueue("1");
		q.enqueue("1");
		assertEquals(q.printQueue(),"1 1 1 1 1 null null null ");
	}
	
	@Test
	@DisplayName("checking for edge case: head should not pass tail on dequeue")
	void test_edge_case_head_vs_tail() {
		q.enqueue("1");
		q.enqueue("1");
		q.enqueue("1");
		q.enqueue("1");
		q.enqueue("1");
		q.enqueue("1");
		q.enqueue("1");
		q.enqueue("1");
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		assertTrue(q.isEmpty());
		assertEquals(q.getHead(),q.getTail());
	}
}
