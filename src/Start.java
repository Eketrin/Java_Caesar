import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Start {

    private Scanner scanner = new Scanner(System.in);
    private Caesar caesar = new Caesar();
    private Check check = new Check();

    public void start() {
        while (true) {
            System.out.println("Что вы хотите сделать?");
            System.out.println("1. Зашифровать файл");
            System.out.println("2. Расшифровать файл");
            System.out.println("3. Расшифровка brute force");
            System.out.println("0. Выйти из программы");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    shifrFile();
                    break;
                case 2:
                    deshifrFile();
                    break;
                case 3:
                    bruteForce();
                    break;
                case 0:
                    System.out.println("Заходите ещё :)");
                    System.exit(0);
            }
        }
    }
    //   C:\Users\Alfa\Desktop\shifr.txt
    // запись идёт в 1 и тот же файл
    // шифруемся
    private void shifrFile() {

        System.out.print("Введите путь к файлу:");
        String file_path = scanner.nextLine();
        if (!check.fileExists(file_path)) {
            System.out.println("Файл не найден");
            return;
        }

        System.out.print("Введите ключ сдвига: ");
        int key = scanner.nextInt();
        scanner.nextLine();
        if (!check.isGoodKey(key)) {
            System.out.println("Недопустимый ключ");
            return;
        }

        try {
            String text_file = check.readFile(file_path);
            String encryptedContent = caesar.shifr_me(text_file, key);
            check.writeFile(file_path, encryptedContent);
            System.out.println("Файл зашифрован");
        } catch (IOException e) {
            System.out.println("Ошибка при чтении или записи файла");
        }
    }

    // расшифровываемся
    private void deshifrFile() {
        System.out.print("Введите путь к файлу: ");
        String file_path = scanner.nextLine();
        if (!check.fileExists(file_path)) {
            System.out.println("Файл не найден");
            return;
        }

        System.out.print("Введите ключ сдвига: ");
        int key = scanner.nextInt();
        scanner.nextLine();
        if (!check.isGoodKey(key)) {
            System.out.println("Недопустимый ключ");
            return;
        }

        try {
            String text_file = check.readFile(file_path);
            String decryptedContent = caesar.deshifr_me(text_file, key);
            check.writeFile(file_path, decryptedContent);
            System.out.println("Файл расшифрован");
        } catch (IOException e) {
            System.out.println("Ошибка при чтении или записи файла");
        }
    }

    // бруд форс
    private void bruteForce() {
        System.out.print("Введите путь к файлу:");
        String file_path = scanner.nextLine();
        if (!check.fileExists(file_path)) {
            System.out.println("Файл не найден");
            return;
        }

        try {
            String text_file = check.readFile(file_path);
            check.bruteForce(text_file);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла");
        }
    }
}
