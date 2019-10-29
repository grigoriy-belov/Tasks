package lesson19;

public class DistanceParent {
    // distance and parent items stored in shortestPath array

    private int distance; // distance from start to this vertex

    private int parentVertex; // current parent of this vertex

    public DistanceParent(int distance, int parentVertex) {
        this.distance = distance;
        this.parentVertex = parentVertex;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getParentVertex() {
        return parentVertex;
    }

    public void setParentVertex(int parentVertex) {
        this.parentVertex = parentVertex;
    }
}
