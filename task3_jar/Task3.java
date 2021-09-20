import java.io.*;
import java.util.Objects;

public class Task3 {
    public static void main(String[] args) throws IOException {
/*
        ��������� ��������� ���� ����� � ��������� �����. ��������� ��������� ����������� ����� ���������� � �������
        ��������:
        �������� ����������� ";". 17.11.2014;11:43:51.347;TRACE:;9.6.25.83:54650;Count is 1157
        ����� ��������� ���������� ��������� � ����� ����
        ��������� ��������� 3 ���������:
        1) �����������
        2) ����� � ������
        3) �������� ������ �����
         */

        File folder = new File(args[1]);
        File[] listOfFolders = folder.listFiles();
        String regex = " ";

        FileWriter writer = new FileWriter(args[2] + ".csv");
        for (int i = 0; i < Objects.requireNonNull(listOfFolders).length; i++) {
            if (listOfFolders[i].isFile()) {
                if (listOfFolders[i].getName().equals(args[2])) {
                    listOfFolders[i].delete();
                    continue;
                }
                BufferedReader reader = new BufferedReader(new FileReader(listOfFolders[i]));
                while (reader.ready()) {
                    String str = reader.readLine();
                    writer.write(str.replaceAll(regex, args[0]) + "\n");
                }
                reader.close();
            }

        }
        writer.close();
    }
}
