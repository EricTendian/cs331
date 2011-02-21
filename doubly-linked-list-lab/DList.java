public class DList<E extends Comparable<E>> {

   private class Node {
      public E data;
      public Node next;
      public Node prev;

      public Node(E data) {
         this.data = data;
      }

      public Node(Node prev,E data,Node next) {
         this.data = data;
      }
   }

   private int size;
   private Node sentinel;

   public DList() {
      // You will need to initialize everything here.
   }

   public int size() {
      return size;
   }

   private abstract class AllIterator implements Iterator<E> {
      protected Node cursor;
      protected boolean valid;

      public E get() {
         if (cursor != sentinel)
            return cursor.data;
         else
            return null;
      }

      public boolean isValid() {
         return valid;
      }

      public abstract void next();  // set valid to null if next moves to the sentinel

      public void delete() {
         // your code here!
         // What are your boundary conditions?
      }
   }

   public class FwdIterator extends AllIterator {
      public FwdIterator() {
         cursor = sentinel;
         this.next();
      }

      public void next() {
         if (cursor != sentinel) 
            cursor = cursor.next;
      }
   }

}
