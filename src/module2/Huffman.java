package module2;

import java.util.HashMap;
import java.util.Map;

public class Huffman {
    private Map<Character, Node> charNodes = new HashMap<>();
    private BinaryOut out;
    private BinaryIn in;

    public void compress(String inputFileName, String outputFileName) {

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

}
