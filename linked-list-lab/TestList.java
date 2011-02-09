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
      assertEquals("Find Test",0,foo.find(i10));
      foo.delete(i2);
      assertEquals("Delete Test",0,foo.size());
      // add more tests here to see if an empty list behaves properly
   }
   
   // test list with values added.
   public void testOne() {
       List foo = new List<Integer>();
       foo.insert(i1);
       assertEquals("Insert Test",1,foo.size());
       assertEquals("Size Test",1,foo.size());
       assertEquals("Find Test",1,foo.find(i1));
       foo.delete(1);
       assertEquals("Delete Test",0,foo.find(i1));
       foo.insertAtEnd(i25);
       assertEquals("insertAtEnd Test",2,foo.find(i25));
       foo.reverse();
       //assertEquals("Reverse Test",,);
   }
   
   /*public void testSize() {
       List foo = new List<Integer>();
       assertEquals("Size Test - empty",0,foo.size());
       foo.insert(i1);
       assertEquals("Size Test - full",1,foo.size());
   }
   
   public void testInsert() {
       List foo = new List<Integer>();
       foo.insert(i1);
       assertEquals("Insert Test - find",1,foo.find(i1));
       assertEquals("Insert Test - size",1,foo.size());
   }
   
   public void testFind() {
       List foo = new List<Integer>();
       foo.insert(i5);
       foo.insert(i10);
       foo.insert(i15);
       foo.insert(i20);
       //list is 20,15,10,5
       assertEquals("Find Test",2,foo.find(i15));
   }
   
   public void testInsertAtEnd() {
       List foo = new List<Integer>();
       foo.insertAtEnd(i5);
       foo.insertAtEnd(i10);
       foo.insertAtEnd(i15);
       foo.insertAtEnd(i20);
       //list is 5,10,15,20
       assertEquals("InsertAtEnd Test",3,foo.find(i15));
   }
   
   public void testDelete() {
       List foo = new List<Integer>();
       foo.delete(i2);
       assertEquals("Delete Test - empty",0,foo.size());
       foo.insert(i5);
       foo.insert(i10);
       foo.insert(i15);
       foo.insert(i20);
       foo.delete(i10);
       //list is 20,15,5
       assertEquals("Delete Test - full",3,foo.size());
       assertEquals("Delete Test - full",0,foo.find(i10));
       foo.delete(i25);
   }
   
   public void testReverse() {
       List foo = new List<Integer>();
       foo.insert(i5);
       foo.insert(i10);
       foo.insert(i15);
       foo.insert(i20);
       foo.reverse();
       List rev = new List<Integer>();
       rev.insert(i20);
       rev.insert(i15);
       rev.insert(i10);
       rev.insert(i5);
       assertEquals("Reverse Test",rev.find(i15),foo.find(i15));
   }
*/
}