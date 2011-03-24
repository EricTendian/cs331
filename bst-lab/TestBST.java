// $Id: TestList.java 75 2005-10-09 14:19:45Z beckman $

import junit.framework.*;

public class TestBST extends TestCase {
    public String n1 = "Jenny";
    public String n2 = "Empire";
    public String n3 = "Emergency";
    public String n4 = "Helpdesk";
    public String n5 = "Information";

    public Integer i1 = new Integer(8675309);
    public Integer i2 = new Integer(5882300);
    public Integer i3 = new Integer(911);
    public Integer i4 = new Integer(5673375);
    public Integer i5 = new Integer(5551212);

    public TestBST(String name) {
	super(name);
    }

    public void testRoot() {
	BST<String,Integer> bst = new BST<String,Integer>();
	assertEquals("1. create",0,bst.size());
        bst.add(n1,i1);
        assertEquals("size incremented",1,bst.size());
        assertEquals("finds value",i1,bst.find(n1));
        assertEquals("finds key",n1,bst.revFind(i1));
        bst.delete(n1);
        assertEquals("size decremented",0,bst.size());
        assertEquals("finds value",null,bst.find(n1));
        assertEquals("finds key",null,bst.revFind(i1));
    }
    
    public void testChild() {
        BST<String,Integer> bst = new BST<String,Integer>();
        bst.add(n1,i1);
        bst.add(n2,i2);
        bst.add(n3,i3);
	bst.add(n4,i4);
        assertEquals("correct size",4,bst.size());
        assertEquals("finds value",i2,bst.find(n2));
        assertEquals("finds key",n3,bst.revFind(i3));
        bst.delete(n2);
        assertEquals("size decremented",3,bst.size());
        assertEquals("finds value",null,bst.find(n2));
        assertEquals("finds key",null,bst.revFind(i2));
    }
    
    public void testIterator() {
        BST<String,Integer> bst = new BST<String,Integer>();
        bst.add(n1,i1);
        bst.add(n2,i2);
        bst.add(n3,i3);
        bst.add(n4,i4);
        bst.add(n5,i5);
        Iterator iter = bst.mkBFSIterator();
        assertEquals("root is n1", n1, iter.get());
        iter.next();
        assertEquals("next item is n2", n2, iter.get());
        iter.next();
        assertEquals("next item is n3", n3, iter.get());
        iter.next();
        assertEquals("next item is n4", n4, iter.get());
        iter.next();
        assertEquals("next item is n5", n5, iter.get());
        iter.next();
        assertEquals("finished", null, iter.get());
    }

}
