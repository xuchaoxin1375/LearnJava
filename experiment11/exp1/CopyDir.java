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
    /*���ݹ鸴�ƺ������м�鲢������Ŀ¼������,*/
    static void copyDir(String oldPath, String newPath) throws IOException {
        File file = new File(oldPath);
        String[] filePath = file.list();
        if (!(new File(newPath)).exists()) {
            (new File(newPath)).mkdir();//����Ŀ¼
        }

        for (String x : filePath) {
            /*�����(x)��һ����Ŀ¼:(ִ�еݹ�)*/
//            if ((new File(oldPath + File.separator + x)).isDirectory()) {
            //�ڲ�Ƕ���߳�,���漰����ʱ���������̵߳�����
//                Thread threadDelay = new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        /*�����sleep���Ǻ�����*/
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
        /*��������õ��̸߳���:(���߳�Ҳ������sleep)*/
            if ((new File(oldPath + File.separator + x)).isDirectory()) {
                try {
                    copyDir(oldPath + File.separator + x, newPath + File.separator + x);
                    //System.out.println("copying...");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            /* ����������ʱ��(����Ŀ¼����Ŀ�����).*/
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.println(CountDirSize.getCountSize(newPath));//���Ŀ��Ŀ¼�Ĵ�С

            /*���x��ָ���Ǹ��ļ�:ִ�и��Ƽ���*/
            if (new File(oldPath + File.separator + x).isFile()) {
                File source = new File(oldPath + File.separator + x);
                File dest = new File(newPath + File.separator + x);
                if (!(dest.exists())) {
                    Files.copy(source.toPath(), dest.toPath());//�������ļ�������
                }

            }
        }//endFor
        //System.out.println("The replication operation has been successfully executed!");
    }//endCopyFunction
}
