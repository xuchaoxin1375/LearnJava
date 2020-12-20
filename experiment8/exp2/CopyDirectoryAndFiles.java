package experiment8.exp2;
//复制目录(拷贝目录)
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class CopyDirectoryAndFiles{
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        //todo read
        System.out.println("输入被复制源目录名:");
        String sourceDirectory = scanner.nextLine();

        System.out.println("输入副本目标目录名");
        String destinationDirectory = scanner.nextLine();

        /*调用递归复制函数.(一句话,实现一个需求)*/
        copyDir(sourceDirectory, destinationDirectory);

    }
/*本递归复制函数具有检查并创建新目录的能力,*/
    static void copyDir(String oldPath, String newPath) throws IOException {
        File file = new File(oldPath);
        String[] filePath = file.list();/*//当前路径下存在的目录名和文件名的数组.比较建议用list方法,不推荐用listFile方法,因为后面
        要通过连接目录名来创建新目录,用字符串比较方便.*/
        /*检查新目录是否存在.若不存在,则创建一个*/
        if (!(new File(newPath)).exists()) {
            (new File(newPath)).mkdir();//创建目录
        }
        /*遍历当前目录下的子目录和文件*/
//        for (int i = 0; i < filePath.length; i++)
        for (String x : filePath) {
            /*如果这(x)是一个子目录:(执行递归)*/
            if ((new File(oldPath + File.separator + x)).isDirectory()) {
                copyDir(oldPath + File.separator + x, newPath + File.separator + x);
            }
/*java.io.File
public static final String separator //这个separator属性java.io软件包下的File类的一个公开的静态且是常量的属性(成员变量),
是方便的智能的分割符.
The system-dependent default name-separator character, represented as a string for convenience. This string contains a single character, namely separatorChar.*/
            /*如果x所指的是个文件:执行复制即可*/
            if (new File(oldPath + File.separator + x).isFile()) {
                File source = new File(oldPath + File.separator + x);
                File dest = new File(newPath + File.separator + x);
                if (!(dest.exists())) {
                    Files.copy(source.toPath(), dest.toPath());//创建新文件的能力
                }

            }
        }//endFor
        //System.out.println("The replication operation has been successfully executed!");
    }//endCopyFunction
}