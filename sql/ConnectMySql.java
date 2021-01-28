package sql;

import java.sql.*;

/**
 * 使用本类最好不要用匿名对象（否则不易关闭connection）
 */
public class ConnectMySql {
    /*成员变量*/
    static String url = "jdbc:mysql://10.21.6.18/OnlineShoppingSystem?useSSL=FALSE&serverTimezone=UTC";
    static String user = "oss";
    static String password = "onlinss";
    static Connection connection;
    final static String driver = "com.mysql.cj.jdbc.Driver";
    /*提供ps成员变量以便于关闭*/
    PreparedStatement ps;
    ResultSet rs;

    /*constructor to connect the database (this operation will get a Connection object*/
    public ConnectMySql() {
        //注册驱动
        try {
            Class.forName(driver);
            /*在构造方法中直接尝试连接数据库*/
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //提供链接数据库的方法的接口(通用)
    public Connection getConnection() {
        //System.out.println("数据库连接成功(记得操作完毕关闭接口)");
        /*connection.close()*/
        return connection;
    }
     /*   //得到执行sql语句的Statement对象(statement:表示sql的查询语句.)
        System.out.println("数据库连接成功");
        Statement stmt = conn.createStatement();//得到具有执行sql语句的功能的对象*/

    /**
     * getStatement()
     * 得到具有执行sql语句的功能的对象(但更多的是直接使用getConnection()方法(以便在外部使用PrepareStatement)
     */
    public Statement getStatement() throws SQLException {
        //ConnectMySql connectMySql=new ConnectMySql();
        Statement statement = getConnection().createStatement();//得到具有执行sql语句的功能的对象*/
        return statement;
    }

    /**
     * 使用了（或间接使用了本方法）请调用closePreparedStatement()或者closeAll()方法。
     *
     * @param sql
     * @return
     * @throws SQLException
     */
    public PreparedStatement getPreparedStatement(String sql) throws SQLException {
        return ps = getConnection().prepareStatement(sql);
    }

    /**
     * 获取查询结果ResultSet对象
     *
     * @param sql
     * @return
     * @throws SQLException
     */
    public ResultSet getResultSet(String sql) throws SQLException {
        /*调用PreparedStatement类中的executeQuery()方法来获取中要ResultSet类的对象rs*/
        return getPreparedStatement(sql).executeQuery();
    }

    public ResultSetMetaData getResultSetMetaData(String sql) throws SQLException {
        return getResultSet(sql).getMetaData();
    }

    /**
     * 获取查询返回结果的列数（本方法不易反复调用）
     *
     * @param sql
     * @return
     * @throws SQLException
     */
    public int getColumnSize(String sql) throws SQLException {
        /*获得ResultSetMetaData对象(元数据对象),(这一对象是jdbc中的关键对象),以进一步获取列数*/
        ResultSetMetaData resultSetMetaData = getResultSetMetaData(sql);
        return resultSetMetaData.getColumnCount();
    }

    public String getColumnNames(String tableName) throws SQLException {
        String sqlColumns = "select * from " + tableName;

        StringBuilder stringBuilder = new StringBuilder();
        ResultSetMetaData resultSetMetaData = getResultSetMetaData(sqlColumns);
        int columnSize = resultSetMetaData.getColumnCount();
        for (int i = 1; i <= columnSize; i++) {
            /*从元数据对象获取列名(调用方法getColumnName(i))
             * 注意:getColumnName是用来从ResultSetMetaData对象中获取各个字段(属性)的名称,
             * 而不是字段的值*/
            // System.out.printf("%-12s", resultSetMetaData.getColumnName(i));
            stringBuilder.append(resultSetMetaData.getColumnName(i) + "\t");
        }
        return stringBuilder.toString();
    }

    public void printColumnNames(String sql) throws SQLException {
        // System.out.println("查询字段名结果如下:");
        //通过获取ResultMetaData对象，再获取列数(字段数),以打印字段名
        ResultSetMetaData resultSetMetaData = getResultSetMetaData(sql);
        int columnSize = resultSetMetaData.getColumnCount();
        for (int i = 1; i <= columnSize; i++) {
            /*从元数据对象获取列名(调用方法getColumnName(i))
             * 注意:getColumnName是用来从ResultSetMetaData对象中获取各个字段(属性)的名称,
             * 而不是字段的值*/
            System.out.printf("%-20s", resultSetMetaData.getColumnName(i));
        }
        System.out.println();
    }

    public void printSearchResult(String sql) throws SQLException {
        ResultSet resultSet = getResultSet(sql);
        /*打印所有记录*/
        //建议将columnSize在循环外计算一下并记住，以避免在for中重复计算。
        int columnSize = getColumnSize(sql);
        while (resultSet.next()) {
            for (int i = 1; i <= columnSize; i++) {
                /*这里调用的是getObject(i)来打印出各种类型的各字段的值*/
                System.out.printf("%-20s", resultSet.getObject(i));
                // System.out.print("\t\t"+resultSet.getObject(i));
            }
            System.out.println();
        }
        //System.out.println();
        System.out.println("\n结束查询");
    }

    /*测试方法*/
    public static void main(String[] args) throws SQLException {
        ConnectMySql connectMySql = new ConnectMySql();
        System.out.println(connectMySql.getColumnNames("Goods"));
        connectMySql.closeConnection();
    }
 /*   public   void closeResultSet(String sql) throws SQLException {
        getResultSet(sql).close();
    }*/

    /**
     * 提供关闭数据库链接的接口
     */
    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*    public void closeStatement(){

        }*/
    public void closePreparedStatement() {
        try {
            if (ps != null) {
                ps.close();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void closeResultSet() {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void closeAll() {
        closeResultSet();
        closePreparedStatement();
        closeConnection();
    }
}
