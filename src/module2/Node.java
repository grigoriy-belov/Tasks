package module2;

public class Node implements Comparable<Node> {
    protected final int sum;
    protected String code;

    public Node(int sum) {
        this.sum = sum;
    }

    void buildCode(String code) {
        this.code = code;
    }

    public int getSum() {
        return sum;
    }

    public String getCode() {
        return code;
    }

    @Override
    public int compareTo(Node node) {
        return Integer.compare(sum, node.sum);
    }
}
