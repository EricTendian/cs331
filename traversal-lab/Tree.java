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
        if (size>0) add(root, i);
        else root = new Node(i);
        size++;
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
            levelorder();
        }

        public int get() {
            if (isValid()) return cursor.val;
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
