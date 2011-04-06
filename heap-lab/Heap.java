import java.util.ArrayList;
import java.util.Collections;

public class Heap<E extends Comparable> {
    private ArrayList<E> data;

    public Heap() {
        data = new ArrayList<E>();
    }

    // Helper functions

    private int left(int i) {
        return (2*i)+1;
    }

    private int right(int i) {
        return (2*i)+2;
    }

    private int parent(int i) {
        return (i-1)/2;
    }
    
    private void upHeap(int index) {
        if (index>0) {
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
        int min;
        if (right>=size()) {
            if (left>=size()) return;
            else min = left;
        } else {
            if (data.get(left).compareTo(data.get(right))<=0) min = left;
            else min = right;
        }
        if (data.get(index).compareTo(data.get(min))>0) {
            Collections.swap(data, index, min);
            downHeap(min);
        }
    }

    // Main functions

    public int size() {
        return data.size();
    }

    public void enqueue(E elt) {
        data.add(elt);
        upHeap(size()-1);
    }

    public E dequeue() {
        if (size()>0) {
            E del = data.get(0);
            if (size()>1) {
                data.set(0, data.remove(size()-1));
                downHeap(0);
            } else data.remove(0);
            return del;
        } else return null;
    }

    public E top () {
        if (size()>0) return data.get(0);
        else return null;
    }
}
