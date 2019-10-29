package lesson19;

public class Vertex {

    private String name;

    private boolean isInTree;

    public Vertex(String name) {
        this.name = name;
        isInTree = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isInTree() {
        return isInTree;
    }

    public void addToTree() {
        isInTree = true;
    }
}
