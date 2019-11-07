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


    }

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
            e.printStackTrace();
        }
        return input;
    }

    private Map<Character, Integer> getCharFrequencyFromText(String input) {
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

            InternalNode node = new InternalNode(first, second);
            queue.add(node);
        }
        return queue.poll();
    }


}
