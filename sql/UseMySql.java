package sql;

import java.sql.*;
import java.util.Scanner;

/**
 * @Author xuchaoxin
 * @Date 2021/1/23 22:35
 * @Version 1.0
 * the detail and improved version(if I update it ) to see:
 * the github repository (search the article):https://github.com/xuchaoxin1375/LearnJava
 */
public class UseMySql {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("������Ҫ�鿴�ı�(��ͼ)");
        String sqlInquiry = scanner.nextLine();
        /*   String sql = "insert into Goods values('000261','03','����','n',2,190,'����','ʱ��','����',2,5,'����') ";*/
        ConnectMySql connectMySql=new ConnectMySql();
       Statement statement= connectMySql.getConnection().createStatement();
        //stmt.executeUpdate(sqlInquiry);
        //todo ִ��sql��䣬�����ؽ��
        ResultSet rs = statement.executeQuery("insert into Goods values('000261','03','����','n',2,190,'����','ʱ��','����',2,5,'����') ");//"select * from "+sqlInquiry
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
}
