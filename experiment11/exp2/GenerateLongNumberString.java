package experiment11.exp2;

import namesAndStrings.FileName;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Random;

/**
 * @Author xuchaoxin
 * @Date 12/22/2020 2:04 PM
 * @Version 1.0
 */
public class GenerateLongNumberString {
    static String generateLongNumberString(String fileOutputAbsolutePath,int numberLenth){

        Random random=new Random();

        StringBuilder stringBuilder=new StringBuilder();
        /*method1:*/
        for (int i = 0; i < numberLenth; i++) {
            stringBuilder.append(""+random.nextInt(10));
        }
        /*method2:*/
       // stringBuilder.append(""+random.nextInt((BigInteger)Math.pow(10, 100000)));
        return stringBuilder.toString();
    }
    static void generateLongNumberStringFile(String fileOutputAbsolutePath,int numberLenth) throws IOException {
        File fileOut = new File(fileOutputAbsolutePath);
        PrintStream printStream=new PrintStream(fileOut);
        printStream.write(generateLongNumberString(fileOutputAbsolutePath,numberLenth).getBytes()) ;
    }
    public static void main(String[] args) throws IOException {
        generateLongNumberStringFile(FileName.desktopPath+"number_100000.txt",100000);
        //System.out.println(random.nextInt());
       // System.out.println(random.nextInt(10));
    }
}
