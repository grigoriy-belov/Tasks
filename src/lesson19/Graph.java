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
    private int[] getShortestPaths(int start) {
        vertexList[start].addToTree();
        treeVertsQty++;

        // transfer row of distances from adjacencyMatrix to shortestPath
        for (int i = 0; i < verticesQty; i++) {
            int tempDistance = adjacencyMatrix[start][i];
            shortestPath[i] = new DistanceParent(start, tempDistance);
        }

        // until all vertices are in the tree
        while (treeVertsQty < verticesQty) {
            int indexMin = getMin(start);
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
            adjustShortestPath(start);
        }
        int[] result = new int[verticesQty];
        for (int i = 0; i < verticesQty; i++) {
            result[i] = shortestPath[i].getDistance();
        }
        return result;
    }

    public int path(int start, int end) {
        return getShortestPaths(start)[end];
    }

    // get entry from shortestPath with minimum distance
    private int getMin(int start) {
        int minDist = INFINITY;
        int indexMin = 0;

        for (int i = 0; i < verticesQty; i++) {
            if (!vertexList[i].isInTree() && shortestPath[i].getDistance() < minDist
                && i != start) {
                minDist = shortestPath[i].getDistance();
                indexMin = i;
            }
        }
        return indexMin;
    }

    private void adjustShortestPath(int start) {
        int column = 0;                // skip starting vertex
        // go across columns
        while (column < verticesQty) {
            // if this column's vertex already in tree, skip it
            if (vertexList[column].isInTree() || column == start) {
                column++;
                continue;
            }
            // calculate distance for one shortestPath entry
            // get edge from currentVertex to column
            int currentToFringe = adjacencyMatrix[currentVertex][column];
            // add distance from start
            int startToFringe = startToCurrent + currentToFringe;
            // get distance of current shortestPath entry
            int sPathDist = shortestPath[column].getDistance();

            // compare distance from start with shortPath entry
            if (startToFringe < sPathDist) {
                //  if shorter, update shortestPath
                shortestPath[column].setParentVertex(currentVertex);
                shortestPath[column].setDistance(startToFringe);
            }
            column++;
        }
    }

    public void displayPaths() {
        for (int j = 0; j < verticesQty; j++) {
            System.out.print(vertexList[j].getName() + "=");
            if (shortestPath[j].getDistance() == INFINITY)
                System.out.print("inf");
            else
                System.out.print(shortestPath[j].getDistance());
            String parent = vertexList[shortestPath[j].getParentVertex()].getName();
            System.out.print("(" + parent + ") ");
        }
        System.out.println("");
    }
}
