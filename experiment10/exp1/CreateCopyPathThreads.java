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
    static List<Thread> list = new ArrayList<>();//�洢�̶߳���.
    /*���ݹ鸴�ƺ������м�鲢������Ŀ¼������,*/

    /**
     * @param srcPath �����Ǹ�Ŀ¼,Ҳ�����Ǹ��ļ�
     * @param desPath ��srcPath ��һ��Ŀ¼��ʱ��,desPathҲ������һ��Ŀ¼(1.Լ���ò�����srcPath����ͬβ׺ʱ;2.���ù���β׺
     *                ���ܵĲ�����ϰ���:dir->dir;file->file;file->dir;(��������dir->file)
     * @throws IOException
     * @throws InterruptedException
     */
    static void createCopyPathThreads(String srcPath, String desPath) throws IOException, InterruptedException {
        // System.out.println(count++);//testing(ͨ����;���ڲ���ӡ������count���ۼ����.)
        File srcPathFile = new File(srcPath);
        File desPathFile = new File(desPath);
        /* ���ԴĿ���Ǹ�Ŀ¼,��Ҫ��֤Ŀ��Ŀ¼����: */
//        if (srcPathFile.isDirectory()&&!(new File(desPath)).exists()) {
//            (new File(desPath)).mkdir();//����Ŀ¼
//        }
        /*����Դ·��*/
        if (srcPathFile.isDirectory()) {
            //ȷ����Ӧ��Ŀ��Ŀ¼����
            if (!(new File(desPath)).exists()) {
                desPathFile.mkdir();//����Ŀ¼
            }
            /*������ǰĿ¼�µ���Ŀ¼���ļ�(��������Ŀ)*/
            String[] filesPathString = srcPathFile.list();
            for (String subItem : filesPathString) {

                String absoluteSrcSubItemStr = srcPath + File.separator + subItem;
                String absoluteDesSubItemStr = desPath + File.separator + subItem;
//
//                File subItemFile = new File(absoluteSrcSubItemStr);
//                File desSubItemFile = new File(absoluteDesSubItemStr);
                /*ֱ�ӵݹ�:*/
                createCopyPathThreads(absoluteSrcSubItemStr, absoluteDesSubItemStr);

            }//endFor
        }//end if
        else {
            Thread thread = new Thread(() -> {
                if (!desPathFile.exists()) {
                    try {
                        //����file
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
     * //todo  ��Ӧ�����Ĳ���:�ȴ���������Ҫ�����Ľ���,Ȼ��ͳһstart;�ͽ�����߳�����ͳ������(ͳһjoin,�ͽ����ʱ��ͳ�Ƶ�����)(���Ҳ����˻�Ϊ���߳��Ŷ�ִ��.)���Է���,���̵Ĵ�����ִ�в��ǰ���һ���,����ͨ��start�����Ż�����.�ɼ����ô�(���)
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
        //��ʱ��ʼ.
        long startTime = System.currentTimeMillis();
        copyPath(FileName.fileName11_1, "D:/src");
        System.out.println("��������" + CreateCopyPathThreads.getCount() + "���߳�");
        System.out.println("Ŀ¼�������,����ʱ" + (System.currentTimeMillis() - startTime) + "����");
    }
}//end class
