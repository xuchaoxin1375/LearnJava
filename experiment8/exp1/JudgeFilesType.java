package experiment8.exp1;
/*һ���ж�ָ��Ŀ¼������Ŀ¼��(�ݹ飩
�Ƿ��к�׺��Ϊ.java��.jpg���ļ���
����У���������ļ����ƺ�����Ŀ¼·����
���û�У������**Ŀ¼��û��.java��.jpg�ļ���*/

import java.io.File;
import java.util.Scanner;
/*����Ŀ¼:
D:\OneDrive\Java\ProjectCodeInIDEA\src\experiment3;
D:

* */
public class JudgeFilesType {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("����ָ��Ŀ¼��");
        String dirName = scanner.nextLine();
        /*���õݹ��жϷ�����*/
        enterDirs(dirName);

    }

    /*version1:
    * ���ִ���˲����ķ�ʽ������:D:\ ���޷����ù���.*/
    static void enterDirs(String dir) {
        File file = new File(dir);
        /*�������������dirĿ¼�µĸ�����Ŀ*/
        for (String x : file.list()) {
            String wholeName = dir + File.separator + x;
            if (new File(wholeName).isDirectory()) {
                enterDirs(wholeName);
            } else {
                if (x.length() > 5) {
                    if (x.substring(x.length() - 5).equals(".java")) {
                        System.out.println("�ļ�"+x+"����Ŀ¼Ϊ:"+wholeName);
                    }
                }
                if(x.length()>4){
                    if(x.substring(x.length()-4).equals(".jpg")){
                        System.out.println("�ļ�"+x+"����Ŀ¼Ϊ:"+wholeName);
                    }
                }
                else{
                    System.out.println("Ŀ¼"+dir+"��û��.java��.jpg�ļ�");
                }
            }
        }
    }
}
