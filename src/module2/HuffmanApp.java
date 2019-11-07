package module2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HuffmanApp {
    public static void main(String[] args) {
        int operation = 0;
        Scanner scanner = new Scanner(System.in);

        while (operation != 3) {
            System.out.println("Choose type of operation:\n\t1. Compress\n\t2. Extract\n\t3. Exit");

            operation = scanner.nextInt();

            Huffman huffman = new Huffman();
            String inputFileName;
            String outputFileName;

            switch (operation) {
                case 1:
                    System.out.println("Enter full path to the text file:");
                    inputFileName = scanner.next();
                    outputFileName = inputFileName + ".cmp";
                    huffman.compress(inputFileName, outputFileName);
                    System.out.println("Compression complete. Compressed file - '" + outputFileName + "'");
                    break;
                case 2:
                    System.out.println("Enter full path to the cmp file:");
                    inputFileName = scanner.next();
                    outputFileName = inputFileName.replace(".txt.cmp", "_extracted.txt");
                    huffman.extract(inputFileName, outputFileName);
                    System.out.println("Extraction complete. Extracted file - '" + outputFileName + "'");
                    System.out.println("Content:");
                    printExtractedFile(outputFileName);
                    break;
                default:
                    break;
            }
        }
    }

    private static void printExtractedFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                System.out.println(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
