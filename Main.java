import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ProcessFile obj = new ProcessFile();     // создаём объект класса для работы с файлами

        obj.openFile(sc);
        try {
            obj.processFile();

            obj.createFile(sc);

            obj.fillOutputFile();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
