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
     * ��̬�����������Ա��Ҫ����
     */
    public void adminLogin(/*String adminName,String adminPassword*/) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("�������Ա�˺�:");
            String adminName = scanner.nextLine();
            System.out.println("�������Ա����:");
            String password = scanner.nextLine();
            if (adminNameInner.equals(adminName)) {
                if (adminPasswordInner.equals(password)) {
                    System.out.println("��¼�ɹ�");
                    break;
                }
            } else {
                System.out.println("��¼�����������,�����µ�¼");
            }
        }
    }
}
