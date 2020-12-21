package FileProcessor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @Author xuchaoxin
 * @Date 12/19/2020 6:42 PM
 * @Version 2.0
 */
public class SeparatorDivideLines {
    public static void main(String[] args) throws FileNotFoundException {
        String filePrefix = "C:/users/xuchaoxin/desktop/";

        System.out.println("Please input a file name in your desktop:");
        String fileName = new Scanner(System.in).nextLine();
        String absoluteFileName = filePrefix + fileName;
        System.out.println("input a separator:");
        String separator = new Scanner(System.in).nextLine();
        /*����ԴĿ¼��Ӧ��File����.*/
        File inputFile = new File(absoluteFileName);
        /* ��Scanner����ݴ����File�������ɶ�Ӧ����. */
        Scanner scanner = new Scanner(inputFile);
        /*Ҳ���Բ���һ��(��ʵIDE����ʾ��������͵�,�����ܹ��Ƚ����׵�д������)*/
       // Scanner sr=new Scanner(new File(absoluteFileName));

        StringBuilder builder = new StringBuilder();
        String tempStr = "";
        while (scanner.hasNextLine()) {
            String[] split = scanner.nextLine().split(separator);

            for (int i = 0; i < split.length; i++) {
                builder.append(split[i] + separator + "\n");
            }

        }
        scanner.close();
        /*�۲�Ч��.*/
        System.out.println(builder);
        //File fileOutput = new File(absoluteFileName);
        PrintWriter writer = new PrintWriter(absoluteFileName);
        writer.write(builder.toString());
        writer.close();
    }
}
