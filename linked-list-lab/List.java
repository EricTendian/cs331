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
        return size;
    }

    // ----------
    // insert -- place an element at the front of the list
    // Inputs: E data
    // Output: none
    public void insert(E data) {
        //make new Node who's next is first, then make that Node first
        first = new Node(data, first);
        size++; //inc size
    }

    // ----------
    // find -- find an element in the list
    // Inputs: E data
    // Output: int -- the location of the element in the list.
    //         0 = not found
    //         1 = first element, etc.
    public int find(E data) {
        //if first is not null, then look for data
        if (first!=null) {
            if (first.data.equals(data)) {
                return 1;
            }
            Node f = first.next;
            int i = 2;
            while (f != null) {
                if (f.data.equals(data)) {
                    return i; //if it finds data, return the index
                } else  i++; //inc index
                f = f.next; //continue traversing list
            }
            return 0; //can't find data after fully traversing list
        }
        return 0; //else return not found
    }

    // ----------
    // insertAtEnd -- place an element at the end of the list
    // Inputs: E data
    // Output: none
    public void insertAtEnd(E data) {
        if (size>0) {
        Node curr = first; //use l as cursor
        while (curr.next != null) {
            curr = curr.next; //traverse list until end is reached
        }
        curr.next = new Node(data);
        //make l's next (previously null) a new node with data as l.next.data
        } else first = new Node(data);
        size++;
    }

    // ----------
    // delete -- delete an element from the list.
    // Inputs: int -- the location of the element to be deleted.
    // Output: none
    public void delete(int index) {
        if (first!=null && size>=index) {
        //if you are deleting the first item, make first point to first.next
        if (index==1) first=first.next;
        else {
            Node curr = first; //use curr as cursor
            for (int i = 1; i < index; i++) {
                curr=curr.next; //traverse the list until you get to the item to be deleted
            }
            if (curr.next.next!=null) curr.next=curr.next.next;
            //if you are not at the end of the list, make curr curr.next and take previous curr out of the list
            else curr.next=null; //if you are at the end of the list, cut off curr.next
        } size--; //decrement size
        }
    }

    // ----------
    // reverse -- reverse the list
    // Inputs: none
    // Output: none
    public void reverse() {
        if (size>2) {
            Node curr = first; //5,2,1, reversed is 1,2,5
            first=null;
            while (curr != null) {
                insertAtEnd(curr.data);
                curr = curr.next; //move to next item in list
            }
        } else if (size==2) {
            Node save = first;
            first=first.next;
            insertAtEnd(save.data);
        }
    }
}