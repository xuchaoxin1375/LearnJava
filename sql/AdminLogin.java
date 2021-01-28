package sql;

import java.util.Scanner;

/**
 * @Author xuchaoxin
 * @Date 2021/1/24 9:33
 * @Version 1.0
 * the detail and improved version(if I update it ) to see:
 * the github repository (search the article):https://github.com/xuchaoxin1375/LearnJava
 */
public class AdminLogin {
    public final static String adminNameInner = "root";
    public final static String adminPasswordInner = "root";
    /**
     * 静态方法访问类成员需要传参
     */
    public void adminLogin(/*String adminName,String adminPassword*/) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("输入管理员账号:");
            String adminName = scanner.nextLine();
            System.out.println("输入管理员密码:");
            String password = scanner.nextLine();
            if (adminNameInner.equals(adminName)) {
                if (adminPasswordInner.equals(password)) {
                    System.out.println("登录成功");
                    break;
                }
            } else {
                System.out.println("登录名或密码错误,请重新登录");
            }
        }
    }
}
