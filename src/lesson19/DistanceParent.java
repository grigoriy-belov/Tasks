package lesson19;

public class DistanceParent implements Comparable<DistanceParent>{
    // distance and parent items stored in shortestPath array

    private int distance; // distance from start to this vertex

    private int parentVertex; // current parent of this vertex

    public DistanceParent(int parentVertex, int distance) {
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

    @Override
    public int compareTo(DistanceParent other) {
        return this.distance - other.distance;
    }
}
