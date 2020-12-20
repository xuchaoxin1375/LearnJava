package experiment8;
//待改进
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
    /*调用这个复制函数前,需要检查两个目录是否存在*/
    void copyDir(File sourceDir,File destDir){

        //File[] files = sourceDirName.listFiles();
        File[] files = sourceDir.listFiles();
        for(File x : files){
            if(x.isDirectory()){
                /*在目标目录下创建新的(子)目录.*/
                File dirPlus=new File(destDir.getAbsoluteFile()+File.separator+x.getName());
                dirPlus.mkdir();
                copyDir(x,dirPlus);
            }else {

            }

        }
    }
}
