package sql;

import java.sql.*;

/**
 * ʹ�ñ�����ò�Ҫ���������󣨷����׹ر�connection��
 */
public class ConnectMySql {
    /*��Ա����*/
    static String url = "jdbc:mysql://10.21.6.18/OnlineShoppingSystem?useSSL=FALSE&serverTimezone=UTC";
    static String user = "oss";
    static String password = "onlinss";
    static Connection connection;
    final static String driver = "com.mysql.cj.jdbc.Driver";
    /*�ṩps��Ա�����Ա��ڹر�*/
    PreparedStatement ps;
    ResultSet rs;

    /*constructor to connect the database (this operation will get a Connection object*/
    public ConnectMySql() {
        //ע������
        try {
            Class.forName(driver);
            /*�ڹ��췽����ֱ�ӳ����������ݿ�*/
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //�ṩ�������ݿ�ķ����Ľӿ�(ͨ��)
    public Connection getConnection() {
        //System.out.println("���ݿ����ӳɹ�(�ǵò�����Ϲرսӿ�)");
        /*connection.close()*/
        return connection;
    }
     /*   //�õ�ִ��sql����Statement����(statement:��ʾsql�Ĳ�ѯ���.)
        System.out.println("���ݿ����ӳɹ�");
        Statement stmt = conn.createStatement();//�õ�����ִ��sql���Ĺ��ܵĶ���*/

    /**
     * getStatement()
     * �õ�����ִ��sql���Ĺ��ܵĶ���(���������ֱ��ʹ��getConnection()����(�Ա����ⲿʹ��PrepareStatement)
     */
    public Statement getStatement() throws SQLException {
        //ConnectMySql connectMySql=new ConnectMySql();
        Statement statement = getConnection().createStatement();//�õ�����ִ��sql���Ĺ��ܵĶ���*/
        return statement;
    }

    /**
     * ʹ���ˣ�����ʹ���˱������������closePreparedStatement()����closeAll()������
     *
     * @param sql
     * @return
     * @throws SQLException
     */
    public PreparedStatement getPreparedStatement(String sql) throws SQLException {
        return ps = getConnection().prepareStatement(sql);
    }

    /**
     * ��ȡ��ѯ���ResultSet����
     *
     * @param sql
     * @return
     * @throws SQLException
     */
    public ResultSet getResultSet(String sql) throws SQLException {
        /*����PreparedStatement���е�executeQuery()��������ȡ��ҪResultSet��Ķ���rs*/
        return getPreparedStatement(sql).executeQuery();
    }

    public ResultSetMetaData getResultSetMetaData(String sql) throws SQLException {
        return getResultSet(sql).getMetaData();
    }

    /**
     * ��ȡ��ѯ���ؽ�������������������׷������ã�
     *
     * @param sql
     * @return
     * @throws SQLException
     */
    public int getColumnSize(String sql) throws SQLException {
        /*���ResultSetMetaData����(Ԫ���ݶ���),(��һ������jdbc�еĹؼ�����),�Խ�һ����ȡ����*/
        ResultSetMetaData resultSetMetaData = getResultSetMetaData(sql);
        return resultSetMetaData.getColumnCount();
    }

    public String getColumnNames(String tableName) throws SQLException {
        String sqlColumns = "select * from " + tableName;

        StringBuilder stringBuilder = new StringBuilder();
        ResultSetMetaData resultSetMetaData = getResultSetMetaData(sqlColumns);
        int columnSize = resultSetMetaData.getColumnCount();
        for (int i = 1; i <= columnSize; i++) {
            /*��Ԫ���ݶ����ȡ����(���÷���getColumnName(i))
             * ע��:getColumnName��������ResultSetMetaData�����л�ȡ�����ֶ�(����)������,
             * �������ֶε�ֵ*/
            // System.out.printf("%-12s", resultSetMetaData.getColumnName(i));
            stringBuilder.append(resultSetMetaData.getColumnName(i) + "\t");
        }
        return stringBuilder.toString();
    }

    public void printColumnNames(String sql) throws SQLException {
        // System.out.println("��ѯ�ֶ����������:");
        //ͨ����ȡResultMetaData�����ٻ�ȡ����(�ֶ���),�Դ�ӡ�ֶ���
        ResultSetMetaData resultSetMetaData = getResultSetMetaData(sql);
        int columnSize = resultSetMetaData.getColumnCount();
        for (int i = 1; i <= columnSize; i++) {
            /*��Ԫ���ݶ����ȡ����(���÷���getColumnName(i))
             * ע��:getColumnName��������ResultSetMetaData�����л�ȡ�����ֶ�(����)������,
             * �������ֶε�ֵ*/
            System.out.printf("%-20s", resultSetMetaData.getColumnName(i));
        }
        System.out.println();
    }

    public void printSearchResult(String sql) throws SQLException {
        ResultSet resultSet = getResultSet(sql);
        /*��ӡ���м�¼*/
        //���齫columnSize��ѭ�������һ�²���ס���Ա�����for���ظ����㡣
        int columnSize = getColumnSize(sql);
        while (resultSet.next()) {
            for (int i = 1; i <= columnSize; i++) {
                /*������õ���getObject(i)����ӡ���������͵ĸ��ֶε�ֵ*/
                System.out.printf("%-20s", resultSet.getObject(i));
                // System.out.print("\t\t"+resultSet.getObject(i));
            }
            System.out.println();
        }
        //System.out.println();
        System.out.println("\n������ѯ");
    }

    /*���Է���*/
    public static void main(String[] args) throws SQLException {
        ConnectMySql connectMySql = new ConnectMySql();
        System.out.println(connectMySql.getColumnNames("Goods"));
        connectMySql.closeConnection();
    }
 /*   public   void closeResultSet(String sql) throws SQLException {
        getResultSet(sql).close();
    }*/

    /**
     * �ṩ�ر����ݿ����ӵĽӿ�
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
