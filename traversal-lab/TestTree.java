import junit.framework.*;

public class TestTree extends TestCase {

    public TestTree(String name) {
	super(name);
    }

    public void testRoot() {
	Tree tree = new Tree();
	Iterator bfs = tree.mkBFSIterator();
	Iterator dfs = tree.mkDFSIterator();
	Iterator preO = tree.mkPreorderIterator();
	Iterator inO = tree.mkInorderIterator();
	Iterator postO = tree.mkPostorderIterator();
	Iterator frontO = tree.mkFrontierIterator();
	assertEquals("bfs created", false, bfs==null);
	assertEquals("dfs created", false, dfs==null);
	assertEquals("preO created", false, preO==null);
	assertEquals("inO created", false, inO==null);
	assertEquals("postO created", false, postO==null);
	assertEquals("frontO created", false, frontO==null);
    }
 
    public void testIterator() {
        Tree tree = new Tree();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        Iterator iter = bst.mkBFSIterator();
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
