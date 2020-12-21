package experiment6.exp4;

import namesAndStrings.FileName;

import java.io.FileInputStream;
import java.io.IOException;

public class InputStreamDemo2 {
    public static void main(String[] args) throws IOException {
//1.创建FileInputStream对象,构造方法中绑定要读取的数据源
        FileInputStream fis = new FileInputStream(FileName.fileName8_1);
//2.使用FileInputStream对象中的方法read,读取文件
//int read()读取文件中的一个字节并返回，当读取到文件的末尾时返回-1
        byte[] bytes = new byte[1024]; //存储读取到的多个字节
        int len = 0; //记录读取到的字节
        while ((len = fis.read(bytes)) != -1) {
            /*every time we specify a len to operate,we can void null to be write.*/
            System.out.print(new String(bytes, 0, len));
            /*String(byte[] bytes, int offset, int length):把字节数组的一部分转换为字符串
             */
        }

//3.释放资源
        fis.close();

    }

}