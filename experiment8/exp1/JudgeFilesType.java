package experiment8.exp1;
/*一、判断指定目录及其子目录下(递归）
是否有后缀名为.java和.jpg的文件，
如果有，就输出该文件名称和所在目录路径，
如果没有，输出“**目录下没有.java和.jpg文件”*/

import java.io.File;
import java.util.Scanner;
/*测试目录:
D:\OneDrive\Java\ProjectCodeInIDEA\src\experiment3;
D:

* */
public class JudgeFilesType {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入指定目录：");
        String dirName = scanner.nextLine();
        /*调用递归判断方法：*/
        enterDirs(dirName);

    }

    /*version1:
    * 这种传入此参数的方式不完美:D:\ 就无法良好工作.*/
    static void enterDirs(String dir) {
        File file = new File(dir);
        /*处理并分析传入的dir目录下的各个条目*/
        for (String x : file.list()) {
            String wholeName = dir + File.separator + x;
            if (new File(wholeName).isDirectory()) {
                enterDirs(wholeName);
            } else {
                if (x.length() > 5) {
                    if (x.substring(x.length() - 5).equals(".java")) {
                        System.out.println("文件"+x+"所在目录为:"+wholeName);
                    }
                }
                if(x.length()>4){
                    if(x.substring(x.length()-4).equals(".jpg")){
                        System.out.println("文件"+x+"所在目录为:"+wholeName);
                    }
                }
                else{
                    System.out.println("目录"+dir+"下没有.java和.jpg文件");
                }
            }
        }
    }
}
