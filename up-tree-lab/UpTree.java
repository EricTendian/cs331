import java.util.ArrayList;

public class UpTree {
    
    public class Node {
        public String data;
        public Node up;
        public int size;

        public Node(String val) {
            data = val;
            size = 1;
        }

        public Node(String val, Node parent) {
            data = val;
            up = parent;
            size = 1;
        }

        public int size() {
            return size;
        }
    }
    
    public ArrayList<Node> sets;
    
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
            
            for (Node n:sets) {
                if (find(n).equals(find(a)) || find(n).equals(find(b))) {
                    while (n.up!=n) {
                        n.size = 0;
                        n = n.up;
                    }
                    break;
                }
            }
        }
    }

    public Node find(Node y) {
        if (y.up!=null && y.up!=y) return find(y.up);
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
	public upIterator() {
            index = sets.size();
            next();
        }
        
        public boolean isValid() {
            return (curr!=null);
        }
        
        public Node get() {
            return curr;
        }
        
        public void next() {
	    if (index>0) {
                index--;
                curr = sets.get(index);
           } else curr = null;
        }
    }
    
    private class SetIterator implements Iterator {
        private Node curr;
        private Stack<Node> set;
        public SetIterator(Node find) {
            set = new Stack<Node>();
            for (Node n:sets) if (find(n).equals(find(find))) set.push(n);
            next();
        }
        
        public boolean isValid() {
            return curr!=null;
        }
        
        public Node get() {
            if (isValid()) return curr;
            return null;
        }
        
        public void next() {
            curr = set.pop();
        }
    }
}
