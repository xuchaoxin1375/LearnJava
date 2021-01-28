package sql;


import java.sql.*;
import java.util.Scanner;

/**
 * @Author xuchaoxin
 * @Date 2021/1/24 8:33
 * @Version 1.0
 * the detail and improved version(if I update it ) to see:
 * the github repository (search the article):https://github.com/xuchaoxin1375/LearnJava
 */
public class SimpleSearch {
    /**
     * �����漰�ĺ�����(��ʵ��)����:ResultSet��,ResultSetMetaData��
     * @return
     */
//    public static void simpleSearch() throws SQLException {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("������Ҫ�鿴�ı�(��ͼ)");
//        System.out.println("��ͨ�ͻ����Բ��ҵı�(��ͼ)");
//        String sql = scanner.nextLine();
//        //todo ִ��sql��䣬�����ؽ��
//        /*��ѯһ����ͼ��������Ϣ*/
//        ConnectMySql connectMySql = new ConnectMySql();
//        /*ִ�в�ѯ�����*/
//        // ResultSet rs = connectMySql.getStatement().executeQuery("select * from " + sqlInquiry);
//        PreparedStatement pstmt = null; //= connectMySql.getConnection().prepareStatement()
//        pstmt = connectMySql.getPreparedStatement("select * from " + sql);
//        ResultSet rs = null;
//        rs = pstmt.executeQuery();
//        ResultSetMetaData rsmd = rs.getMetaData();//Retrieves the number, types and properties of this ResultSet object's columns.
//        while (rs.next()) {
//            for (int i = 0; i < rsmd.getColumnCount(); i++) {
//                String col_name = rsmd.getCatalogName(i + 1);
//                Object value = rs.getObject(col_name);
//                System.out.println(value);
//                /*Field field;//����
//                field=*/
//            }
//        }
//
//        //�ر���Դ����
//        rs.close();
//        connectMySql.closeConnection();
//    }
    /*��õ�ǰʱ��:*/
//    public static String gainTime() {
//        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String dateString = sdf.format(date);
//        return dateString;
//    }
        /*
     * ����ResultSet���SQL��ѯ���
     */
    public static void main(String[] args) throws SQLException {
        System.out.println("testing...");
        ConnectMySql connectMySql = new ConnectMySql();
        System.out.println("����sql��ѯ���:ʾ��:select * from Goods where kid=2");
        Scanner scanner = new Scanner(System.in);
        String sqlSearch = scanner.nextLine();

        /*�Բ�ѯ������д�����ӡ����:*/
        try {
            //��ѯ���
            //String sql1 = "select * from Goods";
            //System.out.println("�򵥲�ѯ:ʾ��:select * from Goods where kid=2");
            //String sqlSearch="select * from "+table+" where kid=2";
//            System.out.println("������Ҫ��ѯ���ֶ�:����:Gid GName");
//            String columns=scanner.nextLine();
//            System.out.println("������Ҫ��ѯ�ı�:ʾ��:The_goods");
//            String tables=scanner.nextLine();
//            System.out.println("�����豾�β�ѯ��Ҫ���������:ʾ��:where kid=2");
//            String where=scanner.nextLine().trim();
            // String sqlSearch="select "+columns+" from "+tables+" "+where;
            /*�����ҽ�sql��ѯ���ֶ����ƵĴ�ӡ������װ����ConnectMySql���ʿ�һ����ӡ��*/
            connectMySql.printColumnNames(sqlSearch);
            connectMySql.printSearchResult(sqlSearch);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //�ر�˳��: ResultSet-->(Prepared)Statement-->Connection
            connectMySql.closeAll();
        }
    }
/*    public static void main(String[] args) throws SQLException{
      //  simpleSearch();
    }*/
//    public static void simpleSearch() {
//        Connection conn = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("������Ҫ��ѯ�ı�:ʾ��:The_goods_a");
//        String tables = scanner.nextLine();
//        /*������ͼ�ֵ�:*/
//        String[] tableArray = tables.split(" ");
//        SqlDictionary sqlDictionary = new SqlDictionary();
//        for (String tableName : tableArray) {
//            sqlDictionary.getInformation(tableName);
//        }
//        try {
//            //ע����
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            //��������
//            conn = new ConnectMySql().getConnection();
//
//            System.out.println("������Ҫ��ѯ���ֶ�(���ŷָ���ͬ�ֶ�):����:Gid,GName");
//            String columns = scanner.nextLine();
//            System.out.println("�����豾�β�ѯ��Ҫ���������:ʾ��:where kid=2");
//            String where = scanner.nextLine().trim();
//            String sqlSearch = "select " + columns + " from " + tables + " " + where;
//            ps = conn.prepareStatement(sqlSearch);
//            rs = ps.executeQuery();
//            //��ȡ����
//            ResultSetMetaData md = rs.getMetaData();
//            int columnSize = md.getColumnCount();
//            System.out.println("��ѯ�������:");
//            //��ӡ�ֶ���
//            for (int i = 1; i <= columnSize; i++) {
//                System.out.printf("%-12s", md.getColumnName(i));
//            }
//            System.out.println();
//            //��ӡ���м�¼
//            while (rs.next()) {
//                for (int i = 1; i <= columnSize; i++) {
//                    System.out.printf("%-12s", rs.getObject(i));
//                }
//                System.out.println();
//            }
//            System.out.println("\n������ѯ");
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            //�ر�˳��: ResultSet-->Statement-->Connection
//            try {
//                if (rs != null) {
//                    rs.close();
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            try {
//                if (ps != null) {
//                    ps.close();
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            try {
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
