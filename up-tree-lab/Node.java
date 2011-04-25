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