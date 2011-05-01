import junit.framework.*;
public class TestUpTree extends TestCase {
    public TestUpTree(String name) {
        super(name);
    }
    
    public void testAdd() {
        UpTree up = new UpTree();
        UpTree.Node str1 = up.add("str1");
        UpTree.Node str2 = up.add("str2");
        assertEquals("addtest1", str1, up.find(str1));
        assertEquals("addtest2", 1, str2.size());
        assertEquals("addtest3", 2, up.size());
    }
    
    public void testUnion() {
        UpTree up = new UpTree();
        UpTree.Node str1 = up.add("str1");
        UpTree.Node str2 = up.add("str2");
        UpTree.Node str3 = up.add("str3");
        UpTree.Node str4 = up.add("str4");
        up.union(str1, str2);
	up.union(str3, str4);
        up.union(str1, str3);
        assertEquals("uniontest1", 4, up.find(str2).size());
        assertEquals("uniontest2", str4, up.find(str1));
    }
    
    public void testIterator() {
        UpTree up = new UpTree();
        UpTree.Node str1 = up.add("str1");
        UpTree.Node str2 = up.add("str2");
        UpTree.Node str3 = up.add("str3");
        UpTree.Node str4 = up.add("str4");
        up.union(str3, str4);
        Iterator<UpTree.Node> itr = up.mkIterator();
        assertEquals("iteratortest1", str4, itr.get());
        itr.next();
        assertEquals("iteratortest2", str3, itr.get());
        itr.next();
        assertEquals("iteratortest3", str2, itr.get());
        itr.next();
        assertEquals("iteratortest4", str1, itr.get());
    }
    
    public void testSetIterator() {
        UpTree up = new UpTree();
        UpTree.Node str1 = up.add("str1");
        UpTree.Node str2 = up.add("str2");
        UpTree.Node str3 = up.add("str3");
        UpTree.Node str4 = up.add("str4");
        UpTree.Node str5 = up.add("str5");
        up.union(str1, str2);
        up.union(str2, str3);
        Iterator<UpTree.Node> itr = up.mkSetIterator(str2);
        assertEquals("setiteratortest1", str3, itr.get());
        itr.next();
        assertEquals("setiteratortest2", str2, itr.get());
        itr.next();
        assertEquals("setiteratortest3", str1, itr.get());
        itr.next();
        assertEquals("setiteratortest4", null, itr.get());
    }
}
