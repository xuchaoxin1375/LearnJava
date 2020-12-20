package experiment11.exp1;

import experiment9.FileName;

import java.io.File;
import java.io.IOException;

/**
 * 1、	实现目录拷贝，同时显示复制的进度。   可用一个线程复制文件夹，另一个线程显示复制的进度。
 * 进度的表示是用当前复制的文件夹容量/源文件夹总容量来表示。*/

import static experiment11.exp1.CopyDir.copyDir;
import static java.lang.Thread.sleep;

public class CopyRate {
    // Scanner scanner = new Scanner(System.in);
    //System.out.println("输入被复制源目录名:");
    static String sourceDirectory = FileName.fileName11_1;
    static File sourceFile = new File(sourceDirectory);

    //System.out.println("输入副本目标目录名");
    public static String destinationDirectory = "d:/a";//D:\a scanner.nextLine();
    static File nowFile = new File(destinationDirectory);

    public static void main(String[] args) throws InterruptedException {

        // 源目录的大小(容量)
        long sourceFileSize = sourceFile.length();//由于main方法是static的，所有不能想非static的方法那样直接访问非static变量。（偷懒的话就将这些成员变量设为static了。

        // 打印执行比率的线程:
        Thread PrintRateThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    //some wrong usages of File.length() method.
//                    System.out.println(String.format("已经复制:" + ((double)nowFile.length() / sourceFileSize)));
                    // System.out.println("已经复制:" + nowFile.length());
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    long sizeDestination = CountPathSize.getCountSize(destinationDirectory),
                            sizeSource = CountPathSize.getCountSize(sourceDirectory);
                    double completionRate = sizeDestination * 1.0 / sizeSource;
                    System.out.printf("当前复制完成比:%.2f%%\n" ,100*completionRate);

                  /*  if ( completionRate == 1) {
                        break;
                    }*/
                /*    if (sizeDestination==sizeSource){
                        System.out.println(sizeDestination==sizeSource);
                        break;
                    }*/
                    if(Thread.currentThread().isInterrupted()){
                        System.out.printf("当前复制完成比:%.2f%%\n" ,100.00);
                        System.out.println("文件夹复制完成");
                        break;
                    }

                }
            }
        });//endThreadPrint
        Thread copyTread = new Thread(new Runnable() {
            @Override
            public void run() {
                {
                    try {
                        copyDir(sourceDirectory, destinationDirectory);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    PrintRateThread.interrupt();
                }
            }
        });//end copyThread
        //start the two threads:
        copyTread.start();
        PrintRateThread.start();
    }//endMain


}

