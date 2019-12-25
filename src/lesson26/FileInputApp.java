package lesson26;

import java.io.*;

public class FileInputApp {
    public static void main(String[] args) {

        Text input = new Text("");
        WritingInputOnUpdateTask writingInputOnUpdateTask = new WritingInputOnUpdateTask(input);
        new Thread(new WritingInputOnUpdateTask(input)).start();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (!input.getText().equals("quit")) {
                input.setText(reader.readLine());
            }
        }
         catch (IOException e) {
            e.printStackTrace();
        }
    }
}
