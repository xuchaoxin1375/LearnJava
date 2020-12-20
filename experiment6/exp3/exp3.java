package experiment6.exp3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*依次输入10个不同的整数，一行输入一个整数。
若输入的整数与已经输入的整数相同，则抛出SameIntegerException异常，提示继续输入。
如：输入十个不同整数[10, 23, 39, 22, 48, 77, -2, 30, 8, 99]
*/
public class exp3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入10个不同的整数,一个数一行:");
        List<Integer> list = new ArrayList<>();
        AddDifferentNum obj=new AddDifferentNum();
        for (int i = 0; list.size() < 10; i++) {
            String line = scanner.nextLine();
            int tmp = Integer.parseInt(line);

           try{
               obj.add(list, tmp);
           }catch (SameIntegerException e){
               e.printStackTrace();//区别于getStackTrace();方法.
               System.out.println("请重新输入:");
           }

        }//endFor
        System.out.println("输入的10个不同整数为:\n"+list);

    }//endMain
}
/*测试数据:
10
23
39
10

22
48
39

77
-2
48

30
8
-2

99

*/