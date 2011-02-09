public class Tester {
   public static Integer i1 = new Integer(1);
   public static Integer i2 = new Integer(2);
   public static Integer i5 = new Integer(5);
   public static Integer i10 = new Integer(10);
   public static Integer i15 = new Integer(15);
   public static Integer i20 = new Integer(20);
   public static Integer i25 = new Integer(25);
   public static List foo;

   // test list with nothing in it.
   public static void testZero() {
      foo = new List<Integer>();
      System.out.println("Size Test "+(foo.size()==0));

      // add more tests here to see if an empty list behaves properly
   }
   
   // test list with values added.
   public static void testFull() {
       List foo = new List<Integer>();
       foo.insert(i1);
       
       foo.insert(i2);
       System.out.println("Size Test "+(foo.size()==2));
       foo.insert(i5);
       foo.insert(i10);
       foo.insert(i15);
       foo.insert(i20);
       //foo.insert(i25);
       System.out.println("Find Test "+(foo.find(i10)==4));
       foo.insert(i25);
       //assertEquals("insertAtEnd Test",,);
       foo.delete(4);
       System.out.println("Delete Test "+(foo.find(i15)==0));
       //assertEquals("Reverse Test",,);
   }
    public static void main(String[] args) {
        System.out.println("testZero()");
        testZero();
        System.out.println("\ntestFull()");
        testFull();
    }
}
