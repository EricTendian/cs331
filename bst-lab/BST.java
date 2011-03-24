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

        public Node(K key, V val, Node left, Node right) {
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
        if (size>0) add(root, key, val);
        else root = new Node(key, val);
        size++;
    }
    
    private void add(Node n, K key, V val) {
        if (key.compareTo(n.key)==0) return;
        else if (key.compareTo(n.key)<0) {
            if (n.left==null) n.left = new Node(key, val);
            else add(n.left, key, val);
        } else {
            if (n.right==null) n.right = new Node(key, val);
            else add(n.right, key, val);
        }
    }
    
    public V find(K key) {
        return find(root, key);
    }
    
    private V find(Node n, K key) {
        if (n==null) return null;
        if (key.compareTo(n.key)==0) return n.val;
        else if (key.compareTo(n.key)<0) return find(n.left, key);
        else return find(n.right, key);
    }
    
    public void delete(K key) {
        if (size>0) {
            root = delete1(key, root);
            size--;
        }
    }
    
    private Node delete1(K key, Node n) {
        if (n == null) return null;
        if (key.compareTo(n.key)<0) n.left = delete1(key, n.left);
        else if (key.compareTo(n.key)>0) n.right = delete1(key, n.right);
        else {
	    if (n.left!=null && n.right!=null) {
                n.key = minKey(n.right);
                n.right = delete1(n.key, n);
            } else if (n.left!=null || n.right!=null) {
                if (n.left!=null) n = n.left;
		else n = n.right;
	    }
	    else n = null;
	} return n;
    }
    
    private K minKey(Node n) {
        if (n.left==null) return n.key;
        else return minKey(n.left);
    }
    
    public K revFind(V val) {
        if (size>0) return revFind(root, val);
        return null;
    }
    
    private K revFind(Node n, V val) {	
	if (n==null) return null;
	if (val.compareTo(n.val)==0) return n.key;
        else if (revFind(n.left,val)!=null) return revFind(n.left, val);
        else if (revFind(n.right,val)!=null) return revFind(n.right, val);
        else return null;
    }
    
    public class BFSIterator implements Iterator<K> {
        private Node cursor;
        private Queue<Node> nodeQ;
        private Queue<Node> q;
        private boolean valid;
        
        public BFSIterator() {
            nodeQ = new Queue<Node>();
            q = new Queue<Node>();
            levelorder();
        }
        
        public K get() {
            if (isValid()) return cursor.key;
            return null;
        }

        public boolean isValid() {
            valid = (cursor!=null);
            return valid;
        }

        public void next() {
            if (isValid()) {
                cursor = q.dequeue();
            }
        }
        
        private void levelorder() {
            nodeQ.enqueue(root);
            while (nodeQ.size()>0) {
                Node n = nodeQ.dequeue();
                q.enqueue(n);
                if (n.left!=null) nodeQ.enqueue(n.left);
                if (n.right!=null) nodeQ.enqueue(n.right);
            }
            cursor = q.dequeue();
	}

        public void delete() {
            if (size>0 && isValid()) {
                delete1(cursor.key, cursor);
                size--;
                this.next();
            }
        }
    }
    
    public Iterator<K> mkBFSIterator() {
        return new BFSIterator();
    }
}
