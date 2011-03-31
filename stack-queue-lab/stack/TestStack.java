import junit.framework.*;

public class TestStack extends TestCase {
    public Integer i1 = new Integer(1);
    public Integer i2 = new Integer(2);
    public Integer i5 = new Integer(5);
    public Integer i10 = new Integer(10);
    public Integer i15 = new Integer(15);
    public Integer i20 = new Integer(20);
    public Integer i25 = new Integer(25);

    public TestStack(String name) {
	super(name);
    }

    public void testEmpty() {
        Stack<Integer> foo = new Stack<Integer>();
        assertEquals("Empty Size Test 1",0,foo.size());
	assertEquals("Empty Pop Test",null,foo.pop());
	assertEquals("Empty Size Test 2",0,foo.size());
        assertEquals("Empty Top Test",null,foo.top());
    }
    
    public void testPush() {
        Stack<Integer> foo = new Stack<Integer>();
        
        foo.push(i1);
        assertEquals("Size Test 1",1,foo.size());
        assertEquals("Top Test 1",i1,foo.top());
        
        foo.push(i2);
        foo.push(i5);
        foo.push(i10);
        assertEquals("Size Test 2",4,foo.size());
        assertEquals("Top Test 2",i10,foo.top());
    }
    
    public void testPop() {
        Stack<Integer> foo = new Stack<Integer>();
        
        foo.push(i1);
        foo.push(i2);
        foo.push(i5);
        foo.push(i10);
        assertEquals("Size Test 1",4,foo.size());
        assertEquals("Top Test 1",i10,foo.top());
        
        assertEquals("Pop Test 1",i10,foo.pop());
        assertEquals("Size Test 2",3,foo.size());
        assertEquals("Top Test 2",i5,foo.top());
        
        assertEquals("Pop Test 2",i5,foo.pop());
        assertEquals("Top Test 3",i2,foo.top());
        assertEquals("Size Test 3",2,foo.size());
    }
}
