package experiment10.exp1;
/*�ö��̵߳ķ���ʵ��Ŀ¼����*/

import experiment9.FileName;

import java.util.Scanner;

public class ThreadsCopyMain {
    static int count = 0;


    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        //todo read
        System.out.println("���뱻����ԴĿ¼��:");
        String sourceDirectory = FileName.fileName11_1; //scanner.nextLine();

        System.out.println("���븱��Ŀ��Ŀ¼��");
        String destinationDirectory = "D:\\src"; //scanner.nextLine();
        //��ʱ��ʼ.
        long startTime = System.currentTimeMillis();
        /*���ö��̸߳��ƺ���*/
        CreateCopyPathThreads.copyPath(sourceDirectory, destinationDirectory);
        System.out.println("��������" + CreateCopyPathThreads.getCount() + "���߳�");
        /*���õ��̰߳�Ա�*/
        //SingleThreadCopyPath.copyPath(sourceDirectory,destinationDirectory);
        System.out.println("Ŀ¼�������,����ʱ" + (System.currentTimeMillis() - startTime) + "����");
        // System.out.println("over!");
    }


}
