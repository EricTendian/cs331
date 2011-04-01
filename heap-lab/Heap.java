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
    
    private void swap(int pos1, int pos2) {
        E tmp = data.get(pos1);
        data.add(pos1, data.get(pos2));
	data.add(pos2, tmp);
    }
    
    private void heapifyUp(int index) {
        if (index!=0) {
            int parent = parent(index);
	    if (data.get(parent).compareTo(data.get(index))>0) {
                swap(index, parent);
                heapifyUp(parent);
	    }
        }
    }
    
    private void heapifyDown(int index) {
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
            swap(index, min);
            heapifyDown(min);
        }
    }

    // Main functions

    public int size() {
        return size;
    }

    public void enqueue(E elt) {
        if (size>0) {
            data.add(size-1, elt);
            heapifyUp(size-1);
        } else data.add(0, elt);
        size++;
    }

    public E dequeue() {
        if (size>0) {
            E del = data.get(0);
            data.add(0, data.get(size-1));
            size--;
            if (size>0) heapifyDown(0);
            return del;
	} else return null;
    }

    public E top () {
        return data.get(0);
    }
}
