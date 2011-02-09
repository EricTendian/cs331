public class Tester {
   public static Integer i1 = new Integer(1);
   public static Integer i2 = new Integer(2);
   public static Integer i5 = new Integer(5);
   public static Integer i10 = new Integer(10);
   public static Integer i15 = new Integer(15);
   public static Integer i20 = new Integer(20);
   public static Integer i25 = new Integer(25);
   private static List foo;

    // test list with nothing in it.
    public static void testZero() {
      foo = new List<Integer>();
      System.out.println("Size Test\t"+(0==foo.size()));
      //assertEquals("Size Test",0,foo.size());
      System.out.println("Find Test\t"+(0==foo.find(i10)));
      //assertEquals("Find Test",0,foo.find(i10));
      foo.delete(i2);
      System.out.println("Delete Test\t"+(0==foo.size()));
      //assertEquals("Delete Test",0,foo.size());
      // add more tests here to see if an empty list behaves properly
    }

    // test list with values added.
    /*public void testFull() {
       List foo = new List<Integer>();
       foo.insert(i1);
       assertEquals("Insert Test",1,foo.size());
       foo.insert(i2);
       assertEquals("Size Test",2,foo.size());
       foo.insert(i5);
       foo.insert(i10);
       foo.insert(i15);
       foo.insert(i20);
       assertEquals("Find Test",3,foo.find(i10));
       foo.insertAtEnd(i25);
       //list is: 20,15,10,5,2,1,25
       //assertEquals("insertAtEnd Test",7,foo.find(i25));
       foo.delete(4);
       assertEquals("Delete Test",0,foo.find(i5));
       //assertEquals("Reverse Test",,);
    }*/

    public static void testSize() {
       foo = new List<Integer>();
       System.out.println("Size Test - empty\t"+(0==foo.size()));
       //assertEquals("Size Test - empty",0,foo.size());
       foo.insert(i1);
       System.out.println("Size Test - full\t"+(1==foo.size()));
       //assertEquals("Size Test - full",1,foo.size());
    }

    public static void testInsert() {
       foo = new List<Integer>();
       foo.insert(i1);
       System.out.println("Insert Test - find\t"+(1==foo.find(i1)));
       //assertEquals("Insert Test - find",1,foo.find(i1));
       System.out.println("Insert Test - size\t"+(1==foo.size()));
       //assertEquals("Insert Test - size",1,foo.size());
    }

    public static void testFind() {
       foo = new List<Integer>();
       foo.insert(i5);
       foo.insert(i10);
       foo.insert(i15);
       foo.insert(i20);
       //list is 20,15,10,5
       System.out.println("Find Test\t"+(2==foo.find(i15)));
       //assertEquals("Find Test",2,foo.find(i15));
    }

    public static void testInsertAtEnd() {
       foo = new List<Integer>();
       foo.insertAtEnd(i5);
       foo.insertAtEnd(i10);
       foo.insertAtEnd(i15);
       foo.insertAtEnd(i20);
       //list is 5,10,15,20
       System.out.println("InsertAtEnd Test\t"+(3==foo.find(i15)));
       //assertEquals("InsertAtEnd Test",3,foo.find(i15));
    }

    public static void testDelete() {
       foo = new List<Integer>();
       foo.delete(i2);
       System.out.println("Delete Test - empty\t"+(0==foo.size()));
       //assertEquals("Delete Test - empty",0,foo.size());
       foo.insert(i5);
       foo.insert(i10);
       foo.insert(i15);
       foo.insert(i20);
       foo.delete(i10);
       //list is 20,15,5
       System.out.println("Delete Test - full\t"+(3==foo.size()));
       //assertEquals("Delete Test - full",3,foo.size());
       System.out.println("Delete Test - full\t"+(0==foo.find(i10)));
       //assertEquals("Delete Test - full",0,foo.find(i10));
       foo.delete(i25);
    }

    public static void testReverse() {
       foo = new List<Integer>();
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
       System.out.println("Reverse Test\t"+(rev.find(i15)==foo.find(i15)));
       //assertEquals("Reverse Test",rev.find(i15),foo.find(i15));
    }
    
    public static void main(String[] args) {
        System.out.println("testZero()");
        testZero();
        System.out.println("\ntestSize()");
        testSize();
        System.out.println("\ntestInsert()");
        testInsert();
        System.out.println("\ntestFind()");
        testFind();
        System.out.println("\ntestInsertAtEnd()");
        testInsertAtEnd();
        System.out.println("\ntestDelete()");
        testDelete();
        System.out.println("\ntestReverse()");
        testReverse();
    }
}
