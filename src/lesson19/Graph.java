package lesson19;

public class Graph {

    private final int MAX_VERTICES = 20;
    private final int INFINITY = 200000;
    private Vertex[] vertexList;
    private int adjacencyMatrix[][];
    private int verticesQty;                // current number of vertices
    private int treeCapacity;               // number of vertices in tree
    private DistanceParent[] shortestPath;  // array for shortest-path data
    private int currentVertex;
    private int startToCurrent;             // distance to currentVertex

    public Graph() {
        vertexList = new Vertex[MAX_VERTICES];
        adjacencyMatrix = new int[MAX_VERTICES][MAX_VERTICES];
        verticesQty = 0;
        treeCapacity = 0;

        for (int i = 0; i < MAX_VERTICES; i++) {
            for (int j = 0; j < MAX_VERTICES; j++) {
                adjacencyMatrix[i][j] = INFINITY;
            }
        }
        shortestPath = new DistanceParent[MAX_VERTICES];
    }

    public void addVertex(String name) {
        vertexList[verticesQty++] = new Vertex(name);
    }

    public void addEdge(int start, int end, int weight) {
        adjacencyMatrix[start][end] = weight;
    }
}
