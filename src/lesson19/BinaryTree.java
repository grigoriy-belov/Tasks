package lesson19;

public class BinaryTree {

    private Node root;

    public BinaryTree(int root) {
        this.root = new Node(root);
    }

    private boolean add (int value) {
        return add(value, root);
    }

    private static boolean add (int value, Node root) {
        final int rootVal = root.value;
        final boolean added;
        if (rootVal == value) {
            added = false;
        } else if (rootVal < value) {
            if (root.left == null) {
                root.left = new Node(value);
                added = true;
            } else {
                added = add(value, root.left);
            }
        } else {
            if (root.right == null) {
                root.right = new Node(value);
                added = true;
            } else{
                added = add(value, root.right);
            }
        }
        return added;
    }

    public boolean contains(int value) {
        return contains(value, root);
    }

    private static boolean contains(int value, Node root) {
        final int rootVal = root.value;
        final boolean contains;
        if (rootVal == value) {
            contains = true;
        } else if (rootVal < value) {
            if (root.left == null) {
                contains = false;
            } else {
                contains = contains(value, root.left);
            }
        } else {
            if (root.right == null) {
                contains = false;
            } else{
                contains = contains(value, root.right);
            }
        }
        return contains;
    }

    public int min() {
        return min(root);
    }

    private static int min(Node root) {
        final int min;
        if (root.left == null) {
            min = root.value;
        } else {
            min = min(root.left);
        }
        return min;
    }

    public int max() {
        return max(root);
    }

    private static int max(Node root) {
        final int max;
        if (root.right == null) {
            max = root.value;
        } else {
            max = min(root.right);
        }
        return max;
    }

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}
