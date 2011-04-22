import junit.framework.*;
public class TestUpTree extends TestCase {
    public TestUpTree(String name) {
        super(name);
    }
    
    public void testAdd() {
        UpTree up = new UpTree();
        UpTree.Node str1 = new UpTree.Node("str1");
        UpTree.Node str2 = new UpTree.Node("str2");
        up.add(str1.data);
        up.add(str2.data);
        assertEquals("addtest1", str1, up.find(str1));
        assertEquals("addtest2", str2, up.find(str2));
    }
    
    public void testUnion() {
        UpTree up = new UpTree();
        UpTree.Node str1 = new UpTree.Node("str1");
        UpTree.Node str2 = new UpTree.Node("str2");
        up.union(str1, str2);
        assertEquals("uniontest1", 2, up.find(str2).size);
        assertEquals("uniontest2", str2, str1.up);
    }
    
    public void testIterator() {
        UpTree up = new UpTree();
        UpTree.Node str1 = new UpTree.Node("str1");
        UpTree.Node str2 = new UpTree.Node("str2");
        UpTree.Node str3 = new UpTree.Node("str3");
        UpTree.Node str4 = new UpTree.Node("str4");
        up.add(str1.data);
        up.add(str2.data);
        up.add(str3.data);
        up.add(str4.data);
        up.union(str3, str4);
        Iterator<UpTree.Node> itr = up.mkIterator();
        assertEquals("iteratortest1", str4.data, itr.get().data);
        itr.next();
        assertEquals("iteratortest2", str3.data, itr.get().data);
        itr.next();
        assertEquals("iteratortest3", str2.data, itr.get().data);
        itr.next();
        assertEquals("iteratortest4", str1.data, itr.get().data);
    }
    
    public void testSetIterator() {
        UpTree up = new UpTree();
        UpTree.Node str1 = new UpTree.Node("str1");
        UpTree.Node str2 = new UpTree.Node("str2");
        UpTree.Node str3 = new UpTree.Node("str3");
        UpTree.Node str4 = new UpTree.Node("str4");
        up.add(str1.data);
        up.add(str2.data);
        up.union(str1, str2);
        up.add(str3.data);
        up.union(str2, str3);
        up.add(str4.data);
        up.union(str3, str4);
        Iterator<Iterator<UpTree.Node>> itr = up.mkSetIterator(str2);
        assertEquals("setiteratortest1", str1.data, itr.get().data);
        itr.next();
        assertEquals("setiteratortest2", str2.data, itr.get().data);
        itr.next();
        assertEquals("setiteratortest3", str3.data, itr.get().data);
        itr.next();
        assertEquals("setiteratortest4", str4.data, itr.get().data);
    }
}
