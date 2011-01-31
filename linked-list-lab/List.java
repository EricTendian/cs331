 public class List<E> {
   // Node is accessible inside the class, but not outside.

   private class Node {
      public E data;
      public Node next;

      public Node(E data, Node next) {
         this.data = data;
         this.next = next;
      }

      public Node(E data) {
         this.data = data;
         this.next = null;
      }
   }

   // Member Variables

   private Node first;
   private int size;

   // Constructor

   public List() {
      first = null;
      size = 0;
   }

   // ----------
   // size -- return the size of the list
   // Inputs: none
   // Output: int

   public int size() {
      return -1; // an easy bug
   }

   // ----------
   // insert -- place an element at the front of the list
   // Inputs: E data
   // Output: none

   public void insert(E data) {
      first = new Node(data,first);
      // This code is also incorrect.
   }

   // ----------
   // find -- find an element in the list
   // Inputs: E data
   // Output: int -- the location of the element in the list.
   //         0 = not found
   //         1 = first element, etc.

   // ----------
   // insertAtEnd -- place an element at the end of the list
   // Inputs: E data
   // Output: none

   // ----------
   // delete -- delete an element from the list.
   // Inputs: int -- the location of the element to be deleted.
   // Output: none

   // ----------
   // reverse -- reverse the list
   // Inputs: none
   // Output: none

}
