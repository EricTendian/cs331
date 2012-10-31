import junit.framework.*;

public class TestList extends TestCase {
    public Integer i1 = new Integer(1);
    public Integer i2 = new Integer(2);
    public Integer i5 = new Integer(5);
    public Integer i10 = new Integer(10);
    public Integer i15 = new Integer(15);
    public Integer i20 = new Integer(20);
    public Integer i25 = new Integer(25);

    public TestList(String name) {
	super(name);
    }

    public void testInsertAtEnd() {

	// Create new list.  Is it empty?

	List<Integer> foo = new List<Integer>();
	assertEquals("Empty Size Test 1",0,foo.size());
	assertEquals("Empty Remove Test",null,foo.removeFromFront());
	assertEquals("Empty Size Test 2",0,foo.size());

	// Insert one item

	foo.insertAtEnd(i10);

	assertEquals("i10 Size Test",1,foo.size());
	assertEquals("i10 Find Test 1",1,foo.find(i10)); 
	assertEquals("i10 Find Test 2",0,foo.find(i15)); 
	assertEquals("i10 Remove Test",i10,foo.removeFromFront());
	assertEquals("Empty Size Test 3",0,foo.size());

	// Insert three items

	foo.insertAtEnd(i2);
	foo.insertAtEnd(i5);
	foo.insertAtEnd(i20);

	assertEquals("i2 i5 i20 Size Test",3,foo.size());
	assertEquals("i2 i5 i20 Find Test 1",0,foo.find(i10)); 
	assertEquals("i2 i5 i20 Find Test 2",3,foo.find(i20)); 
	assertEquals("i2 i5 i20 Find Test 3",1,foo.find(i2)); 
	assertEquals("i2 i5 i20 Find Test 4",2,foo.find(i5)); 

	assertEquals("i2 i5 i20 Remove Test",i2,foo.removeFromFront());

	assertEquals("i5 i20 Size Test",2,foo.size());
	assertEquals("i5 i20 Find Test 1",0,foo.find(i10)); 
	assertEquals("i5 i20 Find Test 2",2,foo.find(i20)); 
	assertEquals("i5 i20 Find Test 3",0,foo.find(i2)); 
	assertEquals("i5 i20 Find Test 4",1,foo.find(i5)); 

	assertEquals("i5 i20 Remove Test",i5,foo.removeFromFront());

	assertEquals("i20 Size Test",1,foo.size());
	assertEquals("i20 Find Test 1",0,foo.find(i10)); 
	assertEquals("i20 Find Test 2",1,foo.find(i20)); 
	assertEquals("i20 Find Test 3",0,foo.find(i2)); 
	assertEquals("i20 Find Test 4",0,foo.find(i5)); 

	assertEquals("i20 Remove Test",i20,foo.removeFromFront());
	assertEquals("Empty Size Test 4",0,foo.size());
	assertEquals("Empty Find Test 5",0,foo.find(i10)); 
	assertEquals("Empty Find Test 6",0,foo.find(i20)); 
	assertEquals("Empty Find Test 7",0,foo.find(i2)); 
	assertEquals("Empty Find Test 8",0,foo.find(i5)); 
    }

    public void testInsertAtFront() {

	// Create new list.  Is it empty?

	List<Integer> foo = new List<Integer>();
	assertEquals("Empty Size Test 1",0,foo.size());
	assertEquals("Empty Remove Test",null,foo.removeFromFront());
	assertEquals("Empty Size Test 2",0,foo.size());

	// Insert one item

	foo.insertAtFront(i10);

	assertEquals("i10 Size Test",1,foo.size());
	assertEquals("i10 Find Test 1",1,foo.find(i10)); 
	assertEquals("i10 Find Test 2",0,foo.find(i15)); 
	assertEquals("i10 Remove Test",i10,foo.removeFromFront());
	assertEquals("Empty Size Test 3",0,foo.size());

	// Insert three items

	foo.insertAtFront(i2);
	foo.insertAtFront(i5);
	foo.insertAtFront(i20);

	assertEquals("i20 i5 i2 Size Test",3,foo.size());
	assertEquals("i20 i5 i2 Find Test 1",0,foo.find(i10)); 
	assertEquals("i20 i5 i2 Find Test 2",1,foo.find(i20)); 
	assertEquals("i20 i5 i2 Find Test 3",3,foo.find(i2)); 
	assertEquals("i20 i5 i2 Find Test 4",2,foo.find(i5)); 

	assertEquals("i20 i5 i2 Remove Test",i20,foo.removeFromFront());

	assertEquals("i5 i2 Size Test",2,foo.size());
	assertEquals("i5 i2 Find Test 1",0,foo.find(i10)); 
	assertEquals("i5 i2 Find Test 2",0,foo.find(i20)); 
	assertEquals("i5 i2 Find Test 3",2,foo.find(i2)); 
	assertEquals("i5 i2 Find Test 4",1,foo.find(i5)); 

	assertEquals("i5 i2 Remove Test",i5,foo.removeFromFront());

	assertEquals("i2 Size Test",1,foo.size());
	assertEquals("i2 Find Test 1",0,foo.find(i10)); 
	assertEquals("i2 Find Test 2",0,foo.find(i20)); 
	assertEquals("i2 Find Test 3",1,foo.find(i2)); 
	assertEquals("i2 Find Test 4",0,foo.find(i5)); 

	assertEquals("i2 Remove Test",i2,foo.removeFromFront());
	assertEquals("Empty Size Test 4",0,foo.size());
	assertEquals("Empty Find Test 5",0,foo.find(i10)); 
	assertEquals("Empty Find Test 6",0,foo.find(i20)); 
	assertEquals("Empty Find Test 7",0,foo.find(i2)); 
	assertEquals("Empty Find Test 8",0,foo.find(i5)); 
    }

}
