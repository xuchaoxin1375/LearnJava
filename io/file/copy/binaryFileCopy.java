package io.file.copy;

import namesAndStrings.FileName;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.io.*;

public class binaryFileCopy {
/*读入文本文件*/

    public static void binaryFileCopy(String srcFile,String desFileName) throws IOException {
        // BufferedReader bufferedReader= new BufferedReader(new FileReader(FileName.fileName10_1, StandardCharsets.UTF_8));
        /*套上Buffered之后,是字节缓冲流,效率区域尽可能的高,但其还是离不开基础流*/
        BufferedInputStream bufferedInputStream=new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(new FileOutputStream(desFileName));//不要写目录名:"d:/"之类的,是文件名!!
//        byte[] bytes = bufferedInputStream.readAllBytes();//这个方法不够通用(但对于小数据很方便,一句话)
        /**
         * 从输入流中读取所有剩余的字节。 该方法将阻塞，直到已读取所有剩余字节并检测到流的末尾或引发异常。 此方法不会关闭输入流。
         *
         * 当此流到达流的末尾时，对该方法的进一步调用将返回一个空字节数组。
         *
         * 请注意，此方法仅适用于简单的情况，在这些情况下，将所有字节读入字节数组很方便。 它不适用于读取具有大量数据的输入流。
         *
         * 输入流被异步关闭或在读取过程中线程被中断的情况下的行为是高度特定于输入流的，因此未指定。
         *
         * 如果从输入流读取时发生I / O错误，则可能在读取了一部分（但不是全部）字节之后才这样做。 因此，输入流可能不在流的末尾，并且可能处于不一致状态。 强烈建议如果发生I / O错误，请立即关闭流。
         */
        /*较为折衷的方式:循环*/
        byte[] customBytes= new byte[10000];

        int readLenth=0;
        while ((readLenth=bufferedInputStream.read(customBytes)) != -1) {
            bufferedOutputStream.write(customBytes,0,readLenth);
        }
        bufferedOutputStream.flush();
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }

    public static void main(String[] args) throws IOException {
       binaryFileCopy(FileName.fileNamePicture1, FileName.fileNameOutPicture1);
        System.out.println("task overed!");
    }
}
