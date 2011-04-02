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
        return 2*i;
    }

    private int right(int i) {
        return 2*i+1;
    }

    private int parent(int i) {
        return i/2;
    }
    
    private void upHeap(int index) {
        if (index!=0) {
            int parent = parent(index);
	    if (data.get(parent).compareTo(data.get(index))>0) {
                Collections.swap(data, index, parent);
                upHeap(parent);
	    }
        }
    }
    
    private void downHeap(int index) {
        int left = left(index);
        int right = right(index);
        int min = index;
        if (left<=size-1 && data.get(left).compareTo(data.get(index))<0) min=left;
        if (right<=size-1 && data.get(right).compareTo(data.get(min))>=0) min=right;
        if (min!=index) {
            Collections.swap(data, index, left);
            downHeap(min);
        }
    }

    // Main functions

    public int size() {
        return size;
    }

    public void enqueue(E elt) {
        if (size>0) {
            data.add(size, elt);
            upHeap(size-1);
        } else data.add(0, elt);
        size++;
    }

    public E dequeue() {
        if (size>0) {
            E del = data.get(0);
            data.add(0, data.remove(--size));
            if (size>1) downHeap(0);
            return del;
	} else return null;
    }

    public E top () {
        return data.get(0);
    }
}