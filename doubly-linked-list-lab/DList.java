public class DList<E extends Comparable<E>> {
	
	private class Node {
		public E data;
		public Node next;
		public Node prev;
		
		public Node(E data) {
			this.data = data;
		}
		
		public Node(Node prev,E data,Node next) {
			this.data = data;
		}
	}
	
	private int size;
	private Node sentinel;
	
	public DList() {
		size = 0;
		sentinel = null;
	}
	
	public int size() {
		return size;
	}
	
	public void insertFront(E data) {
		sentinel = new Node(null,data,sentinel);
		size++;
	}
	
	public void insertEnd(E data) {
		sentinel = new Node(sentinel,data,null);
		size++;
	}
	
	public void deleteFront() {
		sentinel = new Node(sentinel.data);
		size--;
	}
	
	public void deleteEnd() {
		sentinel = new Node(sentinel,sentinel.data,sentinel.prev);
		size--;
	}
	
	private abstract class AllIterator implements Iterator<E> {
		protected Node cursor;
		protected boolean valid;
		
		public E get() {
			if (cursor != sentinel)
				return cursor.data;
			else
				return null;
		}
		
		public boolean isValid() {
			return valid;
		}
		
		public abstract void next();  // set valid to null if next moves to the sentinel
		
		public void delete() {
			if (cursor != sentinel)
				sentinel.next = cursor.next;
		}
	}
	
	public class FwdIterator extends AllIterator {
		public FwdIterator() {
			cursor = sentinel;
			this.next();
		}
		
		public void next() {
			if (cursor != sentinel)
			cursor = cursor.next;
		}
	}
	
	public class FwdFindIterator extends AllIterator {
		E data;
		boolean found;
		
		public FwdFindIterator(E data) {
			cursor = sentinel;
			this.data=data;
			found = false;
			this.next();
		}

		public void next() {
			if (!found) {
			    if (cursor != sentinel && cursor.data.compareTo(data)!=0)
				cursor = cursor.next;
				else if (cursor.data.compareTo(data)==0)
					found = true;
			}
		}
	}
	
	public class RevIterator extends AllIterator {
		public RevIterator() {
			cursor = sentinel;
			this.next();
		}
		
		public void next() {
			if (cursor != sentinel)
			cursor = cursor.prev;
		}
	}
	
	public class RevFindIterator extends AllIterator {
		E data;
		boolean found;
		
		public RevFindIterator(E data) {
			cursor = sentinel;
			found = false;
			this.next();
		}
		
		public void next() {
			if (!found) {
				if (cursor != sentinel && cursor.data.compareTo(data)!=0)
					cursor = cursor.prev;
				else if (cursor.data.compareTo(data)==0)
					found = true;
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
