package sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @Author xuchaoxin
 * @Date 2021/1/24 8:33
 * @Version 1.0
 * the detail and improved version(if I update it ) to see:
 * the github repository (search the article):https://github.com/xuchaoxin1375/LearnJava
 */
public class SimpleSearch {

    public static void simpleSearch() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("������Ҫ�鿴�ı�(��ͼ)");
        String sqlInquiry = scanner.nextLine();
        scanner.close();

        //todo ִ��sql��䣬�����ؽ��
        /*��ѯһ����ͼ��������Ϣ*/
        ResultSet rs = new ConnectMySql().getStatement().executeQuery("select * from "+sqlInquiry);
        //������
        //int i=1;
        while (rs.next()) {
            /*����������¼�ĸ����ֶ�(����goods��������ֶ�*/
            for(int i=1;i<=7;i++){
                System.out.print(rs.getString(i++) + "\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws SQLException {
       /* Scanner scanner = new Scanner(System.in);
        System.out.println("������Ҫ�鿴�ı�(��ͼ)");
        String sqlInquiry = scanner.nextLine();
        scanner.close();*/
        /*   String sql = "insert into Goods values('000261','03','����','n',2,190,'����','ʱ��','����',2,5,'����') ";*/
       /* ConnectMySql connectMySql=new ConnectMySql();
        Statement statement= connectMySql.getConnection().createStatement();*/

//        //todo ִ��sql��䣬�����ؽ��
//        /*��ѯһ����ͼ��������Ϣ*/
//        ResultSet rs = new ConnectMySql().getStatement().executeQuery("select * from "+sqlInquiry);
//        //������
//        //int i=1;
//        while (rs.next()) {
//            /*����������¼�ĸ����ֶ�(����goods��������ֶ�*/
//            for(int i=1;i<=7;i++){
//                System.out.print(rs.getString(i++) + "\t");
//            }
//            System.out.println();
//        }
    }
}
