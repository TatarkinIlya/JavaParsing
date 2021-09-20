import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Task1 {
    private static int counterOfOperations = 0;
    private static int logFileNumber = 1;

    public static void main(String[] args) throws IOException {
        /*
         * Программа принимает на вход файл с логами и делит его на несколько разных файлов.
         * Кол-во записаных операций в файле не более 1000.
         * Программа принимает на вход 2 аргумента:
         * 1) Лог файл, который нужно поделить
         * 2) Название результирующего файла
         */
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        FileWriter writer = new FileWriter(args[1] + logFileNumber + ".log");
        while (reader.ready()) {
            String str = reader.readLine();
            if (str.contains("INFO")) {
                counterOfOperations++;
                if (counterOfOperations == 1000) {
                    writer.close();
                    counterOfOperations = 0;
                    logFileNumber += 1;
                    writer = new FileWriter(args[1] + logFileNumber + ".log");
                }
            }
            writer.write(str + "\n");
        }
        reader.close();
        writer.close();
    }
}
