package lesson19;

import java.util.HashSet;
import java.util.Set;

public class Graph {
    private Set<Node> nodes = new HashSet<>();

    public void addNode(Node node) {
        nodes.add(node);
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public int getShortestDistance(Node target) {
        int result = -1;
        for (Node node : nodes) {
            if (node == target) {
                result = node.getDistance();
            }
        }
        return result;
    }
}
