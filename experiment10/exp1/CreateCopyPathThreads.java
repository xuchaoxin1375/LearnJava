package experiment10.exp1;

import experiment9.FileName;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author xuchaoxin
 * @Date 12/19/2020 9:41 AM
 * @Version 1.0
 */
public class CreateCopyPathThreads {
    static int count = 0;
    static List<Thread> list = new ArrayList<>();//存储线程对象.
    /*本递归复制函数具有检查并创建新目录的能力,*/

    /**
     * @param srcPath 可能是个目录,也可能是个文件
     * @param desPath 当srcPath 是一个目录的时候,desPath也必须是一个目录(1.约定该参数和srcPath是相同尾缀时;2.不用关心尾缀
     *                可能的参数组合包括:dir->dir;file->file;file->dir;(不可能是dir->file)
     * @throws IOException
     * @throws InterruptedException
     */
    static void createCopyPathThreads(String srcPath, String desPath) throws IOException, InterruptedException {
        // System.out.println(count++);//testing(通过中途的内部打印来监视count的累计情况.)
        File srcPathFile = new File(srcPath);
        File desPathFile = new File(desPath);
        /* 如果源目标是个目录,则要保证目标目录存在: */
//        if (srcPathFile.isDirectory()&&!(new File(desPath)).exists()) {
//            (new File(desPath)).mkdir();//创建目录
//        }
        /*分析源路径*/
        if (srcPathFile.isDirectory()) {
            //确保对应的目标目录存在
            if (!(new File(desPath)).exists()) {
                desPathFile.mkdir();//创建目录
            }
            /*遍历当前目录下的子目录和文件(即各个条目)*/
            String[] filesPathString = srcPathFile.list();
            for (String subItem : filesPathString) {

                String absoluteSrcSubItemStr = srcPath + File.separator + subItem;
                String absoluteDesSubItemStr = desPath + File.separator + subItem;
//
//                File subItemFile = new File(absoluteSrcSubItemStr);
//                File desSubItemFile = new File(absoluteDesSubItemStr);
                /*直接递归:*/
                createCopyPathThreads(absoluteSrcSubItemStr, absoluteDesSubItemStr);

            }//endFor
        }//end if
        else {
            Thread thread = new Thread(() -> {
                if (!desPathFile.exists()) {
                    try {
                        //复制file
                        Files.copy(srcPathFile.toPath(), desPathFile.toPath());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.setName("threadNo" + count++);
            list.add(thread);
        }
        //System.out.println("The replication operation has been successfully executed!");
    }//endCopyFunction

    public static int getCount() {
        return count = list.size();
    }

    /**
     * //todo  相应而生的策略:先创建所有需要创建的进程,然后统一start;就解决了线程数的统计问题(统一join,就解决了时间统计的问题)(而且不会退化为单线程排队执行.)可以发现,进程的创建和执行不是绑在一起的,而是通过start方法才会启动.可见其用处(灵活)
     * @param srcPath
     * @param desPath
     * @throws InterruptedException
     */
    public static void copyPath(String srcPath, String desPath) throws InterruptedException, IOException {
        createCopyPathThreads(srcPath, desPath);
        for (Thread thread : list) {
            thread.start();
        }
        for (Thread thread : list) {
            thread.join();
        }
    }

    //test the class
    public static void main(String[] args) throws IOException, InterruptedException {
        //计时开始.
        long startTime = System.currentTimeMillis();
        copyPath(FileName.fileName11_1, "D:/src");
        System.out.println("共启用了" + CreateCopyPathThreads.getCount() + "个线程");
        System.out.println("目录拷贝完成,共耗时" + (System.currentTimeMillis() - startTime) + "毫秒");
    }
}//end class
