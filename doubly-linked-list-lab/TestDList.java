import junit.framework.*;

public class TestDList extends TestCase {

    public Integer i1 = new Integer(1);
    public Integer i2 = new Integer(2);
    public Integer i5 = new Integer(5);
    public Integer i10 = new Integer(10);
    public Integer i15 = new Integer(15);
    public Integer i20 = new Integer(20);
    public Integer i25 = new Integer(25);

    public TestDList(String name) {
        super(name);
    }

    public void testCreate() {
        DList<Integer> d = new DList<Integer>();

        assertEquals("1. create", 0, d.size());
        d.insertFront(i1);
        d.deleteEnd();
        assertEquals("size doesn't decrement on deletion", 0, d.size());
    }

    public void testFrontInsertion() {
        DList<Integer> d = new DList<Integer>();
        d.insertFront(i1);
        d.insertFront(i2);
        d.insertFront(i5);
        Iterator fwd = d.makeFwdIterator();
        Iterator rev = d.makeRevIterator();
        assertEquals("insertFront 3 items", 3, d.size());
        assertEquals("front item correct", i5, fwd.get());
        assertEquals("last item correct", i1, rev.get());
        d.deleteFront();
        assertEquals("deleteFront decrements size", 2, d.size());
        d.insertFront(i5);
        assertEquals("forward iterator starts at first element", i5, fwd.get());
        fwd.next();
        assertEquals("forward iterator only returns first element", i2, fwd.get());

        assertEquals("reverse iterator is really a forward iterator", false, fwd.equals(rev));
        assertEquals("reverse iterator only returns last element", i1, rev.get());
        rev.next();
        assertEquals("reverse iterator only returns last element", i2, rev.get());
    }

    public void testEndInsertion() {
        DList<Integer> d = new DList<Integer>();
        d.insertEnd(i1);
        d.insertEnd(i2);
        d.insertEnd(i5);
        Iterator fwd = d.makeFwdIterator();
        Iterator rev = d.makeRevIterator();
        assertEquals("insertEnd 3 items", 3, d.size());
        assertEquals("front item correct", i1, fwd.get());
        assertEquals("last item correct", i5, rev.get());
        d.deleteEnd();
        assertEquals("deleteEnd decrements size", 2, d.size());
	assertEquals("deleteEnd doesn't set first=null", i1, fwd.get());
        d.insertEnd(i5);

    }

    public void testFind() {
        DList<Integer> d = new DList<Integer>();
        d.insertFront(i1);
        d.insertEnd(i2);
        d.insertFront(i5);
        Iterator fwdfind = d.makeFwdFindIterator(i1);
        Iterator revfind = d.makeRevFindIterator(i5);
        assertEquals("element found fwd", null, fwdfind.get());
        assertEquals("element found rev", null, revfind.get());
        fwdfind.next();
        revfind.next();
        assertEquals("fwdfind returns everything", null, fwdfind.get());
        assertEquals("revfind returns everything", null, revfind.get());
    }
}
