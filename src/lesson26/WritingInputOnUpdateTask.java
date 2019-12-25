package lesson26;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class WritingInputOnUpdateTask implements Runnable {

    private Text input;

    public WritingInputOnUpdateTask(Text input) {
        this.input = input;
    }

    @Override
    public void run() {
        while (!input.getText().equals("quit")) {
            try {
                if (input.isUpdated()) {
                    Files.writeString(Paths.get("misc/files/output.txt"), input.getText(), StandardOpenOption.WRITE,
                            StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE);
                }
                Thread.sleep(1000);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }
    }
}
