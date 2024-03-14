import java.io.*;
import java.util.Scanner;

public class ProcessFile {
    private int[] ascii;
    private File inputFile;
    private File outputFile;
    public ProcessFile()
    {
        ascii = new int[256];
    }
    public void openFile(Scanner sc)     // выбор файла для чтения
    {
        System.out.print("Введите имя файла для чтения: ");
        String inputName = sc.nextLine();
        inputFile = new File(inputName);
    }

    public void processFile() throws IOException {     // чтение файла и анализ его содержимого с подсчетом символов
        FileReader reader = new FileReader(inputFile);
        char[] buff = new char[1000];
        while (reader.read(buff, 0, 1000) != -1)
        {
            this.countSymb(buff);
        }
        reader.close();
    }
    private void countSymb(char[] line)     // подсчёт символов в тексте
    {
        for (int i = 0; i < line.length; i++)
        {
            ascii[(int)line[i]]++;
        }
    }

    public void createFile(Scanner sc) throws IOException {     // создание файла для записи результата
        System.out.print("Введите имя файла для записи: ");
        String outputName = sc.nextLine();
        outputFile = new File(outputName);
        boolean flag = outputFile.createNewFile();
        if (flag)
        {
            System.out.println("Файл создан");
        }
        else {
            System.out.println("Файл уже существует");
        }
    }
    public void fillOutputFile() throws IOException {     // запись результатов подсчета в выходной файл
        FileWriter writer = new FileWriter(outputFile);
        for (int i = 0; i < 256; i++)
        {
            if (ascii[i] != 0 && (i >= 65 && i <= 90 || i >= 97 && i <= 122))
            {
                String str = (char)i + ": " + ascii[i] + '\n';
                writer.write(str, 0, str.length());
            }
        }
        writer.close();
    }
}
