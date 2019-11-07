package module2;

public class InternalNode extends Node {
    private Node left;
    private Node right;

    public InternalNode(Node left, Node right) {
        super(left.sum + right.sum);
        this.left = left;
        this.right = right;
    }

    @Override
    void buildCode(String code) {
        super.buildCode(code);
        left.buildCode(code + "1");
        right.buildCode(code + "0");
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
