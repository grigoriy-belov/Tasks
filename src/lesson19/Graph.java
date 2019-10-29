package lesson19;

public class Graph {

    private final int MAX_VERTICES = 20;
    private final int INFINITY = 200000;
    private Vertex[] vertexList;
    private int adjacencyMatrix[][];
    private int verticesQty;                // current number of vertices
    private int treeVertsQty;               // number of vertices in tree
    private DistanceParent[] shortestPath;  // array for shortest-path data
    private int currentVertex;
    private int startToCurrent;             // distance to currentVertex

    public Graph() {
        vertexList = new Vertex[MAX_VERTICES];
        adjacencyMatrix = new int[MAX_VERTICES][MAX_VERTICES];
        verticesQty = 0;
        treeVertsQty = 0;

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

    // find all shortest paths
    public void path() {
        int startTree = 0;
        vertexList[startTree].addToTree();
        treeVertsQty++;

        // transfer row of distances from adjacencyMatrix to shortestPath
        for (int i = 0; i < verticesQty; i++) {
            int tempDistance = adjacencyMatrix[startTree][i];
            shortestPath[i] = new DistanceParent(startTree, tempDistance);
        }

        // until all vertices are in the tree
        while (verticesQty < treeVertsQty) {
            int indexMin = getMin();
            int minDist = shortestPath[indexMin].getDistance();

            if (minDist == INFINITY) {
                System.out.println("There are unreachable vertices");
                break;
            } else {
                // reset currentVertex to closest vertex
                currentVertex = indexMin;
                // minimum distance from startTree is to currentVertex and is startToCurrent
                startToCurrent = shortestPath[indexMin].getDistance();
            }
            // put current vertex in tree
            vertexList[currentVertex].addToTree();
            treeVertsQty++;
            // update shortestPath array
            adjustShortestPath();
        }


    }

    // get entry from shortestPath with minimum distance
    public int getMin() {
        return 0;
    }

    public void adjustShortestPath() {

    }
}
