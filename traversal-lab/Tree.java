public class Tree {
    private Node root;

    private class Node {
        public int val;
        public Node left, right;

        public Node(int val) {
            this.val = val;
            left = null;
            right = null;
        }

        public Node(int i, Node left, Node right) {
            this.val = i;
            this.left = left;
            this.right = right;
        }
    }

    public Tree() {
        root = null;
    }
    public void add(int i) {
        if (root!=null) add(root, i);
        else root = new Node(i);
    }

    private void add(Node n, int i) {
        if (i==n.val) return;
        else if (i<n.val) {
            if (n.left==null) n.left = new Node(i);
            else add(n.left, i);
        } else {
            if (n.right==null) n.right = new Node(i);
            else add(n.right, i);
        }
    }

    public class BFSIterator implements Iterator {
        private Node cursor;
        private Queue<Node> nodeQ;
        private Queue<Node> q;
        private boolean valid;

        public BFSIterator() {
            nodeQ = new Queue<Node>();
            q = new Queue<Node>();
            BFS();
        }

        public int get() {
            if (isValid()) return cursor.val;
            return -1;
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

        private void BFS() {
            nodeQ.enqueue(root);
            while (nodeQ.size()>0) {
                Node n = nodeQ.dequeue();
                q.enqueue(n);
                if (n.left!=null) nodeQ.enqueue(n.left);
                if (n.right!=null) nodeQ.enqueue(n.right);
            }
            cursor = q.dequeue();
        }
    }
    
    public class DFSIterator implements Iterator {
        private Node cursor;
        private Queue<Node> q;
        private boolean valid;

        public DFSIterator() {
            q = new Queue<Node>();
            DFS(root);
        }

        public int get() {
            if (isValid()) return cursor.val;
            return -1;
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
        
        private void DFS(Node n) {
            q.enqueue(n);
            if (n.left!=null) DFS(n.left);
            if (n.right!=null) DFS(n.right);
        }
    }

    public class PreorderIterator implements Iterator {
        private Node cursor;
        private Queue<Node> q;
        private boolean valid;

        public PreorderIterator() {
            q = new Queue<Node>();
            preorder(root);
        }

        public int get() {
            if (isValid()) return cursor.val;
            return -1;
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
        
        private void preorder(Node n) {
            q.enqueue(n);
            if (n.left!=null) preorder(n.left);
            if (n.right!=null) preorder(n.right);
        }
    }
    
    public class InorderIterator implements Iterator {
        private Node cursor;
        private Queue<Node> q;
        private boolean valid;

        public InorderIterator() {
            q = new Queue<Node>();
            inorder(root);
        }

        public int get() {
            if (isValid()) return cursor.val;
            return -1;
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
        
        private void inorder(Node n) {
            if (n.left!=null) inorder(n.left);
            q.enqueue(n);
            if (n.right!=null) inorder(n.right);
        }
    }
    
    public class PostorderIterator implements Iterator {
        private Node cursor;
        private Queue<Node> q;
        private boolean valid;

        public PostorderIterator() {
            q = new Queue<Node>();
            postorder(root);
        }

        public int get() {
            if (isValid()) return cursor.val;
            return -1;
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
        
        private void postorder(Node n) {
            if (n.left!=null) postorder(n.left);
            if (n.right!=null) postorder(n.right);
            q.enqueue(n);
        }
    }
    
    public class FrontierIterator implements Iterator {
        private Node cursor;
        private boolean valid;

        public FrontierIterator() {
        }

        public int get() {
            if (isValid()) return cursor.val;
            return -1;
        }

        public boolean isValid() {
            valid = (cursor!=null);
            return valid;
        }

        public void next() {
            if (isValid()) {
            }
        }
    }

    public Iterator mkBFSIterator() {
        return new BFSIterator();
    }

    public Iterator mkDFSIterator() {
        return new DFSIterator();
    }

    public Iterator mkPreorderIterator() {
        return new PreorderIterator();
    }

    public Iterator mkInorderIterator() {
        return new InorderIterator();
    }

    public Iterator mkPostorderIterator() {
        return new PostorderIterator();
    }

    public Iterator mkFrontierIterator() {
        return new FrontierIterator();
    }
}
