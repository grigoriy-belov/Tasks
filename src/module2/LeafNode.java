package module2;

public class LeafNode extends Node {
    private char symbol;

    public LeafNode(char symbol, int count) {
        super(count);
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
}
