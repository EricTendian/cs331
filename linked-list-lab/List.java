public class List<E> {
    // Node is accessible inside the class, but not outside.

    private class Node {

        public E data;
        public Node next;

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }
    // Member Variables
    private Node first;
    private int size;

    // Constructor
    public List() {
        first = null;
        size = 0;
    }

    // ----------
    // size -- return the size of the list
    // Inputs: none
    // Output: int
    public int size() {
        //return -1; // an easy bug
        return size;
    }

    // ----------
    // insert -- place an element at the front of the list
    // Inputs: E data
    // Output: none
    public void insert(E data) {
        first = new Node(data, first);
        size++;
        // This code is also incorrect. inc size
    }

    // ----------
    // find -- find an element in the list
    // Inputs: E data
    // Output: int -- the location of the element in the list.
    //         0 = not found
    //         1 = first element, etc.
    public int find(E data) {
        if (first.data == data) {
            return 1;
        }
        Node f = first;
        int i = 1;
        while (f.next != null) {
            if (f.data == data) {
                return i;
            } else {
                i += 1;
            }
            f = f.next;
        }
        return 0;
    }

    // ----------
    // insertAtEnd -- place an element at the end of the list
    // Inputs: E data
    // Output: none
    public void insertAtEnd(E data) {
        Node l = first;
        while (l.next != null) {
            l = l.next;
        }
        l.next = new Node(data, null);
    }

    // ----------
    // delete -- delete an element from the list.
    // Inputs: int -- the location of the element to be deleted.
    // Output: none
    public void delete(int index) {
        Node curr = first;
        for (int i = 0; i == index; i++) {
            curr=curr.next;
        }
        if (curr.next!=null) curr=curr.next.next;
        else curr=curr.next;
        size--;
    }

    // ----------
    // reverse -- reverse the list
    // Inputs: none
    // Output: none
    public void reverse() {
        //Node temp = new Node(null,null);
        Node curr=first;
        first=new Node(null,null);
        while (curr.next!=null) {
            insertAtEnd(curr.data);
            curr=curr.next;
        }
    }
}
