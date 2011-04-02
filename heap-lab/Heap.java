import java.util.ArrayList;
import java.util.Collections;

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
    
    private void heapifyUp(int index) {
        if (index!=0) {
            int parent = parent(index);
	    if (data.get(parent).compareTo(data.get(index))>0) {
                Collections.swap(data, index, parent);
                heapifyUp(parent);
	    }
        }
    }
    
    private void heapifyDown(int index) {
        int left = left(index);
        int right = right(index);
        if (right>size-1) if (left>size-1) return;
        if (data.get(left).compareTo(data.get(right))>0) ++left;
        if (data.get(index).compareTo(data.get(left))<=0) return;
        Collections.swap(data, index, left);
        heapifyDown(left);
    }

    // Main functions

    public int size() {
        return size;
    }

    public void enqueue(E elt) {
        if (size>0) {
            data.add(size, elt);
            heapifyUp(size);
        } else data.add(0, elt);
        size++;
    }

    public E dequeue() {
        if (size>0) {
            E del = data.get(0);
            data.add(0, data.get(--size));
            if (size>1) heapifyDown(0);
            return del;
	} else return null;
    }

    public E top () {
        return data.get(0);
    }
}