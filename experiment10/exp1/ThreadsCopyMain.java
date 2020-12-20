package experiment10.exp1;
/*用多线程的方法实现目录拷贝*/

import experiment9.FileName;

import java.util.Scanner;

public class ThreadsCopyMain {
    static int count = 0;


    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        //todo read
        System.out.println("输入被复制源目录名:");
        String sourceDirectory = FileName.fileName11_1; //scanner.nextLine();

        System.out.println("输入副本目标目录名");
        String destinationDirectory = "D:\\src"; //scanner.nextLine();
        //计时开始.
        long startTime = System.currentTimeMillis();
        /*调用多线程复制函数*/
        CreateCopyPathThreads.copyPath(sourceDirectory, destinationDirectory);
        System.out.println("共启用了" + CreateCopyPathThreads.getCount() + "个线程");
        /*调用单线程版对比*/
        //SingleThreadCopyPath.copyPath(sourceDirectory,destinationDirectory);
        System.out.println("目录拷贝完成,共耗时" + (System.currentTimeMillis() - startTime) + "毫秒");
        // System.out.println("over!");
    }


}
