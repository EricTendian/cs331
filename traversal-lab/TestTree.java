import junit.framework.*;

public class TestTree extends TestCase {

    public TestTree(String name) {
        super(name);
    }

    public void testBFS() {
        Tree tree = new Tree();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        Iterator iter = tree.mkBFSIterator();
        assertEquals("root is 1", 1, iter.get());
        iter.next();
        assertEquals("next item is 2", 2, iter.get());
        iter.next();
        assertEquals("next item is 3", 3, iter.get());
        iter.next();
        assertEquals("next item is 4", 4, iter.get());
        iter.next();
        assertEquals("next item is 5", 5, iter.get());
        iter.next();
        assertEquals("finished", -1, iter.get());
    }

    public void testDFS() {
	        Tree tree = new Tree();
	        tree.add(1);
	        tree.add(2);
	        tree.add(3);
	        tree.add(4);
	        tree.add(5);
	        Iterator iter = tree.mkDFSIterator();
	        assertEquals("root is 1", 1, iter.get());
	        iter.next();
	        assertEquals("next item is 2", 2, iter.get());
	        iter.next();
	        assertEquals("next item is 3", 3, iter.get());
	        iter.next();
	        assertEquals("next item is 4", 4, iter.get());
	        iter.next();
	        assertEquals("next item is 5", 5, iter.get());
	        iter.next();
	        assertEquals("finished", null, iter.get());
    }

    public void testPreO() {
	        Tree tree = new Tree();
	        tree.add(1);
	        tree.add(2);
	        tree.add(3);
	        tree.add(4);
	        tree.add(5);
	        Iterator iter = tree.mkPreorderIterator();
	        assertEquals("root is 1", 1, iter.get());
	        iter.next();
	        assertEquals("next item is 2", 2, iter.get());
	        iter.next();
	        assertEquals("next item is 3", 3, iter.get());
	        iter.next();
	        assertEquals("next item is 4", 4, iter.get());
	        iter.next();
	        assertEquals("next item is 5", 5, iter.get());
	        iter.next();
	        assertEquals("finished", null, iter.get());
    }

    public void testInO() {
	        Tree tree = new Tree();
	        tree.add(1);
	        tree.add(2);
	        tree.add(3);
	        tree.add(4);
	        tree.add(5);
	        Iterator iter = tree.mkInorderIterator();
	        assertEquals("root is 1", 1, iter.get());
	        iter.next();
	        assertEquals("next item is 2", 2, iter.get());
	        iter.next();
	        assertEquals("next item is 3", 3, iter.get());
	        iter.next();
	        assertEquals("next item is 4", 4, iter.get());
	        iter.next();
	        assertEquals("next item is 5", 5, iter.get());
	        iter.next();
	        assertEquals("finished", null, iter.get());
    }

    public void testPostO() {
	        Tree tree = new Tree();
	        tree.add(1);
	        tree.add(2);
	        tree.add(3);
	        tree.add(4);
	        tree.add(5);
	        Iterator iter = tree.mkPostorderIterator();
	        assertEquals("root is 1", 1, iter.get());
	        iter.next();
	        assertEquals("next item is 2", 2, iter.get());
	        iter.next();
	        assertEquals("next item is 3", 3, iter.get());
	        iter.next();
	        assertEquals("next item is 4", 4, iter.get());
	        iter.next();
	        assertEquals("next item is 5", 5, iter.get());
	        iter.next();
	        assertEquals("finished", null, iter.get());
    }

    public void testFrontO() {
	        Tree tree = new Tree();
	        tree.add(1);
	        tree.add(2);
	        tree.add(3);
	        tree.add(4);
	        tree.add(5);
	        Iterator iter = tree.mkFrontierIterator();
	        assertEquals("root is 1", 1, iter.get());
	        iter.next();
	        assertEquals("next item is 2", 2, iter.get());
	        iter.next();
	        assertEquals("next item is 3", 3, iter.get());
	        iter.next();
	        assertEquals("next item is 4", 4, iter.get());
	        iter.next();
	        assertEquals("next item is 5", 5, iter.get());
	        iter.next();
	        assertEquals("finished", null, iter.get());
    }

}
