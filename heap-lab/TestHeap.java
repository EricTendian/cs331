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
}
