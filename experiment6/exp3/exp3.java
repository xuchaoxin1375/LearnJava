package experiment6.exp3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*��������10����ͬ��������һ������һ��������
��������������Ѿ������������ͬ�����׳�SameIntegerException�쳣����ʾ�������롣
�磺����ʮ����ͬ����[10, 23, 39, 22, 48, 77, -2, 30, 8, 99]
*/
public class exp3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("������10����ͬ������,һ����һ��:");
        List<Integer> list = new ArrayList<>();
        AddDifferentNum obj=new AddDifferentNum();
        for (int i = 0; list.size() < 10; i++) {
            String line = scanner.nextLine();
            int tmp = Integer.parseInt(line);

           try{
               obj.add(list, tmp);
           }catch (SameIntegerException e){
               e.printStackTrace();//������getStackTrace();����.
               System.out.println("����������:");
           }

        }//endFor
        System.out.println("�����10����ͬ����Ϊ:\n"+list);

    }//endMain
}
/*��������:
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