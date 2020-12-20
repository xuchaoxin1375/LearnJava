package experiment8.exp1;

import java.io.File;
import java.util.Scanner;

public class PrintDirAndFiles {


    public static void main(String[] args) {

        System.out.println("输入一个目录名(绝对路径):");//  D:\OneDrive\Java\ProjectCodeInIDEA\src\experiment3
        /*String dirName1=(new Scanner(System.in)).nextLine();
        String dirName2=new Scanner(System.in).nextLine();*/
        Scanner scanner = new Scanner(System.in);
        String dirName = scanner.nextLine();
// 创建File对象
        File dir = new File(dirName);//小心不要写成:new File("dirName");
// 调用打印目录方法
        //printDir(dir);
//观察file.list()的效果:
/*        for(String x:dir.list()){
            System.out.println(x);
        }*/
        /*
结果:
exp1
exp2
exp3
exp4*/
    }

    /*编写(通过递归)打印各级(目录+文件名)的方法.
     * 这个方法黑箱可以这样描述:给他一个目录(当然可以是多级目录,并且每个目录都可以既有目录又有文件)
     * 如果遇到子目录目录,就立刻进入该子目录执行上述流程的操作,体现到代码中就是在此调用这个递归方法(一个调用语句,就代表了这个子进程的整个过程,至于子子进程乃至更深入的分支调用,在编写这个递归函数的时候可以跳过了,否则这个函数写不下了)*/
    public static void printDir(File dir) {
// 获取子文件和目录
        File[] files = dir.listFiles();
// 循环打印
/*
判断:
当是文件时,打印绝对路径.
当是目录时,继续调用打印目录的方法,形成递归调用.
*/
        for (File file : files) {
// 判断
            if (file.isFile()) {
// 是文件,输出文件绝对路径
                System.out.println("文件名:" + file.getAbsolutePath());
            } else {
// 是目录,输出目录绝对路径
                System.out.println("目录:" + file.getAbsolutePath());
// 继续遍历,调用printDir,形成递归
                printDir(file);

            }

        }

    }

}
