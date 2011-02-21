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

      assertEquals("1. create",0,d.size());
   }

}
