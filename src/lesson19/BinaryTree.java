package lesson19;

public class BinaryTree {

    private Node root;

    private boolean add (int value) {
        return add(value, root);
    }

    private boolean add (int value, Node root) {
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

    private boolean contains(int value, Node root) {
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

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}
