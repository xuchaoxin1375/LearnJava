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
        /*创建源目录对应的File对象.*/
        File inputFile = new File(absoluteFileName);
        /* 用Scanner类根据传入的File对象生成对应的流. */
        Scanner scanner = new Scanner(inputFile);
        /*也可以并作一步(其实IDE会提示你参数类型的,还是能够比较容易的写出来的)*/
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
        /*观察效果.*/
        System.out.println(builder);
        //File fileOutput = new File(absoluteFileName);
        PrintWriter writer = new PrintWriter(absoluteFileName);
        writer.write(builder.toString());
        writer.close();
    }
}
