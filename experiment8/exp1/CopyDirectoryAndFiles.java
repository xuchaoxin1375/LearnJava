package experiment8.exp1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class CopyDirectoryAndFiles {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("���뱻����ԴĿ¼��:");
        String sourceDirectory = scanner.nextLine();
        System.out.println("���븱��Ŀ��Ŀ¼��");
        String destinationDirectory = scanner.nextLine();
        /*���õݹ鸴�ƺ���.*/
        copyDir(sourceDirectory, destinationDirectory);

    }

    /*���ݹ鸴�ƺ������м�鲢������Ŀ¼������,*/
    public static void copyDir(String oldPath, String newPath) throws IOException {
        File file = new File(oldPath);
        String[] filePath = file.list();/*//��ǰ·���´��ڵ�Ŀ¼�����ļ���������.�ȽϽ�����list����,���Ƽ���listFile����,��Ϊ����
        Ҫͨ������Ŀ¼����������Ŀ¼,���ַ����ȽϷ���.*/

        /*�����Ŀ¼�Ƿ����.��������,�򴴽�һ�����������1ʹ�õģ��Բ�����β׺��һ����Ҫ��
        ������Щϸ΢���죬���ǵ�һ���Ŀ¼�ṹҪ��ʧ��*/
 /*       if (!(new File(newPath)).exists()) {
            (new File(newPath)).mkdir();//����Ŀ¼
        }*/
        /*����2ʹ�ã���·������β׺û��Ҫ���*/
        if (file.isDirectory()) {
            //System.out.println(file.getName());
            (new File(newPath + File.separator + file.getName())).mkdir();
            newPath = newPath + File.separator + file.getName();
        }
        /*������ǰĿ¼�µ���Ŀ¼���ļ�*/
//        for (int i = 0; i < filePath.length; i++)
        for (String x : filePath) {
            /*�����(x)��һ����Ŀ¼:(ִ�еݹ�)*/
            if ((new File(oldPath + File.separator + x)).isDirectory()) {
                //�˴�������¾�·�����ĺ�׺����һ���ģ�x����β��
                /*����Ϊ�˱�֤ͳһ�ԣ��������ʹ�ã����ô˵ݹ麯��ʱ���Բ�������ʽ�Ͼ�����Լ����
                 * �������з����ѡ��
                 * 1��������ĵ����У��Ͱ�·���������β׺һ�µġ�
                 * 2.�ں����ĵݹ�ı�д�Ͳ�Ҫ��ǰ�����β׺һ�µġ�*/
                //�����������ﳢ��һ��2��
                copyDir(oldPath + File.separator + x, newPath + File.separator);
            }
/*java.io.File
public static final String separator //���separator����java.io������µ�File���һ�������ľ�̬���ǳ���������(��Ա����),
�Ƿ�������ܵķָ��.
The system-dependent default name-separator character, represented as a string for convenience. This string contains a single character, namely separatorChar.*/
            /*���x��ָ���Ǹ��ļ�:ִ�и��Ƽ���*/
            if (new File(oldPath + File.separator + x).isFile()) {
                File source = new File(oldPath + File.separator + x);
                File dest = new File(newPath + File.separator + x);
                if (!(dest.exists())) {
                    Files.copy(source.toPath(), dest.toPath());//Ӧ���������ļ�������
                }

            }
        }//endFor
        System.out.println("The replication operation has been successfully executed!");
    }//endCopyFunction
}