import java.util.ArrayList;

public class UpTree {
    public class Node<String extends Comparable> {
        public String data;
        public Node up;
        public int size;

        public Node(String val) {
            data = val;
            up = null;
            size = 1;
        }

        public Node(String val, Node parent) {
            data = val;
            up = parent;
            size = find(parent).size;
        }
    }
    
    private ArrayList<Node> sets;
    
    public UpTree() {
        sets = new ArrayList<Node>();
    }

    public int size() {
        int size = 0;
	for (Node n:sets) size+=find(n).size;
	return size;
    }

    public void add(String str) {
        Node n = new Node(str);
        n.up = n;
        sets.add(n);
    }

    public void union(Node x, Node y) {
        Node a = find(x);
        Node b = find(y);
        if (a!=b) {
            if (a.size > b.size) {
                b.up = a; a.size+=b.size;
            } else {
                a.up = b; b.size+=a.size;
            }
        }
    }

    public Node find(Node y) {
        if (y.up!=null) return find(y);
        else return y;
    }

    public Iterator mkIterator() {
        return new upIterator();
    }

    public Iterator mkSetIterator(Node x) {
        return new SetIterator(x);
    }
    
    
    private class upIterator implements Iterator {
        private Node curr;
        private int index;
        private SetIterator set;
	public upIterator() {
            index = sets.size()-1;
            curr = sets.get(index);
	    set = new SetIterator(curr);
        }
        
        public boolean isValid() {
            return (curr!=null);
        }
        
        public String get() {
            return curr.data;
        }
        
        public void next() {
	    if (index>0) {
                if (set.isValid()) {
                    set.next();
                    curr = set.get();
                } else {
                    index--;
                    set = new SetIterator(sets.get(index));
                    curr = set.get();
                }
           } else curr = null;
        }
    }
    
    private class SetIterator implements Iterator {
        private Node curr;
        private Node find;
        public SetIterator(Node x) {
            find = x;
            for (int i=sets.size()-1; i>=0; i--) {
                Node node = sets.get(i);
                if (node.equals(find)) curr = node;
            }
        }
        
        public boolean isValid() {
            if (curr!=null) return (curr.up!=curr);
            return false;
        }
        
        public String get() {
            return curr.data;;
        }
        
        public void next() {
            if (isValid()) curr = curr.up;
        }
    }
}
