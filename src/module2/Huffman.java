package module2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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


}
