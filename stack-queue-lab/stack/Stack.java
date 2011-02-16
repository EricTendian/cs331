public class Stack<E> {
    private List<E> l;

    public Stack() {
        l = new List<E>();
    }
    
    public void push (E data) {
        l.insertAtFront(data);
    }
    
    public E pop () {
        return l.removeFromFront();
    }
    
    public E top () {
        E first = l.removeFromFront();
        l.insertAtFront(first);
        return first;
    }
    
    public int size() {
        return l.size();
    }
}