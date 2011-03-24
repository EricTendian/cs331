
import java.util.ArrayList;

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
        if (size>0) this.addAux(root, key, val);
        else root = new Node(key, val);
        size++;
    }
    
    private void addAux(Node n, K key, V val) {
        if (key.compareTo(n.key)==0) return;
        else if (key.compareTo(n.key)<0) {
            if (n.left==null) n.left = new Node(key, val);
            else addAux(n.left, key, val);
        } else {
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
        else if (n.key.compareTo(key)>0) return findAux(n.right, key);
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
        else if (n.left!=null && n.right!=null) {
                n.key = minKey(n.right);
                n.right = remove(n.key, n.right);
        } else n = ( n.left != null ) ? n.left : n.right;
        return n;
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
        private Queue<Node> nodeQ;
        private ArrayList<Node> nodeL;
        private int index;
        private boolean valid;
        
        public BFSIterator() {
            nodeQ = new Queue<Node>();
            nodeL = new ArrayList<Node>();
            index = 0;
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
                /*if (parent==null) {parent = root; this.getNext();}
                else {
                    if (cursor.equals(parent.left) && hasRight) cursor = parent.right; //nav to right side
                    else {parent = cursor; this.getNext();} //go into subtree
                }*/
                if (index+1<nodeL.size()) {index++; cursor = nodeL.get(index);}
                else cursor = null;
            }
        }
        
        private void levelorder() {
            nodeQ.enqueue(root);
            while (nodeQ.size()>0) {
                Node n = nodeQ.dequeue();
                nodeL.add(n);
                if (n.left!=null) nodeQ.enqueue(n.left);
                if (n.right!=null) nodeQ.enqueue(n.right);
            }
            cursor = nodeL.get(0);
        }
        
        /*private void getNext() {
            //both sides
            if (parent.left!=null && parent.right!=null) {cursor = parent.left; hasRight = true;}
            else if (parent.left!=null) {cursor = parent.left; hasRight = false;} //left side only
            else if (parent.right!=null) {cursor = parent.right; hasRight = false;} //right side only
            else cursor = null;
        }*/

        public void delete() {
            if (size>0 && isValid()) {
                remove(cursor.key, cursor);
                size--;
                this.next();
            }
        }
    }
    
    public Iterator<K> mkBFSIterator() {
        return new BFSIterator();
    }
}