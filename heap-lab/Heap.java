public class Heap<E> {
   private int size;
   private Object data[];

   public Heap() {
      data = new Object[64];
   }

   // Helper functions

   private int left(int i) {
      return 0;
   }

   private int right(int i) {
      return 0;
   }

   private int parent(int i) {
      return 0;
   }

   // Main functions

   public int size() {
      return size;
   }

   public void enqueue(E elt) {
      size ++;
   }

   public E dequeue() {
      return null;
   }

   public E top () {
      return null;
   }
}
