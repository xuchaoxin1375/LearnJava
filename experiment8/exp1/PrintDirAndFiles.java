package experiment8.exp1;

import java.io.File;
import java.util.Scanner;

public class PrintDirAndFiles {


    public static void main(String[] args) {

        System.out.println("����һ��Ŀ¼��(����·��):");//  D:\OneDrive\Java\ProjectCodeInIDEA\src\experiment3
        /*String dirName1=(new Scanner(System.in)).nextLine();
        String dirName2=new Scanner(System.in).nextLine();*/
        Scanner scanner = new Scanner(System.in);
        String dirName = scanner.nextLine();
// ����File����
        File dir = new File(dirName);//С�Ĳ�Ҫд��:new File("dirName");
// ���ô�ӡĿ¼����
        //printDir(dir);
//�۲�file.list()��Ч��:
/*        for(String x:dir.list()){
            System.out.println(x);
        }*/
        /*
���:
exp1
exp2
exp3
exp4*/
    }

    /*��д(ͨ���ݹ�)��ӡ����(Ŀ¼+�ļ���)�ķ���.
     * ����������������������:����һ��Ŀ¼(��Ȼ�����Ƕ༶Ŀ¼,����ÿ��Ŀ¼�����Լ���Ŀ¼�����ļ�)
     * ���������Ŀ¼Ŀ¼,�����̽������Ŀ¼ִ���������̵Ĳ���,���ֵ������о����ڴ˵�������ݹ鷽��(һ���������,�ʹ���������ӽ��̵���������,�������ӽ�������������ķ�֧����,�ڱ�д����ݹ麯����ʱ�����������,�����������д������)*/
    public static void printDir(File dir) {
// ��ȡ���ļ���Ŀ¼
        File[] files = dir.listFiles();
// ѭ����ӡ
/*
�ж�:
�����ļ�ʱ,��ӡ����·��.
����Ŀ¼ʱ,�������ô�ӡĿ¼�ķ���,�γɵݹ����.
*/
        for (File file : files) {
// �ж�
            if (file.isFile()) {
// ���ļ�,����ļ�����·��
                System.out.println("�ļ���:" + file.getAbsolutePath());
            } else {
// ��Ŀ¼,���Ŀ¼����·��
                System.out.println("Ŀ¼:" + file.getAbsolutePath());
// ��������,����printDir,�γɵݹ�
                printDir(file);

            }

        }

    }

}
