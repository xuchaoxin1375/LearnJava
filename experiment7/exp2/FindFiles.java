package experiment7.exp2;

import java.io.File;
import java.util.Scanner;

/*��ָ��Ŀ¼�²���һ���ļ���
���Ŀ¼����Ŀ¼�´�����Ҫ���ҵ��ļ���
�����ļ����ڵ�Ŀ¼��������� ����ǰĿ¼��û�д��ļ�����*/
public class FindFiles {
    public static void main(String[] args) {

        System.out.println("������Ҫ���ҵ��ļ���:");
        String fileName = new Scanner(System.in).nextLine();//������ʽ����.
        String dir = "D:\\OneDrive\\Java\\ProjectCodeInIDEA\\src\\study\\io";
        File file = new File(dir);
        if (file.exists()) {
            //file.list();//����û��contains����(������java�в�����ô�ص��Ķ���,���õķ�������.(��Ȼ����Կ��ǽ�����תΪlist)
            boolean flag = false;
            for (String x : file.list()) {
                if (x.equals(fileName)) {//д��.����x.equals(fileName)��׷��.if����
                    System.out.println("Ŀ¼" + file.getName() + "/��Ҫ���ҵ��ļ�����·��:" + file.getPath() +"\\"+ fileName);/*��Ȼ������listFile()����,�������ܿ������Щ.*/
                    flag = true;
                    break;
                }
            }//endFor
            if (flag == false) {
                System.out.println("Ŀ¼" + file.getName() + "��û�д��ļ�");
            }//endIf_ii

       /*     System.out.println("file.getPath:"+file.getPath());
            System.out.println("file.getName:"+file.getName());*/

        }//endIf
    }
}//endClass
