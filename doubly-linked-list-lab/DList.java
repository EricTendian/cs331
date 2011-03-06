
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
        sentinel.prev = new Node(sentinel, data, sentinel.prev.next);
        size++;
    }

    public void insertEnd(E data) {
        sentinel.next = new Node(sentinel.next.prev, data, sentinel);
        size++;
    }

    public void deleteFront() {
        sentinel.prev = new Node(sentinel, sentinel.prev.next.data, sentinel.prev.next.next);
        size--;
    }

    public void deleteEnd() {
        sentinel.next = new Node(sentinel.next.prev.prev, sentinel.next.prev.data, sentinel);
        size--;
    }

    private abstract class AllIterator implements Iterator<E> {
        protected Node cursor;
        protected boolean valid;

        public E get() {
            if (cursor != sentinel)  return cursor.data;
            else return null;
        }

        public boolean isValid() {
            return valid;
        }

        public abstract void next();  // set valid to null if next moves to the sentinel

        public void delete() {
            if (isValid()) {
                cursor.prev.next = cursor.next;
                cursor.next.prev = cursor.prev;
                this.next();
            }
        }
    }

    public class FwdIterator extends AllIterator {
        public FwdIterator() {
            cursor = sentinel;
            this.next();
        }

        public void next() {
            if (cursor != sentinel) {cursor = cursor.next; valid = true;}
            else valid = false;
        }
    }

    public class FwdFindIterator extends AllIterator {
        E data;
        boolean found;
        public FwdFindIterator(E data) {
            cursor = sentinel;
            this.data = data;
            this.next();
        }

        public void next() {
            if (found) cursor = null;
            while (!found && cursor != sentinel) {
                if (data.compareTo(cursor.data) == 0) found = true;
                else {cursor = cursor.next; valid = true;}
            }
        }
    }

    public class RevIterator extends AllIterator {
        public RevIterator() {
            cursor = sentinel;
            this.next();
        }

        public void next() {
            if (cursor != sentinel) {cursor = cursor.prev; valid = true;}
            else valid = false;
        }
    }

    public class RevFindIterator extends AllIterator {
        E data;
        boolean found;
        public RevFindIterator(E data) {
            cursor = sentinel;
            this.data = data;
            this.next();
        }
        public void next() {
            if (found) cursor = null;
            while (!found && cursor != sentinel) {
                if (data.compareTo(cursor.data) == 0) found = true;
                else {cursor = cursor.prev; valid = true;}
            }
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
