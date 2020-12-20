package experiment7.exp2;

import java.io.File;
import java.util.Scanner;

/*在指定目录下查找一个文件，
如果目录或子目录下存在所要查找的文件，
返回文件所在的目录，否则输出 “当前目录下没有此文件”。*/
public class FindFiles {
    public static void main(String[] args) {

        System.out.println("请输入要查找的文件名:");
        String fileName = new Scanner(System.in).nextLine();//采用链式方法.
        String dir = "D:\\OneDrive\\Java\\ProjectCodeInIDEA\\src\\study\\io";
        File file = new File(dir);
        if (file.exists()) {
            //file.list();//数组没有contains方法(数组在java中不是那么地道的对象,可用的方法不多.(当然你可以考虑将数组转为list)
            boolean flag = false;
            for (String x : file.list()) {
                if (x.equals(fileName)) {//写完.条件x.equals(fileName)后追加.if即可
                    System.out.println("目录" + file.getName() + "/下要查找的文件所在路径:" + file.getPath() +"\\"+ fileName);/*当然可以用listFile()方法,不过可能开销会大些.*/
                    flag = true;
                    break;
                }
            }//endFor
            if (flag == false) {
                System.out.println("目录" + file.getName() + "下没有此文件");
            }//endIf_ii

       /*     System.out.println("file.getPath:"+file.getPath());
            System.out.println("file.getName:"+file.getName());*/

        }//endIf
    }
}//endClass
