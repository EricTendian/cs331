

public class DList<E extends Comparable<E>> {

    private class Node {
        public E data;
        public Node next;
        public Node prev;

        public Node(E data) {
            this.data = data;
        }

        public Node(Node prev, E data, Node next) {
            this.data = data;
            this.prev = prev;
	    this.next = next; 
        }
    }
    private int size;
    private Node sentinel;

    public DList() {
        size = 0;
        sentinel = new Node(null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    public int size() {
        return size;
    }

    public void insertFront(E data) {
        sentinel.prev = new Node(sentinel, data, sentinel.prev);
        sentinel.prev.next.prev = sentinel.prev;
        size++;
    }

    public void insertEnd(E data) {
        sentinel.next = new Node(sentinel.next, data, sentinel);
        sentinel.next.next.next = sentinel.next;
        size++;
    }

    public void deleteFront() {
        if (size>0) {
            sentinel.prev = new Node(sentinel, sentinel.prev.next.data, sentinel.prev.next.next);
            size--;
        }
    }

    public void deleteEnd() {
        if (size>0) {
            sentinel.next = new Node(sentinel.next.prev.prev, sentinel.next.prev.data, sentinel);
            size--;
        }
    }

    private abstract class AllIterator implements Iterator<E> {
        protected Node cursor;
        protected boolean valid;

        public E get() {
            if (isValid()) return cursor.data;
            return null;
        }

        public boolean isValid() {
            valid=(cursor!=sentinel);
            return valid;
        }

        public abstract void next();  // set valid to null if next moves to the sentinel

        public void delete() {
            if (size>0 && isValid()) {
                cursor.prev.next = cursor.next;
                cursor.next.prev = cursor.prev;
                size--;
                this.next();
            }
        }
    }

    public class FwdIterator extends AllIterator {
        public FwdIterator() {
            cursor = sentinel.prev;
        }

        public void next() {
            if (isValid()) cursor = cursor.next;
        }
    }

    public class FwdFindIterator extends AllIterator {
        private E data;
        public FwdFindIterator(E data) {
            this.data = data;
            cursor = sentinel.prev;
            this.next();
        }

        public void next() {
            while (data.compareTo(cursor.data)!=0 && isValid()) cursor = cursor.next;
        }
    }

    public class RevIterator extends AllIterator {
        public RevIterator() {
            cursor = sentinel.next;
        }

        public void next() {
            if (isValid()) cursor = cursor.prev;
        }
    }

    public class RevFindIterator extends AllIterator {
        private E data;
        public RevFindIterator(E data) {
            this.data = data;
            cursor = sentinel.next;
            this.next();
        }
        public void next() {
            while (data.compareTo(cursor.data)!=0 && isValid()) cursor = cursor.prev;
        }
    }

    public Iterator makeFwdIterator() {
        return new FwdIterator();
    }

    public Iterator makeRevIterator() {
        return new RevIterator();
    }

    public Iterator makeFwdFindIterator(E data) {
        return new FwdFindIterator(data);
    }

    public Iterator makeRevFindIterator(E data) {
        return new RevFindIterator(data);
    }
}
