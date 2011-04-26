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
        assertEquals("addtest2", 1, str1.size());
        assertEquals("addtest3", 2, up.size());
    }
    
    public void testUnion() {
        UpTree up = new UpTree();
        UpTree.Node str1 = up.add("str1");
        UpTree.Node str2 = up.add("str2");
        up.union(str1, str2);
        assertEquals("uniontest1", 2, up.find(str2).size());
        //assertEquals("uniontest2", str2, str1.up);
    }
    
    public void testIterator() {
        UpTree up = new UpTree();
        UpTree.Node str1 = up.add("str1");
        UpTree.Node str2 = up.add("str2");
        UpTree.Node str3 = up.add("str3");
        UpTree.Node str4 = up.add("str4");
        up.union(str3, str4);
        Iterator<UpTree.Node> itr = up.mkIterator();
        //assertEquals("iteratortest1", true, str4.equals(itr.get()));
        itr.next();
        //assertEquals("iteratortest2", true, str3.equals(itr.get()));
        itr.next();
        //assertEquals("iteratortest3", true, str2.equals(itr.get()));
        itr.next();
        //assertEquals("iteratortest4", true, str1.equals(itr.get()));
    }
    
    public void testSetIterator() {
        UpTree up = new UpTree();
        UpTree.Node str1 = up.add("str1");
        UpTree.Node str2 = up.add("str2");
        UpTree.Node str3 = up.add("str3");
        UpTree.Node str4 = up.add("str4");
        up.union(str1, str2);
        up.union(str2, str3);
        up.union(str3, str4);
        Iterator<UpTree.Node> itr = up.mkSetIterator(str1);
        assertEquals("setiteratortest1", true, itr.get()!=null);
        itr.next();
        assertEquals("setiteratortest2", true, itr.get()!=null);
        itr.next();
        assertEquals("setiteratortest3", true, itr.get()!=null);
        itr.next();
        assertEquals("setiteratortest4", true, itr.get()!=null);
    }
}
