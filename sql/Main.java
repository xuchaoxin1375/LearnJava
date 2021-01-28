package sql;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * @Author xuchaoxin
 * @Date 2021/1/24 8:43
 * @Version 1.0
 * the detail and improved version(if I update it ) to see:
 * the github repository (search the article):https://github.com/xuchaoxin1375/LearnJava
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        /*管理员登录:*/
        System.out.println("管理员登录:");
        new AdminLogin().adminLogin();
        /*进入系统后输入选择执行对应功能*/
        System.out.println("sql查询:(输入a)\n" + "简单查询:(输入b)");
        Scanner scanner = new Scanner(System.in);
        String option = (scanner.nextLine());
        /*打印功能菜单*/
        printInformation();
        if (option.equals("a")) {
            System.out.println("输入功能的标号整数:");
            /*读取用户输入,进入对应功能:*/
            Scanner scannerA = new Scanner(System.in);
            int optionNo = Integer.parseInt(scannerA.nextLine());
            //scannerA.close();
            while (true) {
                /*判断输入的功能选项*/
                switch (optionNo) {
                    case 1:
                        UseMySql.insert();
                        break;
                    case 2:
                        UseMySql.update();
                        break;
                    case 3:
                        UseMySql.delete();
                        break;
                    case 4:
                        //System.out.println("what a pity ,the function is not implement yet!(go back)");
                        UseMySql.search();
                        break;
                    case 5:
                        UseMySql.printUsingHelp();
                        break;
                }
                System.out.println("继续查询?(输入y继续/输入其他键退出)");
                Scanner scanner1=new Scanner(System.in);
                String isContinue=scanner1.nextLine().trim();
               // scanner1.close();
                if(!isContinue.equals("y")){
                    break;
                }else{
                    /*打印功能菜单*/
                    printInformation();
                    System.out.println("输入功能的标号整数:");
                    optionNo = Integer.parseInt(scannerA.nextLine());
                }
            }
        }
        else if (option.equals("b")) {
            //todo
            System.out.println("输入功能的标号整数:");
            /*读取用户输入,进入对应功能:*/
            Scanner scannerB = new Scanner(System.in);
            int optionNo = Integer.parseInt(scannerB.nextLine());
            //scannerB.close();
            while (true) {
                /*判断输入的功能选项(简单查询)*/
                switch (optionNo) {
                    case 1:
                        UseMySql.simpleInsert();
                        break;
                    case 2:
                        UseMySql.simpleUpdate();
                        break;
                    case 3:
                        UseMySql.simpleDelete();
                        break;
                    case 4:
                        //SimpleSearch.simpleSearch();
                        UseMySql.simpleSearch();
                        break;
                    case 5:
                        UseMySql.printUsingHelp();
                        break;
                }
                System.out.println("继续查询?(输入y继续/输入其他键退出)");
                Scanner scanner1=new Scanner(System.in);
                String isContinue=scanner1.nextLine();
                //scanner1.close();
                if(!isContinue.equals("y")){
                    break;
                }else{
                    /*打印功能菜单*/
                    printInformation();
                    System.out.println("输入功能的标号整数:");
                    optionNo = Integer.parseInt(scannerB.nextLine());
                }
            }//end while
        }
        //scanner.close();

    }

    public static void printInformation() {
        System.out.println("=======\n" +
                "1. 添加记录\n" +
                "2. 修改记录\n" +
                "3. 删除记录\n" +
                "4. 查询记录\n" +
                "5. 显示帮助\n" +
                "=======\n");
       // System.out.println("Tips:普通用户可以查询的视图:The_admin\tThe_customer_a\tThe_discuss\tThe_goods\tThe_kinds\tThe_manipulate\tThe_order\t");
    }
}
