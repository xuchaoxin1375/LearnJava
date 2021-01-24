package sql;

import java.sql.*;

public class ConnectMySql {
    /*成员变量*/
    String url = "jdbc:mysql://10.21.6.18/OnlineShoppingSystem?useSSL=FALSE&serverTimezone=UTC";
    String user = "oss";
    String password = "onlinss";
    Connection connection;

    /*constructor to connect the database (this operation will get a Connection object*/
    public ConnectMySql() {
        //注册驱动
        String driver = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //提供链接数据库的方法的接口
    public Connection getConnection() {
        System.out.println("数据库连接成功");
        return connection;
    }
     /*   //得到执行sql语句的Statement对象(statement:表示sql的查询语句.)
        System.out.println("数据库连接成功");
        Statement stmt = conn.createStatement();//得到具有执行sql语句的功能的对象*/
    /**
     * 提供关闭数据库链接的接口
     */
    public void closeConnection(){
        try{
            connection.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    /**
     * getStatement()
     */
    public Statement getStatement() throws SQLException {
        ConnectMySql connectMySql=new ConnectMySql();
        Statement statement= connectMySql.getConnection().createStatement();//得到具有执行sql语句的功能的对象*/
        return statement;
    }
}
//todo 执行sql语句，并返回结果
//        ResultSet rs = stmt.executeQuery("select * from Goods");
//        //处理结果
//        //int i=1;
//        while (rs.next()) {
//            /*遍历各条记录的各个字段(比如goods表有五个字段*/
//            for (int i = 1; i <= 5; i++) {
//                System.out.print(rs.getString(i++) + "\t");
//            }
//
//            System.out.println();
//        }
//        //关闭资源
//        rs.close();
//        stmt.close();
//        conn.close();
