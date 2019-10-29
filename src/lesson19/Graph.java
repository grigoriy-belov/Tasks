package lesson19;

import java.util.Map;
import java.util.TreeMap;

public class Graph {

    private final int MAX_VERTICES = 20;
    private final int INFINITY = 200000;
    private Vertex[] vertexList;
    private int adjacencyMatrix[][];
    private int verticesQty;                // current number of vertices
    private int treeVertsQty;               // number of vertices in tree
    private TreeMap<Integer, DistanceParent> shortestPath;  // array for shortest-path data
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
        shortestPath = new TreeMap<>();
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
            shortestPath.put(i, new DistanceParent(start, tempDistance));
        }

        // until all vertices are in the tree
        while (treeVertsQty < verticesQty) {
            Map.Entry<Integer, DistanceParent> entry = getMinDistance(start);
            int minDist = entry.getValue().getDistance();

            if (minDist == INFINITY) {
                System.out.println("There are unreachable vertices");
                break;
            } else {
                // reset currentVertex to closest vertex
                currentVertex = entry.getKey();
                // minimum distance from startTree is to currentVertex and is startToCurrent
                startToCurrent = entry.getValue().getDistance();
            }
            // put current vertex in tree
            vertexList[currentVertex].addToTree();
            treeVertsQty++;
            // update shortestPath array
            adjustShortestPath(start);
        }
        int[] result = new int[verticesQty];
        for (int i = 0; i < verticesQty; i++) {
            result[i] = shortestPath.get(i).getDistance();
        }
        return result;
    }

    public int path(int start, int end) {
        return getShortestPaths(start)[end];
    }

    // get entry from shortestPath with minimum distance
    private Map.Entry<Integer, DistanceParent> getMinDistance(int start) {
        Map.Entry<Integer, DistanceParent> result = null;
        for (Map.Entry<Integer, DistanceParent> entry : shortestPath.entrySet()) {
            if (!vertexList[entry.getKey()].isInTree())
                result =  entry;
        }
        return result;
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
            int sPathDist = shortestPath.get(column).getDistance();

            // compare distance from start with shortPath entry
            if (startToFringe < sPathDist) {
                //  if shorter, update shortestPath
                shortestPath.get(column).setParentVertex(currentVertex);
                shortestPath.get(column).setDistance(startToFringe);
            }
            column++;
        }
    }
}
