import junit.framework.*;

public class TestList extends TestCase {
   public Integer i1 = new Integer(1);
   public Integer i2 = new Integer(2);
   public Integer i5 = new Integer(5);
   public Integer i10 = new Integer(10);
   public Integer i15 = new Integer(15);
   public Integer i20 = new Integer(20);
   public Integer i25 = new Integer(25);

   public TestList(String name) {
      super(name);
   }

   // test list with nothing in it.
   public void testZero() {
      List foo = new List<Integer>();
      assertEquals("Size Test",0,foo.size());

      // add more tests here to see if an empty list behaves properly
   }
   
   // test list with values added.
   public void testFull() {
       List foo = new List<Integer>();
       foo.insert(i1);
       //assertEquals("Insert Test",,);
       foo.insert(i2);
       assertEquals("Size Test",2,foo.size());
       foo.insert(i5);
       foo.insert(i10);
       foo.insert(i15);
       foo.insert(i20);
       //foo.insert(i25);
       assertEquals("Find Test",1,foo.find(i10));
       foo.insert(i25);
       //assertEquals("insertAtEnd Test",,);
       foo.delete(4);
       assertEquals("Delete Test",0,foo.find(i15));
       //assertEquals("Reverse Test",,);
   }

}
