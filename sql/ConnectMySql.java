package sql;

import java.sql.*;

public class ConnectMySql {
    /*��Ա����*/
    String url = "jdbc:mysql://10.21.6.18/OnlineShoppingSystem?useSSL=FALSE&serverTimezone=UTC";
    String user = "oss";
    String password = "onlinss";
    Connection connection;

    /*constructor to connect the database (this operation will get a Connection object*/
    public ConnectMySql() {
        //ע������
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

    //�ṩ�������ݿ�ķ����Ľӿ�
    public Connection getConnection() {
        System.out.println("���ݿ����ӳɹ�");
        return connection;
    }
     /*   //�õ�ִ��sql����Statement����(statement:��ʾsql�Ĳ�ѯ���.)
        System.out.println("���ݿ����ӳɹ�");
        Statement stmt = conn.createStatement();//�õ�����ִ��sql���Ĺ��ܵĶ���*/
    /**
     * �ṩ�ر����ݿ����ӵĽӿ�
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
        Statement statement= connectMySql.getConnection().createStatement();//�õ�����ִ��sql���Ĺ��ܵĶ���*/
        return statement;
    }
}
//todo ִ��sql��䣬�����ؽ��
//        ResultSet rs = stmt.executeQuery("select * from Goods");
//        //������
//        //int i=1;
//        while (rs.next()) {
//            /*����������¼�ĸ����ֶ�(����goods��������ֶ�*/
//            for (int i = 1; i <= 5; i++) {
//                System.out.print(rs.getString(i++) + "\t");
//            }
//
//            System.out.println();
//        }
//        //�ر���Դ
//        rs.close();
//        stmt.close();
//        conn.close();
