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

    public void testCreate() {
	BST<String,Integer> bst = new BST<String,Integer>();

	assertEquals("1. create",0,bst.size());
    }

}
