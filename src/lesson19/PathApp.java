package lesson19;

public class PathApp {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex("gdansk");
        graph.addVertex("bydgoszcz");
        graph.addVertex("torun");
        graph.addVertex("warszawa");

        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 0, 1);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 4);
        graph.addEdge(2, 0, 3);
        graph.addEdge(2, 1, 1);
        graph.addEdge(2, 3, 1);
        graph.addEdge(3, 1, 4);
        graph.addEdge(3, 2, 1);

        System.out.println(graph.path(1, 3));
    }
}
