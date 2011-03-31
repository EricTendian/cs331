public class Heap<E> {
   private int size;
   private Object data[];

   public Heap() {
      data = new Object[64];
      size = 0;
   }

   // Helper functions

   private int left(int i) {
      return 2 * i + 1;
   }

   private int right(int i) {
      return 2 * i + 2;
   }

   private int parent(int i) {
      return (i - 1) / 2;
   }

   // Main functions

   public int size() {
      return size;
   }

   public void enqueue(E elt) {
      data[63];
      size++;
   }

   public E dequeue() {
      size--;
      return null;
   }

   public E top () {
      return data[0];
   }
}
