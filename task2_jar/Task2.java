import java.io.*;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
    public static void main(String[] args) throws IOException {
        /*
        Программа проходит по указанной папке и проверяет все файлы на наличие указанного слова,
        затем выводит строки с этим словом в указанный файл.
        Программа принимает 3 агрумента:
        1) Слово, которое ищем
        2) Путь до папки
        3) Имя результирующего файла
         */
        Pattern pattern = Pattern.compile(args[0]);
        File folder = new File(args[1]);
        File[] listOfFolders = folder.listFiles();
        FileWriter writer = new FileWriter(args[2]);

        for (int i = 0; i < Objects.requireNonNull(listOfFolders).length; i++) {
            if (listOfFolders[i].isFile()) {
                if (listOfFolders[i].getName().equals(args[2])) {
                    listOfFolders[i].delete();
                    continue;
                }
                    BufferedReader reader = new BufferedReader(new FileReader(listOfFolders[i]));
                    while (reader.ready()) {
                        String str = reader.readLine();
                        Matcher matcher = pattern.matcher(str);
                        if (matcher.find()) {
                            writer.write(str + "\n");
                        }
                    }
                    reader.close();
                }

            }
            writer.close();
        }
    }


