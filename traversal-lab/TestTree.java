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
    }
 
    public void testIterator() {
        Tree bst = new Tree();
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
