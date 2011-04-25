import java.util.ArrayList;

public class UpTree {
    
    public class Node {
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
            size = parent.size;
        }

        public int size() {
            return size;
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

    public Node add(String str) {
        Node n = new Node(str);
        n.up = n;
        sets.add(n);
        return n;
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

    public Iterator<Node> mkIterator() {
        return new upIterator();
    }

    public Iterator<Node> mkSetIterator(Node x) {
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
        
        public Node get() {
            return curr;
        }
        
        public void next() {
	    if (index>0) {
                if (set.isValid()) {
                    set.next();
                    curr = set.getNode();
                } else {
                    index--;
                    set = new SetIterator(sets.get(index));
                    curr = set.getNode();
                }
           } else curr = null;
        }
    }
    
    private class SetIterator implements Iterator {
        private Node curr;
        public SetIterator(Node find) {
            curr = sets.get(sets.indexOf(find));
        }
        
        public boolean isValid() {
            if (curr!=null) return (curr.up!=curr);
            return false;
        }
        
        public Node get() {
            return curr;
        }
        
        public void next() {
            if (isValid()) curr = curr.up;
        }
        
        public Node getNode() {
            return curr;
        }
    }
}
