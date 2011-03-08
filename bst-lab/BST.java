public class BST<K extends Comparable, V extends Comparable> {
    private int size;
    private Node root;
    
    private class Node {
        public K key;
        public V val;
        public Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
            left = null;
            right = null;
        }

        public Node(Node left, K key, V val, Node right) {
            this.key = key;
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public BST() {
        root = null;
        size = 0;
    }
    
    public int size() {
	return size;
    }
    
    public void add(K key, V val) {
        if (size>0) this.addAux(root, key, val);
        else root = new Node(key, val);
        size++;
    }
    
    private void addAux(Node n, K key, V val) {
        if (val.compareTo(n.val)==0) return;
        else if (val.compareTo(n.val)<0) {
            if (n.left==null) n.left = new Node(key, val);
            else addAux(n.left, key, val);
        } else if (val.compareTo(n.val)>0) {
            if (n.right==null) n.right = new Node(key, val);
            else addAux(n.right, key, val);
        }
    }
    
    public V find(K key) {
        return findAux(root, key);
    }
    
    private V findAux(Node n, K key) {
        if (n==null) return null;
        if (n.key.compareTo(key)==0) return n.val;
        else if (key.compareTo(n.key)>0) return findAux(n.right, key);
        else return findAux(n.left, key);
    }
    
    public void delete(K key) {
        if (size>0) {
            root = remove(key, root);
            size--;
        }
    }
    
    private Node remove(K key, Node n) {
        if (n == null) return null;
        
        if (key.compareTo(n.key)<0) n.left = remove(key, n.left);
        else if (key.compareTo(n.key)>0) n.right = remove(key, n.right);
        else {
            if (n.left!=null && n.right!=null) {
                n.key = minKey(n.right);
                n.right = remove(n.key, n.right);
            } else if (n.left!=null) n.left = ( n.left != null ) ? n.left : n.right;
            else if (n.right!=null) n.left = ( n.left != null ) ? n.left : n.right;
        } return n;
    }
    
    private K minKey(Node n) {
        if (n.left==null) return n.key;
        else return minKey(n.left);
    }
    
    public K revFind(V val) {
        if (size>0) if (size>0) return revFindAux(root, val);
        return null;
    }
    
    private K revFindAux(Node n, V val) {
        if (n==null) return null;
        if (n.val.compareTo(val)==0) return n.key;
        else if (val.compareTo(n.val)>0) return revFindAux(n.right, val);
        else return revFindAux(n.left, val);
    }
    
    public class BFSIterator implements Iterator<K> {
        private Node cursor;
        private boolean valid;

        public K get() {
            if (isValid()) return cursor.key;
            return null;
        }

        public boolean isValid() {
            valid = (cursor!=null);
            return valid;
        }

        public void next() {
            
        }

        public void delete() {
            if (size>0 && isValid()) {
                size--;
                this.next();
            }
        }
    }
    
    public Iterator<K> mkBFSIterator() {
        return new BFSIterator();
    }
}