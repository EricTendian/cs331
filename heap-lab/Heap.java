import java.util.ArrayList;

public class Heap<E extends Comparable> {
    private int size;
    private ArrayList<E> data;

    public Heap() {
        data = new ArrayList<E>();
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
        data.add(size-1, elt);
        reHeap(size-1);
        size++;
    }

    private void reHeap(int index) {
        if (index!=0) {
            int parent = parent(index);
	    if (data.get(index).compareTo(data.get(parent))>0) {
                E temp = data.get(parent);
                data.add(parent, data.get(index));
                data.add(index, temp);
                reHeap(parent);
	    }
        }
    }

    public E dequeue() {
        if (size>0) {
            E del = data.get(0);
            data.add(0, data.get(size-1));
            size--;
            if (size>0) heapify(0);
            return del;
	} else return null;
    }

    private void heapify(int index) {
        int left = left(index);
        int right = right(index);
        int min;
        if (right>=size) {
            if (left>=size) return;
            else min = left;
        } else {
            if (data.get(left).compareTo(data.get(right))<=0) min = left;
            else min = right;
        } if (data.get(index).compareTo(data.get(min))<0) {
            E temp = data.get(min);
            data.add(min, data.get(index));
            data.add(index, temp);
            heapify(min);
        }
    }

    public E top () {
        return data.get(0);
    }
}
