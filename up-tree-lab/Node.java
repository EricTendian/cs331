public class Node {
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
