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
        if (size<64) {
            data[size-1] = elt;
            reHeap(size-1);
            size++;
        }
    }

    private void reHeap(int index) {
        if (index!=0) {
            int parent = parent(index);
	    if (data[parent] > data[index]) {
                Object temp = data[parent];
                data[parent] = data[index];
                data[index] = temp;
                reHeap(parent);
	    }
        }
    }

    public E dequeue() {
        if (size>0) {
            data[0] = data[size-1];
            size--;
            if (size>0) heapify(0);
	} else return null;
    }

    private void heapify(int index) {
        int left = left(index);
        int right = right(index);
        if (right>=size) {
            if (left>=size) return;
            else int min = left;
        } else {
            if (data[left]<=data[right]) int min = left;
            else int min = right;
        } if (data[index]>data[min]) {
            Object temp = data[min];
            data[min] = data[index];
            data[index] = temp;
            heapify(min);
        }
    }

    public E top () {
        return data[0];
    }
}
