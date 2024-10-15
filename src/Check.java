import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
public class Check {
    public boolean isGoodKey(int key) {
        return key >= 0 && key < 33;
    }

    public boolean fileExists(String filePath) {
        return Files.exists(Paths.get(filePath));
    }

    public String readFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    public void writeFile(String filePath, String content) throws IOException {
        Files.write(Paths.get(filePath), content.getBytes());
    }
    //бруд форс
    private Caesar cipher = new Caesar();

    public void bruteForce(String text_file) {
        for (int key = 0; key < 33; key++) {
            String deshifrText = cipher.deshifr_me(text_file, key);
            System.out.println("Ключ " + key + ": " + deshifrText);
        }
    }
}
