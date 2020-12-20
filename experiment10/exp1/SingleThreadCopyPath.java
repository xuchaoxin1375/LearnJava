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

    /*���ݹ鸴�ƺ������м�鲢������Ŀ¼������,*/

    /**
     * @param srcPath �����Ǹ�Ŀ¼,Ҳ�����Ǹ��ļ�
     * @param desPath ��srcPath ��һ��Ŀ¼��ʱ��,desPathҲ������һ��Ŀ¼(1.Լ���ò�����srcPath����ͬβ׺ʱ;2.���ù���β׺
     *                ���ܵĲ�����ϰ���:dir->dir;file->file;file->dir;(��������dir->file)
     * @throws IOException
     * @throws InterruptedException
     */
    static void copyPath(String srcPath, String desPath) throws IOException, InterruptedException {
        // System.out.println(count++);//testing(ͨ����;���ڲ���ӡ������count���ۼ����.)
        File srcPathFile = new File(srcPath);
        File desFile = new File(desPath);
        /* ���ԴĿ���Ǹ�Ŀ¼,��Ҫ��֤Ŀ��Ŀ¼����: */
//        if (srcPathFile.isDirectory()&&!(new File(desPath)).exists()) {
//            (new File(desPath)).mkdir();//����Ŀ¼
//        }
        /*����Դ·��*/
        if (srcPathFile.isDirectory()) {
            if (!(new File(desPath)).exists()) {
                desFile.mkdir();//����Ŀ¼
            }
            /*������ǰĿ¼�µ���Ŀ¼���ļ�(��������Ŀ)*/
            String[] filesPathString = srcPathFile.list();
            for (String subItem : filesPathString) {

                String absoluteSrcSubItemStr = srcPath + File.separator + subItem;
                String absoluteDesSubItemStr = desPath + File.separator + subItem;
                /*ֱ�ӵݹ�:*/
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
            //��ʱ��ʼ.
            long startTime = System.currentTimeMillis();
            copyPath(FileName.fileName11_1, "D://src");
            System.out.println("���߳�Ŀ¼�������,����ʱ" + (System.currentTimeMillis() - startTime) + "����");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}//end class