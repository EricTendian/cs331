import junit.framework.*;

public class TestHeap extends TestCase {
    public TestHeap(String name) {
        super(name);
    }

    public void testOne() {
        Heap heap = new Heap();
        heap.enqueue(4);
        assertEquals("size is incremented", 1, heap.size());
        assertEquals("correct item", 4, heap.top());
        heap.dequeue();
        assertEquals("size is decremented", 0, heap.size());
        heap.dequeue();
        assertEquals("size is not negative", 0, heap.size());
    }
    
    public void testMultiple() {
        Heap heap = new Heap();
        heap.enqueue(1);
        assertEquals("correct item", 1, heap.top());
        heap.enqueue(3);
        assertEquals("correct item", 1, heap.top());
        heap.enqueue(6);
        assertEquals("correct item", 1, heap.top());
        heap.enqueue(5);
        assertEquals("correct item", 1, heap.top());
        heap.enqueue(9);
        assertEquals("correct item", 1, heap.top());
        heap.enqueue(8);
        assertEquals("correct item", 1, heap.top());
        assertEquals("size is incremented", 6, heap.size());
        
        assertEquals("correct element dequeued", 1, heap.dequeue());
        assertEquals("correct element dequeued", 8, heap.dequeue());
        assertEquals("correct element dequeued", 9, heap.dequeue());
        assertEquals("correct element dequeued", 5, heap.dequeue());
        assertEquals("correct element dequeued", 6, heap.dequeue());
        assertEquals("correct element dequeued", 3, heap.dequeue());
        assertEquals("size is decremented", 6, heap.size());
    }
}
