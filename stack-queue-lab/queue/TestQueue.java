import junit.framework.*;

public class TestQueue extends TestCase {
    public Integer i1 = new Integer(1);
    public Integer i2 = new Integer(2);
    public Integer i5 = new Integer(5);
    public Integer i10 = new Integer(10);
    public Integer i15 = new Integer(15);
    public Integer i20 = new Integer(20);
    public Integer i25 = new Integer(25);

    public TestQueue(String name) {
	super(name);
    }

    public void testEmpty() {
        Queue<Integer> foo = new Queue<Integer>();
        assertEquals("Empty Size Test 1",0,foo.size());
	assertEquals("Empty Remove Test",null,foo.dequeue());
	assertEquals("Empty Size Test 2",0,foo.size());
        assertEquals("Empty Front Test",null,foo.front());
    }
    
    public void testEnqueue() {
        Queue<Integer> foo = new Queue<Integer>();
        
        foo.enqueue(i1);
        assertEquals("Size Test 1",1,foo.size());
        assertEquals("Front Test 1",i1,foo.front());
        
        foo.enqueue(i2);
        foo.enqueue(i5);
        foo.enqueue(i10);
        assertEquals("Size Test 2",4,foo.size());
        assertEquals("Front Test 2",i1,foo.front());
    }
    
    public void testDequeue() {
        Queue<Integer> foo = new Queue<Integer>();
        
        foo.enqueue(i1);
        foo.enqueue(i2);
        foo.enqueue(i5);
        foo.enqueue(i10);
        assertEquals("Size Test 1",4,foo.size());
        assertEquals("Front Test 1",i1,foo.front());
        
        assertEquals("Dequeue Test 1",i1,foo.dequeue());
        assertEquals("Front Test 2",i2,foo.front());
        assertEquals("Size Test 2",3,foo.size());
        
        assertEquals("Dequeue Test 2",i2,foo.dequeue());
        assertEquals("Front Test 3",i5,foo.front());
        assertEquals("Size Test 3",2,foo.size());
    }
}
