package experiment7.exp2;

import namesAndStrings.FileName;

import java.io.File;
import java.util.Scanner;

/*��ָ��Ŀ¼�²���һ���ļ���
���Ŀ¼����Ŀ¼�´�����Ҫ���ҵ��ļ���
�����ļ����ڵ�Ŀ¼��������� ����ǰĿ¼��û�д��ļ�����*/
public class FindFiles {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("������Ҫ���ҵ��ļ���:");
        String fileName = scanner.nextLine();//������ʽ����.
        System.out.println("������Ҫ�����ҵ�Ŀ¼���ҵ�·����:");
        String beSearchedPath = scanner.nextLine();

        //String beSearchedPath = FileName.desktop;
        File file = new File(beSearchedPath);
        /*�жϱ�����Ŀ¼�������*/
        if (file.exists()) {
            //file.list();//����û��contains����(������java�в�����ô�ص��Ķ���,���õķ�������.(��Ȼ����Կ��ǽ�����תΪlist)
            /*Ĭ��û�и��ļ�*/
            boolean flag = false;
            for (String x : file.list()) {
                if (x.equals(fileName)) {//д��.����x.equals(fileName)��׷��.if����
                    System.out.println("Ŀ¼" + file.getName() + "/��Ҫ���ҵ��ļ�����·��:" + file.getPath() + "\\" + fileName);/*��Ȼ������listFile()����,�������ܿ������Щ.*/
                    flag = true;
                    break;//out for
                }
            }//endFor
            /*�ж��Ƿ��ҵ����ļ�.*/
            if (flag == false) {
                System.out.println("Ŀ¼" + file.getName() + "��û�д��ļ�");
            }//endIf_ii

       /*     System.out.println("file.getPath:"+file.getPath());
            System.out.println("file.getName:"+file.getName());*/

        }//endIf
        else {
            System.out.println("there is no such path");
        }
    }//end main
}//endClass
