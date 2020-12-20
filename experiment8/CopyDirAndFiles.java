package experiment8;
//���Ľ�
import java.io.File;
import java.util.Scanner;

public class CopyDirAndFiles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sourceDirectory=scanner.nextLine();
        String destinationDirectory=scanner.nextLine();
        File sourceDirName=new File(sourceDirectory);
        File destDirName=new File(destinationDirectory);
    }
    /*����������ƺ���ǰ,��Ҫ�������Ŀ¼�Ƿ����*/
    void copyDir(File sourceDir,File destDir){

        //File[] files = sourceDirName.listFiles();
        File[] files = sourceDir.listFiles();
        for(File x : files){
            if(x.isDirectory()){
                /*��Ŀ��Ŀ¼�´����µ�(��)Ŀ¼.*/
                File dirPlus=new File(destDir.getAbsoluteFile()+File.separator+x.getName());
                dirPlus.mkdir();
                copyDir(x,dirPlus);
            }else {

            }

        }
    }
}
