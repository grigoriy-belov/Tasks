package module2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Huffman {
    private Map<Character, Node> charNodes = new HashMap<>();
    private BinaryOut out;
    private BinaryIn in;

    public void compress(String inputFileName, String outputFileName) {
        String input = getInput(inputFileName);
        Map<Character, Integer> charFrequency = getCharFrequency(input);
        Node root = buildTree(charFrequency);
        root.buildCode("");
        compress(root, input, outputFileName);
    }

    public void extract(String inputFileName, String outputFileName) {
        in = new BinaryIn(inputFileName);
        out = new BinaryOut(outputFileName);
        Node root = readTree();

        int length = in.readInt();
        for (int i = 0; i < length; i++) {
            Node node = root;
            while (!(node instanceof LeafNode)) {
                boolean bit = in.readBoolean();
                if (bit) node = ((InternalNode) node).getLeft();
                else node = ((InternalNode) node).getRight();
            }
            out.write(((LeafNode) node).getSymbol(), 8);
        }
        out.close();
    }

    private void compress(Node root, String input, String outputFileName) {
        out = new BinaryOut(outputFileName);
        writeTree(root);
        out.write(input.length());

        for (char c : input.toCharArray()) {
            String code = charNodes.get(c).getCode();
            for (char c1 : code.toCharArray()) {
                if (c1 == '0') {
                    out.write(false);
                } else if (c1 == '1') {
                    out.write(true);
                } else throw new IllegalStateException("Illegal state");
            }
        }
        out.close();
    }

    // reads text file and gets input string
    private String getInput(String fileName) {
        String input = "";
        try (FileInputStream in = new FileInputStream(fileName)) {
            StringBuilder sb = new StringBuilder();

            int c;
            while ((c = in.read()) != -1) {
                sb.append((char) c);
            }
            input = sb.toString();
        } catch (IOException e) {
            System.err.println("Could not open file");
        }
        return input;
    }

    // counts frequency of occurrence of each character in the text
    private Map<Character, Integer> getCharFrequency(String input) {
        Map<Character, Integer> charFrequency = new HashMap<>();

        for (char c : input.toCharArray()) {
            if (charFrequency.containsKey(c)) {
                charFrequency.put(c, charFrequency.get(c) + 1);
            } else {
                charFrequency.put(c, 1);
            }
        }
        return charFrequency;
    }

    // creates the tree using char frequency information and huffman algorithms
    private Node buildTree(Map<Character, Integer> charFrequency) {
        PriorityQueue<Node> queue = new PriorityQueue<>();

        for (Map.Entry<Character, Integer> entry : charFrequency.entrySet()) {
            LeafNode node = new LeafNode(entry.getKey(), entry.getValue());
            charNodes.put(entry.getKey(), node);
            queue.add(node);
        }

        while (queue.size() > 1) {
            Node first = queue.poll();
            Node second = queue.poll();

            assert second != null;
            InternalNode node = new InternalNode(first, second);
            queue.add(node);
        }
        return queue.poll();
    }

    // writes compression tree recursively to the file
    private void writeTree(Node node) {
        if (node instanceof LeafNode) {
            out.write(true);
            out.write(((LeafNode) node).getSymbol(), 8);
            return;
        }
        out.write(false);
        writeTree(((InternalNode) node).getLeft());
        writeTree(((InternalNode) node).getRight());
    }


    // reading recursively tree from the compressed file
    private Node readTree () {
        boolean isLeaf = in.readBoolean();

        if (isLeaf) return new LeafNode(in.readChar(), -1);
        else return new InternalNode(readTree(), readTree());
    }
}
