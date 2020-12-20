package experiment11.exp1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @Author xuchaoxin
 * @Date 12/18/2020 9:00 PM
 * @Version 1.0
 */
public class CopyDir {
    /*本递归复制函数具有检查并创建新目录的能力,*/
    static void copyDir(String oldPath, String newPath) throws IOException {
        File file = new File(oldPath);
        String[] filePath = file.list();
        if (!(new File(newPath)).exists()) {
            (new File(newPath)).mkdir();//创建目录
        }

        for (String x : filePath) {
            /*如果这(x)是一个子目录:(执行递归)*/
//            if ((new File(oldPath + File.separator + x)).isDirectory()) {
            //内部嵌套线程,又涉及到何时结束所有线程的问题
//                Thread threadDelay = new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        /*这里的sleep不是和有用*/
////                        try {
////                            Thread.sleep(100);
////                        } catch (InterruptedException e) {
////                            e.printStackTrace();
////                        }
//                        try {
//                            copyDir(oldPath + File.separator + x, newPath + File.separator + x);
//                            //System.out.println("copying...");
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                });
//                threadDelay.start();
//            }//end if
        /*这里仅采用单线程复制:(单线程也可设置sleep)*/
            if ((new File(oldPath + File.separator + x)).isDirectory()) {
                try {
                    copyDir(oldPath + File.separator + x, newPath + File.separator + x);
                    //System.out.println("copying...");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            /* 在这里拖延时间(不让目录过快的拷贝完).*/
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.println(CountDirSize.getCountSize(newPath));//检测目标目录的大小

            /*如果x所指的是个文件:执行复制即可*/
            if (new File(oldPath + File.separator + x).isFile()) {
                File source = new File(oldPath + File.separator + x);
                File dest = new File(newPath + File.separator + x);
                if (!(dest.exists())) {
                    Files.copy(source.toPath(), dest.toPath());//创建新文件的能力
                }

            }
        }//endFor
        //System.out.println("The replication operation has been successfully executed!");
    }//endCopyFunction
}
