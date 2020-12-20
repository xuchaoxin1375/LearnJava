package experiment11.exp1;

import experiment9.FileName;

import java.io.File;
import java.io.IOException;

/**
 * 1��	ʵ��Ŀ¼������ͬʱ��ʾ���ƵĽ��ȡ�   ����һ���̸߳����ļ��У���һ���߳���ʾ���ƵĽ��ȡ�
 * ���ȵı�ʾ���õ�ǰ���Ƶ��ļ�������/Դ�ļ�������������ʾ��*/

import static experiment11.exp1.CopyDir.copyDir;
import static java.lang.Thread.sleep;

public class CopyRate {
    // Scanner scanner = new Scanner(System.in);
    //System.out.println("���뱻����ԴĿ¼��:");
    static String sourceDirectory = FileName.fileName11_1;
    static File sourceFile = new File(sourceDirectory);

    //System.out.println("���븱��Ŀ��Ŀ¼��");
    public static String destinationDirectory = "d:/a";//D:\a scanner.nextLine();
    static File nowFile = new File(destinationDirectory);

    public static void main(String[] args) throws InterruptedException {

        // ԴĿ¼�Ĵ�С(����)
        long sourceFileSize = sourceFile.length();//����main������static�ģ����в������static�ķ�������ֱ�ӷ��ʷ�static��������͵���Ļ��ͽ���Щ��Ա������Ϊstatic�ˡ�

        // ��ӡִ�б��ʵ��߳�:
        Thread PrintRateThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    //some wrong usages of File.length() method.
//                    System.out.println(String.format("�Ѿ�����:" + ((double)nowFile.length() / sourceFileSize)));
                    // System.out.println("�Ѿ�����:" + nowFile.length());
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    long sizeDestination = CountPathSize.getCountSize(destinationDirectory),
                            sizeSource = CountPathSize.getCountSize(sourceDirectory);
                    double completionRate = sizeDestination * 1.0 / sizeSource;
                    System.out.printf("��ǰ������ɱ�:%.2f%%\n" ,100*completionRate);

                  /*  if ( completionRate == 1) {
                        break;
                    }*/
                /*    if (sizeDestination==sizeSource){
                        System.out.println(sizeDestination==sizeSource);
                        break;
                    }*/
                    if(Thread.currentThread().isInterrupted()){
                        System.out.printf("��ǰ������ɱ�:%.2f%%\n" ,100.00);
                        System.out.println("�ļ��и������");
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

