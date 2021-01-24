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

        System.out.println("功能菜单:");

        System.out.println("简单查询:(输入1)");

        System.out.println("sql查询:(输入2)");
        int option = (new Scanner(System.in).nextInt());

        if (option == 1) {
            SimpleSearch.simpleSearch();
        } else if (option == 2) {

        }
    }
}
