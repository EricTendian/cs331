// $Id: TestList.java 75 2005-10-09 14:19:45Z beckman $

import junit.framework.*;

public class TestBST extends TestCase {
    /*public String n1 = "Jenny";
    public String n2 = "Empire";
    public String n3 = "Emergency";
    public String n4 = "Helpdesk";
    public String n5 = "Information";

    public Integer i1 = new Integer(8675309);
    public Integer i2 = new Integer(5882300);
    public Integer i3 = new Integer(911);
    public Integer i4 = new Integer(5673375);
    public Integer i5 = new Integer(5551212);*/
    
    public String n1 = "a";
    public String n2 = "b";
    public String n3 = "c";
    public String n4 = "d";
    public String n5 = "e";

    public Integer i1 = new Integer(1);
    public Integer i2 = new Integer(2);
    public Integer i3 = new Integer(3);
    public Integer i4 = new Integer(4);
    public Integer i5 = new Integer(5);


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
        assertEquals("correct size",3,bst.size());
        assertEquals("finds value",i2,bst.find(n2));
        assertEquals("finds key",n3,bst.revFind(i3));
        bst.delete(n1);
        assertEquals("size decremented",2,bst.size());
        assertEquals("finds value",null,bst.find(n1));
        assertEquals("finds key",null,bst.revFind(i1));
    }
    
    public void testIterator() {
        BST<Integer,String> bst = new BST<Integer,String>();
        bst.add(i1,n1);
        bst.add(i2,n2);
        bst.add(i3,n3);
        bst.add(i4,n4);
        bst.add(i5,n5);
        Iterator iter = bst.mkBFSIterator();
        assertEquals("root is i1", i1, iter.get());
        iter.next();
        assertEquals("next item is i2", i2, iter.get());
        iter.next();
        assertEquals("next item is i3", i3, iter.get());
        iter.next();
        assertEquals("next item is i4", i4, iter.get());
        iter.next();
        assertEquals("next item is i5", i5, iter.get());
        iter.next();
        assertEquals("finished", null, iter.get());
    }

}
