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
        System.out.println("输入你要查看的表(视图)");
        String sqlInquiry = scanner.nextLine();
        /*   String sql = "insert into Goods values('000261','03','卫衣','n',2,190,'暂无','时尚','北京',2,5,'在售') ";*/
        ConnectMySql connectMySql=new ConnectMySql();
       Statement statement= connectMySql.getConnection().createStatement();
        //stmt.executeUpdate(sqlInquiry);
        //todo 执行sql语句，并返回结果
        ResultSet rs = statement.executeQuery("insert into Goods values('000261','03','卫衣','n',2,190,'暂无','时尚','北京',2,5,'在售') ");//"select * from "+sqlInquiry
        //处理结果
        //int i=1;
        while (rs.next()) {
            /*遍历各条记录的各个字段(比如goods表有五个字段*/
            for(int i=1;i<=7;i++){
                System.out.print(rs.getString(i++) + "\t");
            }
            System.out.println();
        }
    }
}
