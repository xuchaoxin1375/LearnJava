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
        /*����Ա��¼:*/
        System.out.println("����Ա��¼:");
        new AdminLogin().adminLogin();
        /*����ϵͳ������ѡ��ִ�ж�Ӧ����*/
        System.out.println("sql��ѯ:(����a)\n" + "�򵥲�ѯ:(����b)");
        Scanner scanner = new Scanner(System.in);
        String option = (scanner.nextLine());
        /*��ӡ���ܲ˵�*/
        printInformation();
        if (option.equals("a")) {
            System.out.println("���빦�ܵı������:");
            /*��ȡ�û�����,�����Ӧ����:*/
            Scanner scannerA = new Scanner(System.in);
            int optionNo = Integer.parseInt(scannerA.nextLine());
            //scannerA.close();
            while (true) {
                /*�ж�����Ĺ���ѡ��*/
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
                System.out.println("������ѯ?(����y����/�����������˳�)");
                Scanner scanner1=new Scanner(System.in);
                String isContinue=scanner1.nextLine().trim();
               // scanner1.close();
                if(!isContinue.equals("y")){
                    break;
                }else{
                    /*��ӡ���ܲ˵�*/
                    printInformation();
                    System.out.println("���빦�ܵı������:");
                    optionNo = Integer.parseInt(scannerA.nextLine());
                }
            }
        }
        else if (option.equals("b")) {
            //todo
            System.out.println("���빦�ܵı������:");
            /*��ȡ�û�����,�����Ӧ����:*/
            Scanner scannerB = new Scanner(System.in);
            int optionNo = Integer.parseInt(scannerB.nextLine());
            //scannerB.close();
            while (true) {
                /*�ж�����Ĺ���ѡ��(�򵥲�ѯ)*/
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
                System.out.println("������ѯ?(����y����/�����������˳�)");
                Scanner scanner1=new Scanner(System.in);
                String isContinue=scanner1.nextLine();
                //scanner1.close();
                if(!isContinue.equals("y")){
                    break;
                }else{
                    /*��ӡ���ܲ˵�*/
                    printInformation();
                    System.out.println("���빦�ܵı������:");
                    optionNo = Integer.parseInt(scannerB.nextLine());
                }
            }//end while
        }
        //scanner.close();

    }

    public static void printInformation() {
        System.out.println("=======\n" +
                "1. ��Ӽ�¼\n" +
                "2. �޸ļ�¼\n" +
                "3. ɾ����¼\n" +
                "4. ��ѯ��¼\n" +
                "5. ��ʾ����\n" +
                "=======\n");
       // System.out.println("Tips:��ͨ�û����Բ�ѯ����ͼ:The_admin\tThe_customer_a\tThe_discuss\tThe_goods\tThe_kinds\tThe_manipulate\tThe_order\t");
    }
}
