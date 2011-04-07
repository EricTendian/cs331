public class UpTree {
    public class Node<String extends Comparable> {
        public String data;
        public Node up;
        public int size;

        public Node(String val) {
            data = val;
            up = null;
            size = 0;
        }

        public Node(String val, Node parent) {
            data = val;
            up = parent;
            size = find(parent).size;
        }
    }
    
    private Node root;
    
    public UpTree() {
        root = null;
    }

    public int size() {
        return root.size;
    }

    public void add(String str) {
        if (size()>0) {
            
        } else root = new Node(str);
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
        public boolean isValid() {
            return false;
        }
        
        public int get() {
            return 0;
        }
        
        public void next() {
            
        }
    }
    
    private class SetIterator implements Iterator {
        public SetIterator(Node x) {
            
        }
        
        public boolean isValid() {
            return false;
        }
        
        public int get() {
            return 0;
        }
        
        public void next() {
            
        }
    }
}
