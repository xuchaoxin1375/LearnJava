package experiment11.exp1;

import namesAndStrings.FileName;

import java.io.File;

/**
 * @Author xuchaoxin
 * @Date 12/18/2020 9:10 PM
 * @Version 1.0
 */
public class CountPathSize {
    static long countSize = 0;

    /**
     * 该函数以绝对路径名字符串path为参数进行处理,注意,path所指的是dir还是file不需要知道(由函数进行分析即可)
     * @param path
     * @return
     */
    static void countPathSize(String path) {
        File pathFile = new File(path);
        String[] list = pathFile.list();
        if (pathFile.isDirectory()) {
            for (String items : list) {
                String subItem=path+File.separator+items;
                //递归调用.
                countPathSize(subItem);
            }
        } else {
            //this is a file.
            countSize += pathFile.length();//返回文件字节数(无法直接正确作用于文件夹)
            /**
             * Returns:
             * The length, in bytes, of the file denoted by this abstract pathname, or 0L if the file does not exist. Some operating systems may return 0L for pathNames denoting system-dependent entities such as devices or pipes.
             */
        }
        //return countSize;
    }

    public static long getCountSize(String path) {
        countPathSize(path);
        return countSize;
    }


    /*test the function:(it's ok)*/
    public static void main(String[] args) {
        System.out.println(getCountSize(FileName.fileName11_1));
    }
}
