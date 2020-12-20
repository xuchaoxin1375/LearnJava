package experiment10.exp1.ThreadsDemos;

import namesAndStrings.FileName;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @Author xuchaoxin
 * @Date 12/19/2020 10:27 AM
 * @Version 1.0
 */
public class TestCopy {
    public static void main(String[] args) {
        File srcPath=new File(FileName.fileName10_1),
                desPath = new File("D:\\hhh");
        try {
            /**
             * public static java.nio.file.Path copy(@NotNull java.nio.file.Path source,
             *                                       @NotNull java.nio.file.Path target,
             *                                       java.nio.file.CopyOption... options)
             * throws java.io.IOException
             * 其中第二个参数是指定文件名(副本文件的文件名)
             * */
            Files.copy(srcPath.toPath(), desPath.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
