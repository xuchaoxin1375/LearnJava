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
public class SingleThreadCopyPath{

    /*本递归复制函数具有检查并创建新目录的能力,*/

    /**
     * @param srcPath 可能是个目录,也可能是个文件
     * @param desPath 当srcPath 是一个目录的时候,desPath也必须是一个目录(1.约定该参数和srcPath是相同尾缀时;2.不用关心尾缀
     *                可能的参数组合包括:dir->dir;file->file;file->dir;(不可能是dir->file)
     * @throws IOException
     * @throws InterruptedException
     */
    static void copyPath(String srcPath, String desPath) throws IOException, InterruptedException {
        // System.out.println(count++);//testing(通过中途的内部打印来监视count的累计情况.)
        File srcPathFile = new File(srcPath);
        File desFile = new File(desPath);
        /* 如果源目标是个目录,则要保证目标目录存在: */
//        if (srcPathFile.isDirectory()&&!(new File(desPath)).exists()) {
//            (new File(desPath)).mkdir();//创建目录
//        }
        /*分析源路径*/
        if (srcPathFile.isDirectory()) {
            if (!(new File(desPath)).exists()) {
                desFile.mkdir();//创建目录
            }
            /*遍历当前目录下的子目录和文件(即各个条目)*/
            String[] filesPathString = srcPathFile.list();
            for (String subItem : filesPathString) {

                String absoluteSrcSubItemStr = srcPath + File.separator + subItem;
                String absoluteDesSubItemStr = desPath + File.separator + subItem;
                /*直接递归:*/
                copyPath(absoluteSrcSubItemStr, absoluteDesSubItemStr);
            }//endFor

        }//end if
        else {
            if (!desFile.exists()) {
                Files.copy(srcPathFile.toPath(), desFile.toPath());
            }
        }
    }
    //test the class
    public static void main(String[] args) {
        try {
            //计时开始.
            long startTime = System.currentTimeMillis();
            copyPath(FileName.fileName11_1, "D://src");
            System.out.println("单线程目录拷贝完成,共耗时" + (System.currentTimeMillis() - startTime) + "毫秒");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}//end class